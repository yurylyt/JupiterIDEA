package org.jupiter.idea.ui;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MultiLineLabelUI;
import com.intellij.openapi.ui.Splitter;
import com.intellij.ui.ScrollPaneFactory;
import com.intellij.util.ui.UIUtil;
import org.jupiter.model.ReviewIssueItem;
import org.jupiter.model.review.Review;
import org.jupiter.service.ReviewManager;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.*;

/**
 * Author: Yuri Lytvynenko
 * Date: 10.06.11
 * Time: 8:44
 */
public class ReviewsUI {
    private Project myProject;
    private ReviewManager reviewManager;
    private ReviewsPanel reviewsPanel;
    private IssuePanel issuePanel;
    private JPanel detailsPanel;
    private CardLayout detailsLayout;
    private Review review;

    public ReviewsUI(Project myProject, ReviewManager reviewManager) {
        this.myProject = myProject;
        this.reviewManager = reviewManager;
    }

    public JComponent create() {
        Splitter splitter = new Splitter(false, 0.55f);
        this.review = reviewManager.getReview("");
        Review review = this.review;
        reviewsPanel = new ReviewsPanel(myProject, review, reviewManager);
        splitter.setFirstComponent(reviewsPanel);
        JComponent details = createDetails();
        splitter.setSecondComponent(details);
        reviewsPanel.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                updateSelection();
            }
        });
//        this.issuePanel.addIssueUpdatedListener(new IssueUpdatedListener() {
//            public void issueUpdated(ReviewIssue issue) {
//                scheduleUpdate(issue);
//            }
//        });
        return splitter;
    }



    private void updateSelection() {
        ReviewIssueItem issueItem = reviewsPanel.getSelectedIssue();
        String paneId = "empty";
        if (issueItem != null) {
            issuePanel.setIssue(issueItem.getReviewIssue());
            paneId = "details";
        }
        detailsLayout.show(detailsPanel, paneId);
    }

    private JComponent createDetails() {
        detailsPanel = new JPanel();
        detailsLayout = new CardLayout();
        detailsPanel.setLayout(detailsLayout);
        detailsPanel.add("empty", createEmptyPanel());
        issuePanel = ServiceManager.getService(myProject, IssuePanel.class);
        detailsPanel.add("details", issuePanel.getComponent());
        detailsLayout.show(detailsPanel, "details");
        return ScrollPaneFactory.createScrollPane(detailsPanel);
    }

    private JPanel createEmptyPanel() {
        final JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBackground(UIUtil.getTableBackground());
        final JLabel label = new JLabel("Nothing selected", JLabel.CENTER);
        label.setUI(new MultiLineLabelUI());
        jPanel.add(label, BorderLayout.CENTER);
//        jPanel.setBorder(BorderFactory.createLineBorder(UIUtil.getBorderColor()));
        return jPanel;
    }
}
