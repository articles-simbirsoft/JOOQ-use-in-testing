package org.example.jooq.db;

import org.example.jooq.db.autocreated.tables.Airplane;
import org.example.jooq.db.autocreated.tables.Company;
import org.example.jooq.db.autocreated.tables.Model;
import org.example.jooq.dto.AirplaneDto;
import org.example.jooq.dto.CompanyDto;
import org.example.jooq.dto.ModelDto;
import org.example.jooq.utils.DatabaseConnector;
import org.jooq.DSLContext;

/**
 * Base class for actions in db tables.
 */
public abstract class DefaultQuery {
    protected DSLContext context = DatabaseConnector.getContext();

    public AirplaneDto getAirplaneDtoByRecord(org.jooq.Record record) {
        return new AirplaneDto(
                record.getValue(Airplane.AIRPLANE.ID),
                record.getValue(Airplane.AIRPLANE.NUMBER),
                new ModelQuery().getModelById(record.getValue(Airplane.AIRPLANE.MODEL)),
                record.getValue(Airplane.AIRPLANE.RELEASE)
        );
    }

    public ModelDto getModelDtoByRecord(org.jooq.Record record) {
        return new ModelDto(
                record.getValue(Model.MODEL.ID),
                record.getValue(Model.MODEL.NAME),
                new CompanyQuery().getCompanyById(record.getValue(Model.MODEL.COMPANY).intValue())
        );
    }

    public CompanyDto getCompanyDtoByRecord(org.jooq.Record record) {
        return new CompanyDto(
                record.getValue(Company.COMPANY.ID),
                record.getValue(Company.COMPANY.NAME)
        );
    }

}
