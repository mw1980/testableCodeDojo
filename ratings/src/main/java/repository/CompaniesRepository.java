package repository;


import companies.ListedCompany;
import domain.Wkn;

import java.util.Optional;

public interface CompaniesRepository {
    Optional<ListedCompany> companyWithWkn(Wkn wkn);
}
