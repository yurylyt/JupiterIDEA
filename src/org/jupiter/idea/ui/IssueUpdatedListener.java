package org.jupiter.idea.ui;

import org.jupiter.model.review.ReviewIssue;

import java.util.EventListener;

/**
 * Author: Yuri Lytvynenko
 * Date: 12.06.11
 * Time: 23:07
 */
public interface IssueUpdatedListener extends EventListener {
    void issueUpdated(ReviewIssue issue);
}
