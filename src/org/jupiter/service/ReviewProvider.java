package org.jupiter.service;

import org.jupiter.model.review.Review;

/**
 * Author: Yuri Lytvynenko
 * Date: 29.05.11
 * Time: 12:50
 */
public interface ReviewProvider {
    Review getReview(String id);

    void saveReview(Review review);
}
