package testable.ratingsLogic;

import domain.Rating;
import domain.Wkn;
import repository.CompaniesRepository;
import testable.ratingsLogic.api.BusinessFieldRatingAgent;
import testable.ratingsLogic.api.CompanyRatingAgent;
import testable.ratingsLogic.api.RegionRatingAgent;
import testable.ratingsLogic.api.SharesRatingAgent;
import testable.rating.RatingConverter;

import java.util.Optional;

public class DefaultSharesRatingAgent implements SharesRatingAgent {

    private final BusinessFieldRatingAgent businessFieldRatingAgent;
    private final CompanyRatingAgent companyRatingAgent;
    private final RegionRatingAgent regionRatingAgent;
    private final CompaniesRepository companiesRepository;
    private final RatingConverter ratingConverter;

    public DefaultSharesRatingAgent(BusinessFieldRatingAgent businessFieldRatingAgent,
                                    CompanyRatingAgent companyRatingAgent,
                                    RegionRatingAgent regionRatingAgent,
                                    CompaniesRepository companiesRepository,
                                    RatingConverter ratingConverter) {
        this.businessFieldRatingAgent = businessFieldRatingAgent;
        this.companyRatingAgent = companyRatingAgent;
        this.regionRatingAgent = regionRatingAgent;
        this.companiesRepository = companiesRepository;
        this.ratingConverter = ratingConverter;
    }

    @Override
    public Optional<Rating> rate(Wkn wkn) {
        return this.companiesRepository.companyWithWkn(wkn)
                .map(company -> {
                    int evaluatedRating = ratingConverter.convertRatingsToInt(
                            this.regionRatingAgent.rate(company.region()),
                            this.companyRatingAgent.rate(company.wkn()),
                            this.businessFieldRatingAgent.rate(company.businessField())
                    );
                    return ratingConverter.convertIntToRating(evaluatedRating);
                });
    }
}
