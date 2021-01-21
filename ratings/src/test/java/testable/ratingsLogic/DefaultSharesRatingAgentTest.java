package testable.ratingsLogic;

import companies.ListedCompany;
import domain.BusinessField;
import domain.Rating;
import domain.Region;
import domain.SharePrice;
import domain.Wkn;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import repository.CompaniesRepository;
import testable.rating.RatingConverter;
import testable.ratingsLogic.api.BusinessFieldRatingAgent;
import testable.ratingsLogic.api.CompanyRatingAgent;
import testable.ratingsLogic.api.RegionRatingAgent;
import testable.ratingsLogic.api.SharesRatingAgent;

import java.util.Optional;


public class DefaultSharesRatingAgentTest {

   private BusinessFieldRatingAgent businessFieldRatingAgent = Mockito.mock(BusinessFieldRatingAgent.class);
   private CompanyRatingAgent companyRatingAgent = Mockito.mock(CompanyRatingAgent.class);
   private RegionRatingAgent regionRatingAgent = Mockito.mock(RegionRatingAgent.class);
   private CompaniesRepository companiesRepository = Mockito.mock(CompaniesRepository.class);
   private RatingConverter ratingConverter = new RatingConverter();

   private final SharesRatingAgent underTest = new DefaultSharesRatingAgent(
           businessFieldRatingAgent, companyRatingAgent, regionRatingAgent, companiesRepository, ratingConverter
   );

    @Test
    public void someTest(){
        Wkn wkn =  new Wkn("1223");
        ListedCompany company = new ListedCompany(
                "name",
                wkn,
                Rating.HOLD,
                SharePrice.euro(122.3),
                Region.EUROPE,
                BusinessField.FINANCE
        );

        Mockito.when(companiesRepository.companyWithWkn(wkn)).thenReturn(Optional.of(company));
        Mockito.when(regionRatingAgent.rate(Region.EUROPE)).thenReturn(Rating.BUY);
        Mockito.when(businessFieldRatingAgent.rate(BusinessField.FINANCE)).thenReturn(Rating.BUY);
        Mockito.when(companyRatingAgent.rate(wkn)).thenReturn(Rating.HOLD);

        Optional<Rating> result = underTest.rate(wkn);

        Assert.assertEquals(result.get(), Rating.SELL);
    }

}