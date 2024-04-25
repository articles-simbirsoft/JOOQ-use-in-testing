package org.example.jooq.db;

import org.example.jooq.dto.ModelDto;
import org.example.jooq.db.autocreated.tables.Model;

/**
 * Class for actions in model db table.
 */
public class ModelQuery extends DefaultQuery {

    public ModelDto getModelById(Long id) {
        return context.select()
                .from(Model.MODEL)
                .where(Model.MODEL.ID.eq(id.intValue()))
                .fetch()
                .map(this::getModelDtoByRecord)
                .get(0);
    }

}
