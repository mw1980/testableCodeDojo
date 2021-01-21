package testable.ratingsLogic;

import domain.Rating;
import domain.Wkn;
import repository.DefaultCompanyRepository;
import testable.rating.RatingConverter;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");
        Optional<Rating> rating = new DefaultSharesRatingAgent(
                new DefaultBusinessFieldRatingAgent(),
                new DefaultCompanyRatingAgent(),
                new DefaultRegionRatingAgent(),
                new DefaultCompanyRepository(),
                new RatingConverter()
        ).rate(new Wkn("A1EWWW"));

        System.out.println(rating.get());
    }
}
