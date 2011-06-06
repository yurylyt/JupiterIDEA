package org.jupiter.service;

import org.jupiter.model.review.Review;

/**
 * Author: Iurii Lytvynenko
 * Date: 29.05.11
 * Time: 12:50
 */
public interface ReviewProvider {
    Review getReview(String id);

    void saveReview(Review review);
}
