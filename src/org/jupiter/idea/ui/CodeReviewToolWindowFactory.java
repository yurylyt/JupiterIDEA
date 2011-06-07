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
import com.intellij.psi.PsiManager;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.table.JBTable;
import com.intellij.util.OpenSourceUtil;
import org.jetbrains.annotations.NonNls;
import org.jupiter.model.ValueConstants;
import org.jupiter.model.review.File;
import org.jupiter.model.review.Review;
import org.jupiter.model.review.ReviewIssue;
import org.jupiter.service.ReviewProvider;
import org.jupiter.service.ReviewProviderImpl;

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
 * Author: Iurii Lytvynenko
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
    private JSplitPane splitPane;
    private OldReviewsTableModel tableModel;
    private Project myProject;
    private ReviewProvider provider;

    private Review review;
    private ReviewIssue currentIssue;

    public CodeReviewToolWindowFactory() {
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveReview();
            }
        });

    }

    public void createToolWindowContent(Project project, ToolWindow toolWindow) {
        myProject = project;
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(contentPanel, "Code Review", false);
        toolWindow.getContentManager().addContent(content);
        toolWindow.setAnchor(ToolWindowAnchor.BOTTOM, null);

        provider = new ReviewProviderImpl(project);
        this.review = provider.getReview("");
        tableModel.setReview(review);
        reviewsTable.setAutoCreateRowSorter(true);
        splitPane.setDividerLocation(0.8);
        PsiManager psiManager = PsiManager.getInstance(myProject);
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
        severityCombo = new JComboBox(ValueConstants.SEVERITIES);
        severityCombo.setRenderer(bundleRenderer);

        typeCombo = new JComboBox(ValueConstants.TYPES);
        typeCombo.setRenderer(bundleRenderer);

        resolutionCombo = new JComboBox(ValueConstants.RESOLUTIONS);
        resolutionCombo.setRenderer(bundleRenderer);

        statusCombo = new JComboBox(ValueConstants.STATUSES);
        statusCombo.setRenderer(bundleRenderer);

        assignedToCombo = new JComboBox();
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
                    int index = reviewsTable.getSelectionModel()
                            .getLeadSelectionIndex();
                    setReviewIssue(tableModel.getValue(index));
                }
            }
        });
        ActionListener jumpToSourceListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OpenSourceUtil.openSourcesFrom(CodeReviewToolWindowFactory.this, true);
            }
        };
        reviewsTable.registerKeyboardAction(jumpToSourceListener, KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0),
                JComponent.WHEN_FOCUSED);
    }

    private void setReviewIssue(ReviewIssue value) {
        this.currentIssue = value;

        if (value == null) {
            value = new ReviewIssue();
        }
        severityCombo.setSelectedItem(value.getSeverity());
        typeCombo.setSelectedItem(value.getType());
        assignedToCombo.setSelectedItem(value.getAssignedTo());
        fileText.setText(value.getFile().getValue());
        lineText.setText("" + value.getFile().getLine());
        statusCombo.setSelectedItem(value.getStatus());
        resolutionCombo.setSelectedItem(value.getResolution());
        summaryText.setText(value.getSummary());
        descriptionText.setText(value.getDescription());
    }

    private void saveReview() {
        if (currentIssue != null) {
            currentIssue.setSeverity((String) severityCombo.getSelectedItem());
            currentIssue.setType((String) typeCombo.getSelectedItem());
            currentIssue.getFile().setValue(fileText.getText());
            currentIssue.getFile().setLine(Integer.parseInt(lineText.getText()));
            currentIssue.setStatus((String) statusCombo.getSelectedItem());
            currentIssue.setResolution((String) resolutionCombo.getSelectedItem());
            currentIssue.setSummary(summaryText.getText());
            currentIssue.setDescription(descriptionText.getText());
            provider.saveReview(review);
        }
    }

    public Object getData(@NonNls String dataId) {
        if (PlatformDataKeys.NAVIGATABLE_ARRAY.is(dataId) && currentIssue != null) {
            File issueFile = currentIssue.getFile();
            VirtualFile baseDir = myProject.getBaseDir();
            if (baseDir != null) {
                VirtualFile file = baseDir.findFileByRelativePath(issueFile.getValue());
                if (file != null) {
                    return new Navigatable[] {
                            new OpenFileDescriptor(myProject, file, issueFile.getLine() - 1, 16)
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
