package org.jupiter.idea.ui.tree;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Author: Yuri Lytvynenko
 * Date: 06.06.11
 * Time: 23:54
 */
public class NonExistingFileNode extends AbstractTreeNode<String> {
    protected NonExistingFileNode(Project project, String value) {
        super(project, value);
    }

    @NotNull
    @Override
    public Collection<? extends AbstractTreeNode> getChildren() {
        return new LinkedList<AbstractTreeNode>();
    }

    @Override
    protected void update(PresentationData presentation) {
        presentation.setPresentableText(getValue());

    }
}
