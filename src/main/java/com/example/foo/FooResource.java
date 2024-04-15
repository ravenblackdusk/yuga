package com.example.foo;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
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
    List<Foo> find(Long id, String name) {
        var condition = DSL.noCondition();
        if (id != null) {
            condition = condition.and(FOO.ID.eq(id));
        }
        if (name != null) {
            condition = condition.and(FOO.NAME.eq(name));
        }
        return dslContext.selectFrom(FOO).where(condition).fetch().map(MAPPER::toFoo);
    }

    @GetMapping("/{id}")
    Foo get(@PathVariable long id) {
        return MAPPER.toFoo(dslContext.selectFrom(FOO).where(FOO.ID.eq(id)).fetchOne());
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
