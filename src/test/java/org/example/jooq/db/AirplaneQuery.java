package org.example.jooq.db;

import org.example.jooq.dto.AirplaneDto;
import org.example.jooq.db.autocreated.tables.Airplane;

/**
 * Class for actions in airplane db table.
 */
public class AirplaneQuery extends DefaultQuery {

    public AirplaneDto getAirplaneById(Integer id) {
        return context.select()
                .from(Airplane.AIRPLANE)
                .where(Airplane.AIRPLANE.ID.eq(id))
                .fetch()
                .map(this::getAirplaneDtoByRecord)
                .get(0);
    }

}
