package com.example.bar;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.bar.BarMapper.MAPPER;
import static org.jooq.generated.tables.Bar.BAR;

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
        var condition = DSL.noCondition();
        if (id != null) {
            condition = condition.and(BAR.ID.eq(id));
        }
        if (name != null) {
            condition = condition.and(BAR.NAME.eq(name));
        }
        if (fooId != null) {
            condition = condition.and(BAR.FOO_ID.eq(fooId));
        }
        return dslContext.selectFrom(BAR).where(condition).fetch().map(MAPPER::toBar);
    }

    @GetMapping("/{id}")
    Bar get(@PathVariable long id) {
        return MAPPER.toBar(dslContext.selectFrom(BAR).where(BAR.ID.eq(id)).fetchOne());
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
