package testable.ratingsLogic;

import domain.BusinessField;
import domain.Rating;
import testable.ratingsLogic.api.BusinessFieldRatingAgent;

public class DefaultBusinessFieldRatingAgent implements BusinessFieldRatingAgent {
    @Override
    public Rating rate(BusinessField businessField) {
        if (businessField == BusinessField.MANUFACTURING
                || businessField == BusinessField.ASSURANCE
                || businessField == BusinessField.RETAIL) {
            return Rating.BUY;
        } else if (
                businessField == BusinessField.FINANCE
        ) {
            return Rating.HOLD;
        } else {
            return Rating.SELL;
        }
    }
}
