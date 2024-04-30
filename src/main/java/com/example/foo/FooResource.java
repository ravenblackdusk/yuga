package com.example.foo;

import org.jooq.DSLContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.foo.FooMapper.MAPPER;
import static org.jooq.generated.tables.Foo.FOO;
import static org.jooq.impl.DSL.noCondition;

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
    List<Foo> find(Long id, String name) {
        var condition = noCondition();
        if (id != null) {
            condition = condition.and(FOO.ID.eq(id));
        }
        if (name != null) {
            condition = condition.and(FOO.NAME.eq(name));
        }
        return dslContext.selectFrom(FOO).where(condition).fetch(MAPPER::toFoo);
    }

    @GetMapping("/{id}")
    Foo get(@PathVariable long id) {
        return dslContext.selectFrom(FOO).where(FOO.ID.eq(id)).fetchOne(MAPPER::toFoo);
    }

    @PutMapping("/{id}")
    void update(@PathVariable long id, @RequestBody FooCreation fooCreation) {
        dslContext.update(FOO).set(MAPPER.toRecord(fooCreation)).where(FOO.ID.eq(id)).execute();
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable long id) {
        dslContext.deleteFrom(FOO).where(FOO.ID.eq(id)).execute();
    }
}
