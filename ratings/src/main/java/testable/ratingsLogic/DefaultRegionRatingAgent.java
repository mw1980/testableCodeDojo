package testable.ratingsLogic;

import domain.Rating;
import domain.Region;
import testable.ratingsLogic.api.RegionRatingAgent;

public class DefaultRegionRatingAgent implements RegionRatingAgent {

    @Override
    public Rating rate(final Region region) {
        if (region == Region.EUROPE) {
            return Rating.BUY;
        } else if (region == Region.AFRICA || region == Region.AUSTRALIA) {
            return Rating.HOLD;
        } else {
            return Rating.SELL;
        }
    }
}
