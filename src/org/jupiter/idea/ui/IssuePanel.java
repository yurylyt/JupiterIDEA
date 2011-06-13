package org.jupiter.idea.ui;

import org.jupiter.model.ValueConstants;
import org.jupiter.model.review.ReviewIssue;
import org.jupiter.service.ReviewManager;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ResourceBundle;

/**
 * Author: Yuri Lytvynenko
 * Date: 11.06.11
 * Time: 21:27
 */
public class IssuePanel implements IssueUpdatedListener {
    private JTextField summaryText;
    private JTextArea descritpionText;
    private JTextField lineText;
    private JTextField annotationText;
    private JPanel contentPanel;
    private JComboBox severityCombo;
    private JComboBox typeCombo;
    private JComboBox statusCombo;
    private JComboBox resolutionCombo;

    private boolean suppressNotification;

    private ReviewIssue issue;
    private ReviewManager manager;

    public IssuePanel(ReviewManager manager) {
        this.manager = manager;
        this.manager.addIssueUpdatedListener(this);
        DocumentListener documentListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                notifyUpdated();
            }

            public void removeUpdate(DocumentEvent e) {
                notifyUpdated();
            }

            public void changedUpdate(DocumentEvent e) {
                notifyUpdated();
            }
        };
        summaryText.getDocument().addDocumentListener(documentListener);
        lineText.getDocument().addDocumentListener(documentListener);
        descritpionText.getDocument().addDocumentListener(documentListener);
        annotationText.getDocument().addDocumentListener(documentListener);

        ItemListener itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    notifyUpdated();
                }
            }
        };
        severityCombo.addItemListener(itemListener);
        typeCombo.addItemListener(itemListener);
        statusCombo.addItemListener(itemListener);
        resolutionCombo.addItemListener(itemListener);
    }

    private void notifyUpdated() {
        if (!suppressNotification && isModified(issue)) {
            getIssue(issue);
            manager.fireIssueUpdate(issue);
        }
    }

    public JComponent getComponent() {
        return contentPanel;
    }

    private void createUIComponents() {
        createCombos(ResourceBundle.getBundle("/jupiter"));

    }

    private void createCombos(final ResourceBundle bundle) {
        ListCellRenderer bundleRenderer = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value != null) {
                    value = bundle.getString(value.toString());
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        };
        this.severityCombo = new JComboBox(ValueConstants.SEVERITIES);
        this.severityCombo.setRenderer(bundleRenderer);

        this.typeCombo = new JComboBox(ValueConstants.TYPES);
        this.typeCombo.setRenderer(bundleRenderer);

        this.resolutionCombo = new JComboBox(ValueConstants.RESOLUTIONS);
        this.resolutionCombo.setRenderer(bundleRenderer);

        this.statusCombo = new JComboBox(ValueConstants.STATUSES);
        this.statusCombo.setRenderer(bundleRenderer);
    }

    public void setIssue(ReviewIssue issue) {
        suppressNotification = true;
        this.issue = issue;
        this.severityCombo.setSelectedItem(issue.getSeverity());
        this.typeCombo.setSelectedItem(issue.getType());
        this.lineText.setText("" + issue.getFile().getLine());
        this.summaryText.setText(issue.getSummary());
        this.descritpionText.setText(issue.getDescription());
        this.resolutionCombo.setSelectedItem(issue.getResolution());
        this.statusCombo.setSelectedItem(issue.getStatus());
        this.annotationText.setText(issue.getAnnotation());
        suppressNotification = false;
    }

    public void getIssue(ReviewIssue issue) {

        issue.setSeverity(this.severityCombo.getSelectedItem().toString());
        issue.setType(this.typeCombo.getSelectedItem().toString());

        // Set line
        try {
            String text = this.lineText.getText();
            if (text.isEmpty())
                text = "0";
            issue.getFile().setLine(Integer.parseInt(text));
        } catch (NumberFormatException e) {
            // do nothing
        }

        issue.setSummary(this.summaryText.getText());
        issue.setDescription(this.descritpionText.getText());
        issue.setResolution(this.resolutionCombo.getSelectedItem().toString());
        issue.setStatus(this.statusCombo.getSelectedItem().toString());
        issue.setAnnotation(this.annotationText.getText());
    }

    public boolean isModified(ReviewIssue data) {
        if (!emptyEquals(severityCombo.getSelectedItem(), data.getSeverity()))
            return true;
        if (!emptyEquals(typeCombo.getSelectedItem(), data.getType()))
            return true;
        if (!emptyEquals(lineText.getText(), data.getFile().getLine()))
            return true;
        if (!emptyEquals(summaryText.getText(), data.getSummary())) {
            return true;
        }
        if (!emptyEquals(descritpionText.getText(), data.getDescription()))
            return true;

        if (!emptyEquals(resolutionCombo.getSelectedItem(), data.getResolution()))
            return true;
        if (!emptyEquals(statusCombo.getSelectedItem(), data.getStatus())) {
            return true;
        }
        if (!emptyEquals(annotationText.getText(), data.getAnnotation()))
            return true;
        return false;
    }

    private boolean emptyEquals(Object o1, Object o2) {
        return o1 != null ? o1.equals(o2) : o2 == null;
    }


    public void issueUpdated(ReviewIssue issue) {
        // TODO: this way will work until there is only one instance per instance.
        // TODO: Do it in a nicer way.
        setIssue(this.issue); // Reset values from the issue.
    }
}
