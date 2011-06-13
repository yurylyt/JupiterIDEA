package org.jupiter.service;

import org.jupiter.idea.ui.IssueUpdatedListener;
import org.jupiter.model.review.Review;
import org.jupiter.model.review.ReviewIssue;

/**
 * Author: Yuri Lytvynenko
 * Date: 29.05.11
 * Time: 12:50
 */
public interface ReviewManager {
    Review getReview(String id);

    void saveReview(Review review);

    void fireIssueUpdate(ReviewIssue issue);

    void addIssueUpdatedListener(IssueUpdatedListener l);

    void removeIssueUpdatedListener(IssueUpdatedListener l);
}
