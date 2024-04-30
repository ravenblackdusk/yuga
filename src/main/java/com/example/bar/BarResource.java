package com.example.bar;

import org.jooq.DSLContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.bar.BarMapper.MAPPER;
import static org.jooq.generated.tables.Bar.BAR;
import static org.jooq.generated.tables.Foo.FOO;
import static org.jooq.impl.DSL.noCondition;

@RequestMapping("/bar")
@RestController
class BarResource {
    private final DSLContext dslContext;

    BarResource(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @PostMapping
    void create(@RequestBody BarCreation barCreation) {
        dslContext.insertInto(BAR).set(MAPPER.toRecord(barCreation)).execute();
    }

    @GetMapping
    List<Bar> find(Long id, String name, Long fooId) {
        var condition = noCondition();
        if (id != null) {
            condition = condition.and(BAR.ID.eq(id));
        }
        if (name != null) {
            condition = condition.and(BAR.NAME.eq(name));
        }
        if (fooId != null) {
            condition = condition.and(BAR.FOO_ID.eq(fooId));
        }
        return dslContext.selectFrom(BAR.innerJoin(FOO).onKey()).where(condition).fetch(MAPPER::toBar);
    }

    @GetMapping("/{id}")
    Bar get(@PathVariable long id) {
        return dslContext.selectFrom(BAR.innerJoin(FOO).onKey()).where(BAR.ID.eq(id)).fetchOne(MAPPER::toBar);
    }

    @PutMapping("/{id}")
    void update(@PathVariable long id, @RequestBody BarCreation barCreation) {
        dslContext.update(BAR).set(MAPPER.toRecord(barCreation)).where(BAR.ID.eq(id)).execute();
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable long id) {
        dslContext.deleteFrom(BAR).where(BAR.ID.eq(id)).execute();
    }
}
