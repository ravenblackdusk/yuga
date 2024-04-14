/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated;


import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.generated.tables.Bar;
import org.jooq.generated.tables.Foo;
import org.jooq.generated.tables.records.BarRecord;
import org.jooq.generated.tables.records.FooRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<BarRecord> BAR_PKEY = Internal.createUniqueKey(Bar.BAR, DSL.name("bar_pkey"), new TableField[] { Bar.BAR.ID }, true);
    public static final UniqueKey<FooRecord> FOO_PKEY = Internal.createUniqueKey(Foo.FOO, DSL.name("foo_pkey"), new TableField[] { Foo.FOO.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<BarRecord, FooRecord> BAR__BAR_FOO_ID_FK = Internal.createForeignKey(Bar.BAR, DSL.name("bar_foo_id_fk"), new TableField[] { Bar.BAR.FOO_ID }, Keys.FOO_PKEY, new TableField[] { Foo.FOO.ID }, true);
}
