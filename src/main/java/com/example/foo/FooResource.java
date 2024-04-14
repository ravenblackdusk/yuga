package com.example.foo;

import org.jooq.DSLContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.foo.FooMapper.MAPPER;
import static org.jooq.generated.tables.Foo.FOO;

@RequestMapping("/foo")
@RestController
class FooResource {
    private final DSLContext dslContext;

    FooResource(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @PostMapping
    void create(@RequestBody FooCreation fooCreation) {
        dslContext.insertInto(FOO).set(MAPPER.toRecord(fooCreation)).execute();
    }

    @GetMapping
    List<Foo> getAll() {
        return dslContext.selectFrom(FOO).fetch().map(MAPPER::toFoo);
    }
}
