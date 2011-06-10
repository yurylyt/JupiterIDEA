package org.jupiter.idea.ui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MultiLineLabelUI;
import com.intellij.openapi.ui.Splitter;
import com.intellij.util.ui.UIUtil;
import org.jupiter.model.review.ReviewIssue;
import org.jupiter.service.ReviewProvider;

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
    private ReviewProvider reviewProvider;
    private ReviewsPanel reviewsPanel;
    private IssuePanel issuePanel;
    private JPanel detailsPanel;
    private CardLayout detailsLayout;

    public ReviewsUI(Project myProject, ReviewProvider reviewProvider) {
        this.myProject = myProject;
        this.reviewProvider = reviewProvider;
    }

    public JComponent create() {
        Splitter splitter = new Splitter(false, 0.6f);
        reviewsPanel = new ReviewsPanel(myProject, reviewProvider);
        splitter.setFirstComponent(reviewsPanel);
        JComponent details = createDetails();
        splitter.setSecondComponent(details);
        reviewsPanel.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                updateSelection();
            }
        });
        return splitter;
    }

    private void updateSelection() {
        ReviewIssue issue = reviewsPanel.getSelectedIssue();
        detailsLayout.show(detailsPanel, issue != null ? "details" : "empty");
    }

    private JPanel createDetails() {
        detailsPanel = new JPanel();
        detailsLayout = new CardLayout();
        detailsPanel.setLayout(detailsLayout);
        detailsPanel.add("empty", createEmptyPanel());
        issuePanel = new IssuePanel();
        detailsPanel.add("details", issuePanel);
        detailsLayout.show(detailsPanel, "empty");
        return detailsPanel;
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
