package org.example.jdbc.db;

import org.example.jdbc.db.fields.AirplaneFields;
import org.example.jdbc.db.fields.ModelFields;
import org.example.jdbc.db.fields.QueryBuilder;
import org.example.jdbc.dto.AirplaneDto;
import org.example.jdbc.dto.ModelDto;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for actions in airplane db table.
 */
public class AirplaneQuery extends DefaultQuery implements AirplaneFields, ModelFields {

    public AirplaneDto getAirplaneById(Long id) {
        AirplaneDto dto = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    getAirplaneByIdStringQuery(id));
            resultSet.next();
            dto = getAirplaneDto(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }

    private static AirplaneDto getAirplaneDto(ResultSet resultSet) throws SQLException {
        AirplaneDto airplaneDto = null;
        if (resultSet.getInt(AIRPLANE_ID_FIELD) != 0) {
            airplaneDto = new AirplaneDto(
                    resultSet.getInt(AIRPLANE_ID_FIELD),
                    resultSet.getString(NUMBER_FIELD),
                    new ModelQuery().getModelById(resultSet.getLong(MODEL_FIELD)),
                    resultSet.getDate(RELEASE_FIELD).toLocalDate());
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
