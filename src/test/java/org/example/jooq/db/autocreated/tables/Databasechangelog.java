/*
 * This file is generated by jOOQ.
 */
package org.example.jooq.db.autocreated.tables;


import java.time.LocalDateTime;
import java.util.function.Function;

import org.example.jooq.db.autocreated.JooqDb;
import org.example.jooq.db.autocreated.tables.records.DatabasechangelogRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function14;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row14;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Databasechangelog extends TableImpl<DatabasechangelogRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>jooq_DB.DATABASECHANGELOG</code>
     */
    public static final Databasechangelog DATABASECHANGELOG = new Databasechangelog();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DatabasechangelogRecord> getRecordType() {
        return DatabasechangelogRecord.class;
    }

    /**
     * The column <code>jooq_DB.DATABASECHANGELOG.ID</code>.
     */
    public final TableField<DatabasechangelogRecord, String> ID = createField(DSL.name("ID"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>jooq_DB.DATABASECHANGELOG.AUTHOR</code>.
     */
    public final TableField<DatabasechangelogRecord, String> AUTHOR = createField(DSL.name("AUTHOR"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>jooq_DB.DATABASECHANGELOG.FILENAME</code>.
     */
    public final TableField<DatabasechangelogRecord, String> FILENAME = createField(DSL.name("FILENAME"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>jooq_DB.DATABASECHANGELOG.DATEEXECUTED</code>.
     */
    public final TableField<DatabasechangelogRecord, LocalDateTime> DATEEXECUTED = createField(DSL.name("DATEEXECUTED"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "");

    /**
     * The column <code>jooq_DB.DATABASECHANGELOG.ORDEREXECUTED</code>.
     */
    public final TableField<DatabasechangelogRecord, Integer> ORDEREXECUTED = createField(DSL.name("ORDEREXECUTED"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>jooq_DB.DATABASECHANGELOG.EXECTYPE</code>.
     */
    public final TableField<DatabasechangelogRecord, String> EXECTYPE = createField(DSL.name("EXECTYPE"), SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>jooq_DB.DATABASECHANGELOG.MD5SUM</code>.
     */
    public final TableField<DatabasechangelogRecord, String> MD5SUM = createField(DSL.name("MD5SUM"), SQLDataType.VARCHAR(35), this, "");

    /**
     * The column <code>jooq_DB.DATABASECHANGELOG.DESCRIPTION</code>.
     */
    public final TableField<DatabasechangelogRecord, String> DESCRIPTION = createField(DSL.name("DESCRIPTION"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>jooq_DB.DATABASECHANGELOG.COMMENTS</code>.
     */
    public final TableField<DatabasechangelogRecord, String> COMMENTS = createField(DSL.name("COMMENTS"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>jooq_DB.DATABASECHANGELOG.TAG</code>.
     */
    public final TableField<DatabasechangelogRecord, String> TAG = createField(DSL.name("TAG"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>jooq_DB.DATABASECHANGELOG.LIQUIBASE</code>.
     */
    public final TableField<DatabasechangelogRecord, String> LIQUIBASE = createField(DSL.name("LIQUIBASE"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>jooq_DB.DATABASECHANGELOG.CONTEXTS</code>.
     */
    public final TableField<DatabasechangelogRecord, String> CONTEXTS = createField(DSL.name("CONTEXTS"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>jooq_DB.DATABASECHANGELOG.LABELS</code>.
     */
    public final TableField<DatabasechangelogRecord, String> LABELS = createField(DSL.name("LABELS"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>jooq_DB.DATABASECHANGELOG.DEPLOYMENT_ID</code>.
     */
    public final TableField<DatabasechangelogRecord, String> DEPLOYMENT_ID = createField(DSL.name("DEPLOYMENT_ID"), SQLDataType.VARCHAR(10), this, "");

    private Databasechangelog(Name alias, Table<DatabasechangelogRecord> aliased) {
        this(alias, aliased, null);
    }

    private Databasechangelog(Name alias, Table<DatabasechangelogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>jooq_DB.DATABASECHANGELOG</code> table reference
     */
    public Databasechangelog(String alias) {
        this(DSL.name(alias), DATABASECHANGELOG);
    }

    /**
     * Create an aliased <code>jooq_DB.DATABASECHANGELOG</code> table reference
     */
    public Databasechangelog(Name alias) {
        this(alias, DATABASECHANGELOG);
    }

    /**
     * Create a <code>jooq_DB.DATABASECHANGELOG</code> table reference
     */
    public Databasechangelog() {
        this(DSL.name("DATABASECHANGELOG"), null);
    }

    public <O extends Record> Databasechangelog(Table<O> child, ForeignKey<O, DatabasechangelogRecord> key) {
        super(child, key, DATABASECHANGELOG);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqDb.JOOQ_DB;
    }

    @Override
    public Databasechangelog as(String alias) {
        return new Databasechangelog(DSL.name(alias), this);
    }

    @Override
    public Databasechangelog as(Name alias) {
        return new Databasechangelog(alias, this);
    }

    @Override
    public Databasechangelog as(Table<?> alias) {
        return new Databasechangelog(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Databasechangelog rename(String name) {
        return new Databasechangelog(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Databasechangelog rename(Name name) {
        return new Databasechangelog(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Databasechangelog rename(Table<?> name) {
        return new Databasechangelog(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row14 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row14<String, String, String, LocalDateTime, Integer, String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function14<? super String, ? super String, ? super String, ? super LocalDateTime, ? super Integer, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function14<? super String, ? super String, ? super String, ? super LocalDateTime, ? super Integer, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
