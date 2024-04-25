package org.example.jdbc.db;

import org.example.jdbc.db.fields.ModelFields;
import org.example.jdbc.db.fields.QueryBuilder;
import org.example.jdbc.dto.ModelDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for actions in model db table.
 */
public class ModelQuery extends DefaultQuery implements ModelFields {

    public ModelDto getModelById(Long id)
            throws SQLException {
        ModelDto modelDto;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                getModelByIdStringQuery(id));
        modelDto = getModelByResultSet(resultSet);
        return modelDto;
    }

    private String getModelByIdStringQuery(Long id) {
        QueryBuilder queryBuilder = getDefaultModelQuery()
                .where().modelId().equals().addElement(id);
        return queryBuilder.build();
    }

    public static ModelDto getModelByResultSet(ResultSet resultSet) throws SQLException {
        ModelDto modelDto = null;
        if (resultSet.next()) {
            modelDto = new ModelDto(
                    resultSet.getInt(MODEL_ID_FIELD_NAME),
                    resultSet.getString(MODEL_NAME_FIELD_NAME),
                    new CompanyQuery().getCompanyById(resultSet.getLong(COMPANY_FIELD_NAME)));
        }
        return modelDto;
    }

    private QueryBuilder getDefaultModelQuery() {
        return new QueryBuilder()
                .select()
                .all()
                .from()
                .modelTable();
    }
}
