package com.example.bar;

import com.example.foo.FooMapper;
import org.jooq.Record;
import org.jooq.generated.tables.records.BarRecord;
import org.jooq.generated.tables.records.FooRecord;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import static org.jooq.generated.Tables.FOO;
import static org.jooq.generated.tables.Bar.BAR;

@Mapper(uses = FooMapper.class)
interface BarMapper {
    BarMapper MAPPER = Mappers.getMapper(BarMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "foo.id", target = "fooId")
    BarRecord toRecord(BarCreation barCreation);

    @InheritInverseConfiguration
    BarCreation toBarCreation(BarRecord barRecord);

    default Bar toBar(BarRecord barRecord) {
        return new Bar(barRecord.getId(), toBarCreation(barRecord));
    }

    @Mapping(source = "barRecord.name", target = "name")
    @Mapping(source = "fooRecord", target = "foo")
    BarCreation toBarCreation(BarRecord barRecord, FooRecord fooRecord);

    default Bar toBar(Record record) {
        var barRecord = record.into(BAR);
        return new Bar(barRecord.getId(), toBarCreation(barRecord, record.into(FOO)));
    }
}
