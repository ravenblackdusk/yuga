package com.example.bar;

import org.jooq.generated.tables.records.BarRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
interface BarMapper {
    BarMapper MAPPER = Mappers.getMapper(BarMapper.class);

    BarRecord toRecord(BarCreation barCreation);

    @Mapping(source = ".", target = "bar")
    Bar toBar(BarRecord barRecord);
}
