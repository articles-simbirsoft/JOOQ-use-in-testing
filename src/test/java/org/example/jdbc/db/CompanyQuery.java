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
        CompanyDto companyDto;
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
        CompanyDto facilityResponseModel = null;
        if (resultSet.next()) {
            facilityResponseModel = new CompanyDto(
                    resultSet.getInt(COMPANY_ID_FIELD_NAME),
                    resultSet.getString(COMPANY_NAME_FIELD_NAME));
        }
        return facilityResponseModel;
    }

    private QueryBuilder getDefaultCompanyQuery() {
        return new QueryBuilder()
                .select()
                .all()
                .from()
                .companyTable();
    }
}
