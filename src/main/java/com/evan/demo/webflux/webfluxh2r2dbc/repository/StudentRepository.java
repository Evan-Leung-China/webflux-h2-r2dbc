package com.evan.demo.webflux.webfluxh2r2dbc.repository;

import com.evan.demo.webflux.webfluxh2r2dbc.domain.StudentDO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

/**
 * TODO:
 *
 * @author 我不是无赖
 * @date 2020/6/30
 */
public interface StudentRepository extends ReactiveCrudRepository<StudentDO, Long> {

    Mono<Boolean> deleteByName(String name);
}
