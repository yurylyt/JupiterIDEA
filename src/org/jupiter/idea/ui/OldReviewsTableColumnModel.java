package org.jupiter.idea.ui;

import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Author: Iurii Lytvynenko
 * Date: 29.05.11
 * Time: 16:25
 */
public class OldReviewsTableColumnModel extends DefaultTableColumnModel {
    public OldReviewsTableColumnModel(ResourceBundle bundle) {
        createColumns(bundle);
    }

    private void createColumns(final ResourceBundle bundle) {
        TableCellRenderer bundleRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value != null) {
                    value = bundle.getString(value.toString());
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);    //To change body of overridden methods use File | Settings | File Templates.
            }
        };
        TableColumn column;

        // Severity column
        column = new TableColumn(OldReviewsTableModel.COLUMN_SEVERITY);
        column.setCellRenderer(bundleRenderer);
        column.setHeaderValue(bundle.getString("columnHeader.label.severity"));
        column.setHeaderRenderer(new DefaultTableCellHeaderRenderer());
        column.setMaxWidth(60);
        this.addColumn(column);

        // Type column
        column = new TableColumn(OldReviewsTableModel.COLUMN_TYPE);
        column.setCellRenderer(bundleRenderer);
        column.setHeaderValue(bundle.getString("columnHeader.label.type"));
        column.setMaxWidth(90);
        this.addColumn(column);

        // Status column
        column = new TableColumn(OldReviewsTableModel.COLUMN_STATUS);
        column.setCellRenderer(bundleRenderer);
        column.setHeaderValue(bundle.getString("columnHeader.label.status"));
        column.setMaxWidth(75);
        this.addColumn(column);

        // Summary column
        column = new TableColumn(OldReviewsTableModel.COLUMN_SUMMARY);
        column.setHeaderValue(bundle.getString("columnHeader.label.summary"));
        column.setPreferredWidth(400);
        this.addColumn(column);

//        // File column
//        column = new TableColumn(OldReviewsTableModel.COLUMN_FILE);
//        column.setHeaderValue(bundle.getString("columnHeader.label.file"));
//        this.addColumn(column);
//
//        // Line column
//        column = new TableColumn(OldReviewsTableModel.COLUMN_LINE);
//        this.addColumn(column);
    }
}
