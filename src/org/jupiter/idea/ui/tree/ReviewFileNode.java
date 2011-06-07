package org.jupiter.idea.ui.tree;

import com.intellij.ide.projectView.ViewSettings;
import com.intellij.ide.projectView.impl.nodes.PsiFileNode;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.jupiter.model.review.ReviewIssue;

import java.util.Collection;

/**
 * Author: Iurii Lytvynenko
 * Date: 06.06.11
 * Time: 23:43
 */
public class ReviewFileNode extends PsiFileNode {
    private Collection<ReviewIssue> myChildIssues;

    public ReviewFileNode(Project project, PsiFile value, Collection<ReviewIssue> childIssues) {
        super(project, value, ViewSettings.DEFAULT);
        this.myChildIssues = childIssues;
    }
}
