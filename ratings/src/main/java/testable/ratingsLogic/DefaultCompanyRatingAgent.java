package testable.ratingsLogic;

import domain.Rating;
import domain.Wkn;
import testable.ratingsLogic.api.CompanyRatingAgent;

public class DefaultCompanyRatingAgent implements CompanyRatingAgent {
    @Override
    public Rating rate(Wkn wkn) {
        if (wkn.value().startsWith("A1")) {
            return Rating.BUY;
        } else if (wkn.value().startsWith("84")) {
            return Rating.HOLD;
        } else {
            return Rating.SELL;
        }
    }
}
