package companies;

import domain.BusinessField;
import domain.Rating;
import domain.Region;
import domain.SharePrice;
import domain.Wkn;

public class ListedCompany {

    private final String name;
    private final Wkn wkn;
    private final Rating rating;
    private final SharePrice sharePrice;
    private final Region region;
    private final BusinessField businessField;

    public ListedCompany(String name, Wkn wkn, Rating rating, SharePrice sharePrice, Region region,
                         BusinessField businessField) {
        this.name = name;
        this.wkn = wkn;
        this.rating = rating;
        this.sharePrice = sharePrice;
        this.region = region;
        this.businessField = businessField;
    }

    public String name() {
        return this.name;
    };

    public Wkn wkn() {
        return this.wkn;
    };

    public Rating rating() {
        return this.rating;
    };

    public SharePrice sharePrice() {
        return this.sharePrice;
    };

    public Region region() {
        return this.region;
    };

    public BusinessField businessField(){
        return this.businessField;
    }
}
