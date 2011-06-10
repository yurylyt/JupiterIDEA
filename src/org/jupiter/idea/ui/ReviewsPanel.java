package org.jupiter.idea.ui;

import com.intellij.ide.util.treeView.AbstractTreeBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.ui.ScrollPaneFactory;
import com.intellij.ui.treeStructure.Tree;
import com.intellij.util.ui.UIUtil;
import org.jupiter.idea.ui.tree.IssueNode;
import org.jupiter.idea.ui.tree.ReviewsTreeStructure;
import org.jupiter.model.review.ReviewIssue;
import org.jupiter.service.ReviewProvider;

import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * Author: Yuri Lytvynenko
 * Date: 05.06.11
 * Time: 16:24
 */
public class ReviewsPanel extends SimpleToolWindowPanel {
    private Project myProject;
    private ReviewProvider reviewProvider;
    private Tree myTree;

    public ReviewsPanel(Project project, ReviewProvider reviewProvider) {
        super(false, true);
        this.myProject = project;
        this.reviewProvider = reviewProvider;
        init();
    }

    private void init() {
        DefaultTreeModel model = new DefaultTreeModel(new DefaultMutableTreeNode());
        myTree = new Tree(model);
//        tree.setRootVisible(false);
        ReviewsTreeStructure treeStructure = new ReviewsTreeStructure(myProject, reviewProvider);
        new AbstractTreeBuilder(myTree, model, treeStructure, null);
        UIUtil.setLineStyleAngled(myTree);
        setContent(ScrollPaneFactory.createScrollPane(myTree));
    }

    public void addTreeSelectionListener(TreeSelectionListener listener) {
        myTree.addTreeSelectionListener(listener);
    }

    public ReviewIssue getSelectedIssue() {
        TreePath path = myTree.getSelectionPath();
        ReviewIssue selected = null;
        if (path != null) {
            DefaultMutableTreeNode element = (DefaultMutableTreeNode) path.getLastPathComponent();
            Object userObject = element.getUserObject();
            if (userObject instanceof IssueNode) {
                selected = ((IssueNode) userObject).getValue();
            }
        }
        return selected;
    }
}
