package org.jupiter.idea.ui.tree;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;
import org.jupiter.model.ReviewIssueItem;
import org.jupiter.model.review.Review;
import org.jupiter.model.review.ReviewIssue;
import org.jupiter.service.ReviewManager;

import javax.swing.*;
import java.util.*;

/**
 * Author: Yuri Lytvynenko
 * Date: 06.06.11
 * Time: 23:33
 */
public class ReviewNode extends AbstractTreeNode<Review> {

    private static final Icon JUPITER_ICON = IconLoader.findIcon("/icons/jupiter.gif");
    private Map<String, Collection<ReviewIssueItem>> grouping;
    private ReviewManager reviewManager;

    protected ReviewNode(Project project, Review value, ReviewManager reviewManager) {
        super(project, value);
        this.reviewManager = reviewManager;
    }

    @NotNull
    @Override
    public Collection<? extends AbstractTreeNode> getChildren() {
        Map<String, Collection<ReviewIssueItem>> map = getGrouping();
        PsiManager psiManager = PsiManager.getInstance(myProject);

        Collection<AbstractTreeNode> children = new LinkedList<AbstractTreeNode>();
        for (String file : new TreeSet<String>(map.keySet())) {
            VirtualFile issueFile = getVirtualFile(file);
            PsiFile psifile = issueFile != null ? psiManager.findFile(issueFile) : null;

            if (psifile == null) {
                children.add(new NonExistingFileNode(myProject, file));
            } else {
                children.add(new ReviewFileNode(myProject, psifile, map.get(file)));
            }
        }
        return children;
    }

    @Override
    protected void update(PresentationData presentation) {
        String text = String.format("Found %d issues", getValue().getReviewIssue().size());
        presentation.setPresentableText(text);
        presentation.setIcons(JUPITER_ICON);
    }

    private Map<String, Collection<ReviewIssueItem>> groupByFiles() {
        Map<String, Collection<ReviewIssueItem>> grouping = new HashMap<String, Collection<ReviewIssueItem>>();
        for (ReviewIssue issue : getValue().getReviewIssue()) {
            String fileName = issue.getFile().getValue();
            Collection<ReviewIssueItem> issues = grouping.get(fileName);
            if (issues == null) {
                issues = new LinkedList<ReviewIssueItem>();
                grouping.put(fileName, issues);
            }
            ReviewIssueItem item = new ReviewIssueItem(issue, myProject, getVirtualFile(fileName), reviewManager);

            issues.add(item);
        }
        return grouping;
    }

    private VirtualFile getVirtualFile(String fileName) {
        VirtualFile baseDir = myProject.getBaseDir();
        return baseDir != null ? baseDir.findFileByRelativePath(fileName) : null;
    }

    private Map<String, Collection<ReviewIssueItem>> getGrouping() {
        if (grouping == null) {
            grouping = groupByFiles();
        }
        return grouping;
    }
}
