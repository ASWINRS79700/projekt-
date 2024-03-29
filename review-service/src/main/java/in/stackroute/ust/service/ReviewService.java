package in.stackroute.ust.service;

import in.stackroute.ust.domain.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review);

    List<Review> getReviewByMovieId(int id);

    List<Review> getReviewByReviewer(String reviewer);
}
