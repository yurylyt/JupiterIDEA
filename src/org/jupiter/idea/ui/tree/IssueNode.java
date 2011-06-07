package org.jupiter.idea.ui.tree;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jupiter.model.review.ReviewIssue;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Author: Iurii Lytvynenko
 * Date: 07.06.11
 * Time: 7:50
 */
public class IssueNode extends AbstractTreeNode<ReviewIssue> {

    protected IssueNode(Project project, ReviewIssue value) {
        super(project, value);
    }

    @NotNull
    @Override
    public Collection<? extends AbstractTreeNode> getChildren() {
        return new LinkedList<AbstractTreeNode>();
    }

    @Override
    protected void update(PresentationData presentation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
