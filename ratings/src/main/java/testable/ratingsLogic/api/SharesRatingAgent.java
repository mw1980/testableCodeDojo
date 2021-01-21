package testable.ratingsLogic.api;

import domain.Rating;
import domain.Wkn;

import java.util.Optional;

public interface SharesRatingAgent {

    /**
     * Calculate a rating estimation for the given wkn.
     */
    Optional<Rating> rate(Wkn wkn);
}
