package com.evan.demo.webflux.webfluxh2r2dbc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

/**
 * TODO:
 *
 * @author 我不是无赖
 * @date 2020/6/30
 */
@Setter
@Getter
@ToString
@Table("demo_student")
public class StudentDO {
    public StudentDO() {
    }

    @PersistenceConstructor
    public StudentDO(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Id
    private Long id;

    private String name;

    private Integer age;


}
