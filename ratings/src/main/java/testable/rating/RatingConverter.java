package testable.rating;

import domain.Rating;

import java.util.Arrays;

public class RatingConverter {

    public int convertSingleRatingToInt(Rating rating) {
        if (rating == Rating.UNKNOWN || rating == Rating.SELL) {
            return 0;
        } else if (rating == Rating.HOLD) {
            return 1;
        } else {
            return 2;
        }
    }

    public int convertRatingsToInt(Rating... ratings) {
        return Arrays.stream(ratings)
                .map(this::convertSingleRatingToInt)
                .reduce(0, Integer::sum);
    }

    public Rating convertIntToRating(int value) {
        if (value >= 4) {
            return Rating.BUY;
        } else if (value > 2) {
            return Rating.HOLD;
        } else {
            return Rating.SELL;
        }

    }
}
