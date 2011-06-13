package org.jupiter.idea.ui;

import com.intellij.ide.util.treeView.AbstractTreeBuilder;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.pom.Navigatable;
import com.intellij.ui.PopupHandler;
import com.intellij.ui.ScrollPaneFactory;
import com.intellij.ui.TreeSpeedSearch;
import com.intellij.ui.treeStructure.Tree;
import com.intellij.util.OpenSourceUtil;
import com.intellij.util.ui.UIUtil;
import org.jetbrains.annotations.NonNls;
import org.jupiter.idea.ui.tree.IssueNode;
import org.jupiter.idea.ui.tree.NavigatableReviewItem;
import org.jupiter.idea.ui.tree.ReviewsTreeStructure;
import org.jupiter.model.ReviewIssueItem;
import org.jupiter.model.review.Review;
import org.jupiter.model.review.ReviewIssue;
import org.jupiter.service.ReviewManager;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Author: Yuri Lytvynenko
 * Date: 05.06.11
 * Time: 16:24
 */
public class ReviewsPanel extends SimpleToolWindowPanel implements IssueUpdatedListener {
    private Project myProject;
    private ReviewManager reviewManager;
    private Tree myTree;
    private AbstractTreeBuilder builder;

    public ReviewsPanel(Project project, Review review, ReviewManager reviewManager) {
        super(false, true);
        this.myProject = project;
        this.reviewManager = reviewManager;
        init(review);
    }

    private void init(Review review) {
        DefaultTreeModel model = new DefaultTreeModel(new DefaultMutableTreeNode());
        myTree = new Tree(model);
        ReviewsTreeStructure treeStructure = new ReviewsTreeStructure(myProject, review, reviewManager);
        builder = new AbstractTreeBuilder(myTree, model, treeStructure, null);
        myTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        UIUtil.setLineStyleAngled(myTree);
        setContent(ScrollPaneFactory.createScrollPane(myTree));
        new TreeSpeedSearch(myTree);

        DefaultActionGroup group = new DefaultActionGroup();
        group.add(ActionManager.getInstance().getAction(IdeActions.ACTION_EDIT_SOURCE));
        PopupHandler.installPopupHandler(myTree, group, "ReviewIssuesPopup", ActionManager.getInstance());
        myTree.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent e) {
                        if (!e.isConsumed() && KeyEvent.VK_ENTER == e.getKeyCode()) {
                            OpenSourceUtil.openSourcesFrom(ReviewsPanel.this, false);
                        }
                    }
                }
        );
        setToolbar(createToolbar());
        this.reviewManager.addIssueUpdatedListener(this);
    }

    private JComponent createToolbar() {
        JPanel toolBarPanel = new JPanel(new GridLayout());
        DefaultActionGroup leftGroup = new DefaultActionGroup();

        toolBarPanel.add(
                ActionManager.getInstance().createActionToolbar("reviewViewToolbar", leftGroup, false).getComponent());

        return toolBarPanel;
    }

    public void addTreeSelectionListener(TreeSelectionListener listener) {
        myTree.addTreeSelectionListener(listener);
    }

    public ReviewIssueItem getSelectedIssue() {
        ReviewIssueItem selected = null;
        Object userObject = getSelectedObject();
        if (userObject instanceof IssueNode) {
            selected = ((IssueNode) userObject).getValue();
        }
        return selected;
    }

    public void issueUpdated(ReviewIssue issue) {
        builder.getUi().addSubtreeToUpdate(builder.getRootNode(), false);
    }

    private Object getSelectedObject() {
        if (!builder.getSelectedElements().isEmpty())
            return builder.getSelectedElements().iterator().next();
        return null;
    }

    @Override
    public Object getData(@NonNls String dataId) {
        if (PlatformDataKeys.NAVIGATABLE_ARRAY.is(dataId)) {
            Object selected = getSelectedObject();
            if (selected instanceof NavigatableReviewItem) {
                NavigatableReviewItem item = (NavigatableReviewItem) selected;
                return new Navigatable[]{
                        new OpenFileDescriptor(myProject, item.getVirtualFile(), item.getOffset())
                };
            }
        }
        return super.getData(dataId);
    }

}
