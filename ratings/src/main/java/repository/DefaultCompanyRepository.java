package repository;

import companies.ListedCompany;
import domain.BusinessField;
import domain.Rating;
import domain.Region;
import domain.SharePrice;
import domain.Wkn;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DefaultCompanyRepository implements CompaniesRepository {

    private static final ListedCompany ADIDAS = new ListedCompany("Adidas", new Wkn("A1EWWW"), Rating.HOLD, SharePrice.euro(287.3), Region.EUROPE, BusinessField.MANUFACTURING);
    private static final ListedCompany ALLIANZ = new ListedCompany("Allianz", new Wkn("840400"), Rating.SELL, SharePrice.euro(201.3), Region.EUROPE, BusinessField.ASSURANCE);

    private static final List<ListedCompany> registeredCompanies = Arrays.asList(ADIDAS, ALLIANZ);

    @Override
    public Optional<ListedCompany> companyWithWkn(Wkn wkn) {
        return registeredCompanies.stream()
                .filter(company -> company.wkn().value().equals(wkn.value()))
                .findFirst();
    }
}
