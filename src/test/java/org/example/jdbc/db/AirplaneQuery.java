package org.example.jdbc.db;

import org.example.jdbc.db.fields.AirplaneFields;
import org.example.jdbc.db.fields.ModelFields;
import org.example.jdbc.db.fields.QueryBuilder;
import org.example.jdbc.dto.AirplaneDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for actions in airplane db table.
 */
public class AirplaneQuery extends DefaultQuery implements AirplaneFields, ModelFields {

    public AirplaneDto getAirplaneById(Long id) {
        AirplaneDto dto;
        try {
            Statement statement = connection.createStatement();
            String query = getAirplaneByIdStringQuery(id);
            ResultSet resultSet = statement.executeQuery(query);
            dto = getAirplaneDto(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }

    private static AirplaneDto getAirplaneDto(ResultSet resultSet) throws SQLException {
        AirplaneDto airplaneDto = null;
        if (resultSet.next()) {
            airplaneDto = new AirplaneDto(
                    resultSet.getInt(AIRPLANE_ID_FIELD_NAME),
                    resultSet.getString(NUMBER_FIELD_NAME),
                    new ModelQuery().getModelById(resultSet.getLong(MODEL_FIELD_NAME)),
                    resultSet.getDate(RELEASE_FIELD_NAME).toLocalDate());
        }
        return airplaneDto;
    }

    private String getAirplaneByIdStringQuery(Long airplaneId) {
        QueryBuilder queryBuilder = getDefaultAirplaneQuery()
                .where().airplaneId().equals().addElement(airplaneId);
        return queryBuilder.build();
    }

    private QueryBuilder getDefaultAirplaneQuery() {
        return new QueryBuilder()
                .select()
                .all()
                .from()
                .airplaneTable()
                .join()
                .modelTable()
                .on().modelId().equals().airplaneModel();
    }
}
