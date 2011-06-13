package org.jupiter.model;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.RangeMarker;
import com.intellij.openapi.editor.event.DocumentAdapter;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.ex.MarkupModelEx;
import com.intellij.openapi.editor.markup.GutterIconRenderer;
import com.intellij.openapi.editor.markup.HighlighterLayer;
import com.intellij.openapi.editor.markup.RangeHighlighter;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jupiter.idea.ui.IssueUpdatedListener;
import org.jupiter.model.review.ReviewIssue;
import org.jupiter.service.ReviewManager;

import javax.swing.*;

/**
 * Author: Yuri Lytvynenko
 * Date: 13.06.11
 * Time: 23:54
 */
public class ReviewIssueItem implements IssueUpdatedListener {
    private static final Icon JUPITER_ICON = IconLoader.findIcon("/icons/jupiter.gif");
    private ReviewIssue reviewIssue;
    private VirtualFile myVirtualFile;
    private Project myProject;
    private RangeHighlighter myHighlighter;
    private Document myDocument;
    private ReviewManager reviewManager;

    public ReviewIssueItem(ReviewIssue reviewIssue, Project project, VirtualFile virtualFile, ReviewManager reviewManager) {
        this.reviewIssue = reviewIssue;
        this.myProject = project;
        this.myVirtualFile = virtualFile;
        this.reviewManager = reviewManager;
        this.reviewManager.addIssueUpdatedListener(this);
        if (this.myVirtualFile != null) {
            createHighlighter();
        }
    }

    private synchronized void createHighlighter() {
        myDocument = FileDocumentManager.getInstance().getDocument(myVirtualFile);
        if (myDocument != null) {
            MarkupModelEx markup = (MarkupModelEx) myDocument.getMarkupModel(myProject);
            if (myHighlighter != null) {
                markup.removeHighlighter(myHighlighter);
                myHighlighter.dispose();

            }
            int line = reviewIssue.getFile().getLine() - 1;
            if (line >= myDocument.getLineCount()) {
                line = myDocument.getLineCount() -1;
            } else if (line < 0) {
                line = 0;
            }

            myHighlighter = markup.addLineHighlighter(line,
                    HighlighterLayer.ERROR + 1, null);
            myHighlighter.setGutterIconRenderer(new MyGutterIconRenderer(reviewIssue.getId()));
            myDocument.addDocumentListener(new MyDocumentListener());
        }

    }

    private void updateOffset() {
        int documentLine;
        try {
            documentLine = myDocument.getLineNumber(myHighlighter.getStartOffset());
        } catch (Exception e) {
            documentLine = -1;
        }
        int issueLine = reviewIssue.getFile().getLine();
        if (documentLine != issueLine) {
            createHighlighter();
        }
    }

    private void checkOffset() {
        if (myHighlighter.isValid()) {
            int documentLine = myDocument.getLineNumber(myHighlighter.getStartOffset()) + 1;
            int issueLine = reviewIssue.getFile().getLine();
            if (documentLine != issueLine) {
                reviewIssue.getFile().setLine(documentLine);
                fireUpdate();
            }
        } else {
            // TODO: Handle highlighter invalidation case
        }
    }

    public ReviewIssue getReviewIssue() {
        return reviewIssue;
    }

    public RangeMarker getRangeMarker() {
        return myHighlighter;
    }

    public VirtualFile getVirtualFile() {
        return myVirtualFile;
    }

    public void fireUpdate() {
        reviewManager.fireIssueUpdate(reviewIssue);
    }

    public void issueUpdated(ReviewIssue issue) {
        if (issue.getId().equals(this.reviewIssue.getId())) {
            updateOffset();
        }
    }

    private class MyGutterIconRenderer extends GutterIconRenderer {
        private String id;

        private MyGutterIconRenderer(String id) {
            this.id = id;
        }

        @NotNull
        @Override
        public String getTooltipText() {
            return ReviewIssueItem.this.reviewIssue.getSummary();
        }

        @NotNull
        @Override
        public Icon getIcon() {
            return JUPITER_ICON;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof MyGutterIconRenderer &&
                    Comparing.equal(id, ((MyGutterIconRenderer) obj).id);
        }

        @Override
        public int hashCode() {
            return this.id.hashCode();
        }
    }

    private class MyDocumentListener extends DocumentAdapter {
        public void documentChanged(DocumentEvent event) {
            checkOffset();
        }
    }
}
