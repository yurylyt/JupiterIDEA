package org.jupiter.idea.ui;

import org.jupiter.model.review.Review;
import org.jupiter.model.review.ReviewIssue;

import javax.swing.table.AbstractTableModel;

/**
 * Author: Iurii Lytvynenko
 * Date: 29.05.11
 * Time: 12:41
 */
public class OldReviewsTableModel extends AbstractTableModel {
    public static final int COLUMN_SEVERITY = 0;
    public static final int COLUMN_TYPE = 1;
    public static final int COLUMN_SUMMARY = 2;
    public static final int COLUMN_FILE = 3;
    public static final int COLUMN_LINE = 4;
    public static final int COLUMN_RESOLUTION = 5;
    public static final int COLUMN_STATUS = 6;
    private Review review;

    public int getRowCount() {
        return review.getReviewIssue().size();
    }

    public int getColumnCount() {
        return 20; // Handled by a column model
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        ReviewIssue issue = getValue(rowIndex);
        String value = null;
        switch (columnIndex) {
            case COLUMN_SEVERITY:
                value = issue.getSeverity();
                break;
            case COLUMN_TYPE:
                value = issue.getType();
                break;
            case COLUMN_SUMMARY:
                value = issue.getSummary();
                break;
            case COLUMN_FILE:
                value = issue.getFile().getValue();
                break;
            case COLUMN_LINE:
                value = "" + issue.getFile().getLine();
                break;
            case COLUMN_RESOLUTION:
                value = issue.getResolution();
                break;
            case COLUMN_STATUS:
                value = issue.getStatus();
                break;
        }
        return value;
    }

    public ReviewIssue getValue(int rowIndex) {
        return review.getReviewIssue().get(rowIndex);
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
