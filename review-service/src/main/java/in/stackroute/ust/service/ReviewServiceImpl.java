package in.stackroute.ust.service;

import com.netflix.discovery.converters.Auto;
import in.stackroute.ust.domain.Review;
import in.stackroute.ust.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    ReviewRepository reviewRepository;
    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewByMovieId(int id) {
        return reviewRepository.findByMovieId(id);
    }

    @Override
    public List<Review> getReviewByReviewer(String reviewer) {
        return reviewRepository.findReviewByReviewer(reviewer);
    }
}
