package com.evan.demo.webflux.webfluxh2r2dbc.service;

import com.evan.demo.webflux.webfluxh2r2dbc.domain.StudentDO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * TODO:
 *
 * @author 我不是无赖
 * @date 2020/6/30
 */
public interface StudentService {
    Mono<StudentDO> save(StudentDO studentDO);

    Mono<StudentDO> update(StudentDO studentDO);

    Flux<StudentDO> findAll(StudentDO studentDO);

    Mono<StudentDO> findById(Long id);

    Mono<Boolean> deleteByName(String name);

    Mono<Void> deleteById(Long id);
}
