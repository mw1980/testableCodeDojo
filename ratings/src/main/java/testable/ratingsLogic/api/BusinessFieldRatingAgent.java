package testable.ratingsLogic.api;

import domain.BusinessField;
import domain.Rating;

public interface BusinessFieldRatingAgent {
    Rating rate(BusinessField businessField);
}
