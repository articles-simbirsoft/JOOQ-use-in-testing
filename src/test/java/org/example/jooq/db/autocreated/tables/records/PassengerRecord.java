/*
 * This file is generated by jOOQ.
 */
package org.example.jooq.db.autocreated.tables.records;


import java.time.LocalDate;

import org.example.jooq.db.autocreated.tables.Passenger;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PassengerRecord extends UpdatableRecordImpl<PassengerRecord> implements Record4<Long, String, String, LocalDate> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>jooq_DB.passenger.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>jooq_DB.passenger.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>jooq_DB.passenger.fullname</code>.
     */
    public void setFullname(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>jooq_DB.passenger.fullname</code>.
     */
    public String getFullname() {
        return (String) get(1);
    }

    /**
     * Setter for <code>jooq_DB.passenger.passport_details</code>.
     */
    public void setPassportDetails(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>jooq_DB.passenger.passport_details</code>.
     */
    public String getPassportDetails() {
        return (String) get(2);
    }

    /**
     * Setter for <code>jooq_DB.passenger.birthdate</code>.
     */
    public void setBirthdate(LocalDate value) {
        set(3, value);
    }

    /**
     * Getter for <code>jooq_DB.passenger.birthdate</code>.
     */
    public LocalDate getBirthdate() {
        return (LocalDate) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, String, String, LocalDate> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, String, String, LocalDate> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Passenger.PASSENGER.ID;
    }

    @Override
    public Field<String> field2() {
        return Passenger.PASSENGER.FULLNAME;
    }

    @Override
    public Field<String> field3() {
        return Passenger.PASSENGER.PASSPORT_DETAILS;
    }

    @Override
    public Field<LocalDate> field4() {
        return Passenger.PASSENGER.BIRTHDATE;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getFullname();
    }

    @Override
    public String component3() {
        return getPassportDetails();
    }

    @Override
    public LocalDate component4() {
        return getBirthdate();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getFullname();
    }

    @Override
    public String value3() {
        return getPassportDetails();
    }

    @Override
    public LocalDate value4() {
        return getBirthdate();
    }

    @Override
    public PassengerRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public PassengerRecord value2(String value) {
        setFullname(value);
        return this;
    }

    @Override
    public PassengerRecord value3(String value) {
        setPassportDetails(value);
        return this;
    }

    @Override
    public PassengerRecord value4(LocalDate value) {
        setBirthdate(value);
        return this;
    }

    @Override
    public PassengerRecord values(Long value1, String value2, String value3, LocalDate value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PassengerRecord
     */
    public PassengerRecord() {
        super(Passenger.PASSENGER);
    }

    /**
     * Create a detached, initialised PassengerRecord
     */
    public PassengerRecord(Long id, String fullname, String passportDetails, LocalDate birthdate) {
        super(Passenger.PASSENGER);

        setId(id);
        setFullname(fullname);
        setPassportDetails(passportDetails);
        setBirthdate(birthdate);
        resetChangedOnNotNull();
    }
}
