package org.example.jooq.db;

import org.example.jooq.db.autocreated.tables.Company;
import org.example.jooq.dto.CompanyDto;

/**
 * Class for actions in company db table.
 */
public class CompanyQuery extends DefaultQuery {

    public CompanyDto getCompanyById(Integer id) {
        return context.select()
                .from(Company.COMPANY)
                .where(Company.COMPANY.ID.eq(id))
                .fetch()
                .map(this::getCompanyDtoByRecord)
                .get(0);
    }

}
