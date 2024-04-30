package com.example.foo;

import org.jooq.generated.tables.records.FooRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FooMapper {
    FooMapper MAPPER = Mappers.getMapper(FooMapper.class);

    @Mapping(target = "id", ignore = true)
    FooRecord toRecord(FooCreation fooCreation);

    @Mapping(source = ".", target = "foo")
    Foo toFoo(FooRecord fooRecord);
}
