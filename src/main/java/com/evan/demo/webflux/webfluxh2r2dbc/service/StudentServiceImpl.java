package com.evan.demo.webflux.webfluxh2r2dbc.service;

import com.evan.demo.webflux.webfluxh2r2dbc.domain.StudentDO;
import com.evan.demo.webflux.webfluxh2r2dbc.repository.StudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * TODO:
 *
 * @author 我不是无赖
 * @date 2020/6/30
 */
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public Mono<StudentDO> save(StudentDO studentDO) {

        return studentRepository.save(studentDO)
                .map(it -> {
                    if (it.getName().contains("大大")) {
                        throw new IllegalArgumentException("不允许出现<大大>");
                    } else {
                        return it;
                    }
                });
    }

    @Override
    @Transactional
    public Mono<StudentDO> update(StudentDO studentDO) {
        return studentRepository.save(studentDO)
                .map(it -> {
                    if (it.getName().contains("大大")) {
                        throw new IllegalArgumentException();
                    } else {
                        return it;
                    }
                });
    }

    @Override
    public Flux<StudentDO> findAll(StudentDO studentDO) {
//        Sort.TypedSort<StudentDO> student = Sort.sort(StudentDO.class);
        // 直接实现ReactiveSortingRepository的findAll(Sort)方法，会存在异常。它会根据方法名找映射，这货直接找了StudentDO::findAll属性
        return studentRepository.findAll();
    }

    @Override
    public Mono<StudentDO> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Mono<Boolean> deleteByName(String name) {
        return studentRepository.deleteByName(name);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return studentRepository.deleteById(id);
    }
}
