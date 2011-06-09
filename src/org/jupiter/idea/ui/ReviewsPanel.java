package org.jupiter.idea.ui;

import com.intellij.ide.util.treeView.AbstractTreeBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.ui.ScrollPaneFactory;
import com.intellij.ui.treeStructure.Tree;
import com.intellij.util.ui.UIUtil;
import org.jupiter.idea.ui.tree.ReviewsTreeStructure;
import org.jupiter.service.ReviewProvider;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * Author: Iurii Lytvynenko
 * Date: 05.06.11
 * Time: 16:24
 */
public class ReviewsPanel extends SimpleToolWindowPanel {
    private Project myProject;
    private ReviewProvider reviewProvider;

    public ReviewsPanel(Project project, ReviewProvider reviewProvider) {
        super(false, true);
        this.myProject = project;
        this.reviewProvider = reviewProvider;
        init();
    }

    private void init() {
        DefaultTreeModel model = new DefaultTreeModel(new DefaultMutableTreeNode());
        Tree tree = new Tree(model);
//        tree.setRootVisible(false);
        ReviewsTreeStructure treeStructure = new ReviewsTreeStructure(myProject, reviewProvider);
        AbstractTreeBuilder builder = new AbstractTreeBuilder(tree, model, treeStructure, null);
        UIUtil.setLineStyleAngled(tree);
        setContent(ScrollPaneFactory.createScrollPane(tree));
    }
}
