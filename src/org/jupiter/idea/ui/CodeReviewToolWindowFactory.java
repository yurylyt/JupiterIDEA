package org.jupiter.idea.ui;

import com.intellij.openapi.actionSystem.DataProvider;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.fileTypes.FileTypeEvent;
import com.intellij.openapi.fileTypes.FileTypeListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.pom.Navigatable;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.table.JBTable;
import com.intellij.util.OpenSourceUtil;
import org.jetbrains.annotations.NonNls;
import org.jupiter.model.ValueConstants;
import org.jupiter.model.review.File;
import org.jupiter.model.review.Review;
import org.jupiter.model.review.ReviewIssue;
import org.jupiter.service.ReviewManager;
import org.jupiter.service.ReviewManagerImpl;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

/**
 * Author: Yuri Lytvynenko
 * Date: 28.05.11
 * Time: 18:14
 */
public class CodeReviewToolWindowFactory implements ToolWindowFactory, DataProvider {
//    private static
    private JPanel contentPanel;
    private JTable reviewsTable;
    private JComboBox severityCombo;
    private JComboBox typeCombo;
    private JTextField summaryText;
    private JTextArea descriptionText;
    private JComboBox assignedToCombo;
    private JComboBox resolutionCombo;
    private JTextField fileText;
    private JComboBox statusCombo;
    private JToolBar toolbar;
    private JButton saveButton;
    private JTextField lineText;
    private JTextField annotationText;
    private JSplitPane splitPane;
    private OldReviewsTableModel tableModel;
    private Project myProject;
    private ReviewManager manager;

    private Review review;
    private ReviewIssue currentIssue;

    public CodeReviewToolWindowFactory() {
        this.saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveReview();
            }
        });

    }

    public void createToolWindowContent(Project project, ToolWindow toolWindow) {
        this.myProject = project;
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(this.contentPanel, "Code Review", false);
        toolWindow.getContentManager().addContent(content);
        toolWindow.setAnchor(ToolWindowAnchor.BOTTOM, null);

        manager = new ReviewManagerImpl(project);
        this.review = manager.getReview("");
        tableModel.setReview(review);
        reviewsTable.setAutoCreateRowSorter(true);
        splitPane.setDividerLocation(0.8);
    }

    private void createUIComponents() {
        ResourceBundle bundle = ResourceBundle.getBundle("/jupiter");
        createTable(bundle);
        createCombos(bundle);
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

        this.assignedToCombo = new JComboBox();
    }

    private void createTable(ResourceBundle bundle) {
        TableColumnModel columnModel = new OldReviewsTableColumnModel(bundle);

        tableModel = new OldReviewsTableModel();
        reviewsTable = new JBTable(tableModel);
        reviewsTable.setColumnModel(columnModel);
        reviewsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        reviewsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int index = CodeReviewToolWindowFactory.this.reviewsTable
                            .getSelectionModel()
                            .getLeadSelectionIndex();
                    setReviewIssue(CodeReviewToolWindowFactory.this.tableModel
                                           .getValue(index));
                }
            }
        });
        ActionListener jumpToSourceListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OpenSourceUtil.openSourcesFrom(CodeReviewToolWindowFactory.this, true);
            }
        };
        this.reviewsTable.registerKeyboardAction(jumpToSourceListener, KeyStroke
                .getKeyStroke(KeyEvent.VK_F4, 0),
                                                 JComponent.WHEN_FOCUSED);
    }

    private void setReviewIssue(ReviewIssue value) {
        this.currentIssue = value;

        if (value == null) {
            value = new ReviewIssue();
        }
        this.severityCombo.setSelectedItem(value.getSeverity());
        this.typeCombo.setSelectedItem(value.getType());
        this.assignedToCombo.setSelectedItem(value.getAssignedTo());
        this.fileText.setText(value.getFile().getValue());
        this.lineText.setText("" + value.getFile().getLine());
        this.statusCombo.setSelectedItem(value.getStatus());
        this.resolutionCombo.setSelectedItem(value.getResolution());
        this.summaryText.setText(value.getSummary());
        this.descriptionText.setText(value.getDescription());
        this.annotationText.setText(value.getAnnotation());
    }

    private void saveReview() {
        if (this.currentIssue != null) {
            this.currentIssue
                    .setSeverity((String) this.severityCombo.getSelectedItem());
            this.currentIssue.setType((String) this.typeCombo.getSelectedItem());
            this.currentIssue.getFile().setValue(this.fileText.getText());
            this.currentIssue.getFile().setLine(
                    Integer.parseInt(this.lineText.getText()));
            this.currentIssue
                    .setStatus((String) this.statusCombo.getSelectedItem());
            this.currentIssue.setResolution(
                    (String) this.resolutionCombo.getSelectedItem());
            this.currentIssue.setSummary(this.summaryText.getText());
            this.currentIssue.setDescription(this.descriptionText.getText());
            this.currentIssue.setAnnotation(this.annotationText.getText());
            this.manager.saveReview(this.review);
        }
    }

    public Object getData(@NonNls String dataId) {
        if (PlatformDataKeys.NAVIGATABLE_ARRAY.is(dataId) && this.currentIssue
                != null) {
            File issueFile = this.currentIssue.getFile();
            VirtualFile baseDir = this.myProject.getBaseDir();
            if (baseDir != null) {
                VirtualFile file = baseDir.findFileByRelativePath(issueFile.getValue());
                if (file != null) {
                    return new Navigatable[] {
                            new OpenFileDescriptor(this.myProject, file, issueFile.getLine() - 1, 16)
                    };

                }
            }
        }
        return null;
    }

    private class MyFileTypeListener implements FileTypeListener {
        public void beforeFileTypesChanged(FileTypeEvent event) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void fileTypesChanged(FileTypeEvent event) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
