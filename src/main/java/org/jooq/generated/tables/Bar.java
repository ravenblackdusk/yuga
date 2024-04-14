/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables;


import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.generated.Keys;
import org.jooq.generated.Public;
import org.jooq.generated.tables.records.BarRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Bar extends TableImpl<BarRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.bar</code>
     */
    public static final Bar BAR = new Bar();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BarRecord> getRecordType() {
        return BarRecord.class;
    }

    /**
     * @deprecated Unknown data type. If this is a qualified, user-defined type,
     * it may have been excluded from code generation. If this is a built-in
     * type, you can define an explicit {@link org.jooq.Binding} to specify how
     * this type should be handled. Deprecation can be turned off using
     * {@literal <deprecationOnUnknownTypes/>} in your code generator
     * configuration.
     */
    @Deprecated
    public final TableField<BarRecord, Object> ID = createField(DSL.name("id"), SQLDataType.OTHER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.bar.name</code>.
     */
    public final TableField<BarRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(2147483647).nullable(false), this, "");

    /**
     * @deprecated Unknown data type. If this is a qualified, user-defined type,
     * it may have been excluded from code generation. If this is a built-in
     * type, you can define an explicit {@link org.jooq.Binding} to specify how
     * this type should be handled. Deprecation can be turned off using
     * {@literal <deprecationOnUnknownTypes/>} in your code generator
     * configuration.
     */
    @Deprecated
    public final TableField<BarRecord, Object> FOO_ID = createField(DSL.name("foo_id"), SQLDataType.OTHER.nullable(false), this, "");

    private Bar(Name alias, Table<BarRecord> aliased) {
        this(alias, aliased, null);
    }

    private Bar(Name alias, Table<BarRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.bar</code> table reference
     */
    public Bar(String alias) {
        this(DSL.name(alias), BAR);
    }

    /**
     * Create an aliased <code>public.bar</code> table reference
     */
    public Bar(Name alias) {
        this(alias, BAR);
    }

    /**
     * Create a <code>public.bar</code> table reference
     */
    public Bar() {
        this(DSL.name("bar"), null);
    }

    public <O extends Record> Bar(Table<O> child, ForeignKey<O, BarRecord> key) {
        super(child, key, BAR);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    /**
     * @deprecated Unknown data type. If this is a qualified, user-defined type,
     * it may have been excluded from code generation. If this is a built-in
     * type, you can define an explicit {@link org.jooq.Binding} to specify how
     * this type should be handled. Deprecation can be turned off using
     * {@literal <deprecationOnUnknownTypes/>} in your code generator
     * configuration.
     */
    @Deprecated
    @Override
    public Identity<BarRecord, Object> getIdentity() {
        return (Identity<BarRecord, Object>) super.getIdentity();
    }

    @Override
    public UniqueKey<BarRecord> getPrimaryKey() {
        return Keys.PK_BAR;
    }

    @Override
    public Bar as(String alias) {
        return new Bar(DSL.name(alias), this);
    }

    @Override
    public Bar as(Name alias) {
        return new Bar(alias, this);
    }

    @Override
    public Bar as(Table<?> alias) {
        return new Bar(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Bar rename(String name) {
        return new Bar(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Bar rename(Name name) {
        return new Bar(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Bar rename(Table<?> name) {
        return new Bar(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Object, String, Object> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super Object, ? super String, ? super Object, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Object, ? super String, ? super Object, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}