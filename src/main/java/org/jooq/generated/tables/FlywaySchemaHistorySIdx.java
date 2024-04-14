/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables;


import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableOptions;
import org.jooq.generated.Public;
import org.jooq.generated.tables.records.FlywaySchemaHistorySIdxRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FlywaySchemaHistorySIdx extends TableImpl<FlywaySchemaHistorySIdxRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.flyway_schema_history_s_idx</code>
     */
    public static final FlywaySchemaHistorySIdx FLYWAY_SCHEMA_HISTORY_S_IDX = new FlywaySchemaHistorySIdx();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FlywaySchemaHistorySIdxRecord> getRecordType() {
        return FlywaySchemaHistorySIdxRecord.class;
    }

    private FlywaySchemaHistorySIdx(Name alias, Table<FlywaySchemaHistorySIdxRecord> aliased) {
        this(alias, aliased, null);
    }

    private FlywaySchemaHistorySIdx(Name alias, Table<FlywaySchemaHistorySIdxRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.flyway_schema_history_s_idx</code> table
     * reference
     */
    public FlywaySchemaHistorySIdx(String alias) {
        this(DSL.name(alias), FLYWAY_SCHEMA_HISTORY_S_IDX);
    }

    /**
     * Create an aliased <code>public.flyway_schema_history_s_idx</code> table
     * reference
     */
    public FlywaySchemaHistorySIdx(Name alias) {
        this(alias, FLYWAY_SCHEMA_HISTORY_S_IDX);
    }

    /**
     * Create a <code>public.flyway_schema_history_s_idx</code> table reference
     */
    public FlywaySchemaHistorySIdx() {
        this(DSL.name("flyway_schema_history_s_idx"), null);
    }

    public <O extends Record> FlywaySchemaHistorySIdx(Table<O> child, ForeignKey<O, FlywaySchemaHistorySIdxRecord> key) {
        super(child, key, FLYWAY_SCHEMA_HISTORY_S_IDX);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public FlywaySchemaHistorySIdx as(String alias) {
        return new FlywaySchemaHistorySIdx(DSL.name(alias), this);
    }

    @Override
    public FlywaySchemaHistorySIdx as(Name alias) {
        return new FlywaySchemaHistorySIdx(alias, this);
    }

    @Override
    public FlywaySchemaHistorySIdx as(Table<?> alias) {
        return new FlywaySchemaHistorySIdx(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public FlywaySchemaHistorySIdx rename(String name) {
        return new FlywaySchemaHistorySIdx(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FlywaySchemaHistorySIdx rename(Name name) {
        return new FlywaySchemaHistorySIdx(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public FlywaySchemaHistorySIdx rename(Table<?> name) {
        return new FlywaySchemaHistorySIdx(name.getQualifiedName(), null);
    }
}
