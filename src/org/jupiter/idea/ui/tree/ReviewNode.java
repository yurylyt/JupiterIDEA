package org.jupiter.idea.ui.tree;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;
import org.jupiter.model.review.Review;
import org.jupiter.model.review.ReviewIssue;

import java.util.*;

/**
 * Author: Iurii Lytvynenko
 * Date: 06.06.11
 * Time: 23:33
 */
public class ReviewNode extends AbstractTreeNode<Review> {
    protected ReviewNode(Project project, Review value) {
        super(project, value);
    }

    @NotNull
    @Override
    public Collection<? extends AbstractTreeNode> getChildren() {
        Map<String, Collection<ReviewIssue>> map = groupByFiles();
        VirtualFile baseDir = myProject.getBaseDir();
        PsiManager psiManager = PsiManager.getInstance(myProject);

        Collection<AbstractTreeNode> children = new LinkedList<AbstractTreeNode>();
        if (baseDir != null) {
            for (String file : new TreeSet<String>(map.keySet())) {
                VirtualFile issueFile = baseDir.findFileByRelativePath(file);
                PsiFile psifile = issueFile != null ? psiManager.findFile(issueFile) : null;

                if (psifile == null) {
                    children.add(new NonExistingFileNode(myProject, "N/A: " + file));
                } else {
                    children.add(new ReviewFileNode(myProject, psifile, map.get(file)));
                }
            }

        }
        return children;
    }

    @Override
    protected void update(PresentationData presentation) {
        // Do nothing for now
    }

    private Map<String, Collection<ReviewIssue>> groupByFiles() {
        Map<String, Collection<ReviewIssue>> result = new HashMap<String, Collection<ReviewIssue>>();
        for (ReviewIssue issue : getValue().getReviewIssue()) {
            Collection<ReviewIssue> issues = result.get(issue.getFile().getValue());
            if (issues == null) {
                issues = new LinkedList<ReviewIssue>();
                result.put(issue.getFile().getValue(), issues);
            }
            issues.add(issue);
        }
        return result;
    }
}
