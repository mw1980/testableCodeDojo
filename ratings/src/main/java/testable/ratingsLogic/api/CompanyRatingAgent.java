package testable.ratingsLogic.api;

import domain.Rating;
import domain.Wkn;

public interface CompanyRatingAgent {
    Rating rate(Wkn wkn);
}
