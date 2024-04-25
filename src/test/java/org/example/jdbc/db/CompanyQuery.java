package org.example.jdbc.db;

import org.example.jdbc.db.fields.CompanyFields;
import org.example.jdbc.db.fields.QueryBuilder;
import org.example.jdbc.dto.CompanyDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for actions in company db table.
 */
public class CompanyQuery extends DefaultQuery implements CompanyFields {

    public CompanyDto getCompanyById(Long id)
            throws SQLException {
        CompanyDto companyDto = null;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                getCompanyByIdStringQuery(id));
        companyDto = getCompanyByResultSet(resultSet);
        return companyDto;
    }

    private String getCompanyByIdStringQuery(Long id) {
        QueryBuilder queryBuilder = getDefaultCompanyQuery()
                .where().companyId().equals().addElement(id);
        return queryBuilder.build();
    }

    public static CompanyDto getCompanyByResultSet(ResultSet resultSet) throws SQLException {
        CompanyDto companyDto = null;
        if (resultSet.getInt(COMPANY_ID_FIELD) != 0) {
            companyDto = new CompanyDto(
                    resultSet.getInt(COMPANY_ID_FIELD),
                    resultSet.getString(COMPANY_NAME_FIELD));
        }
        return companyDto;
    }

    private QueryBuilder getDefaultCompanyQuery() {
        return new QueryBuilder()
                .select()
                .all()
                .from()
                .companyTable();
    }
}
