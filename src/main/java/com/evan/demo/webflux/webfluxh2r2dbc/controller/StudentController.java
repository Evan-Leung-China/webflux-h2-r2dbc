package com.evan.demo.webflux.webfluxh2r2dbc.controller;

import com.evan.demo.webflux.webfluxh2r2dbc.domain.StudentDO;
import com.evan.demo.webflux.webfluxh2r2dbc.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * TODO:
 *
 * @author 我不是无赖
 * @date 2020/6/30
 */
@RestController
@RequestMapping("/student")
@Api(tags = "StudentController")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiOperation(value = "hello")
    @GetMapping("/hello")
    Mono<String> hello(@RequestParam String name) {
        // 验证base-path配置不是全局性的
        return Mono.just("你好，" + name);
    }

    @ApiOperation(value = "保存Student")
    @PutMapping("/save")
    Mono<StudentDO> save(@RequestBody StudentDO studentDO) {
        return studentService.save(studentDO);
    }

    @PutMapping("/update")
    Mono<StudentDO> update(@RequestBody StudentDO studentDO) {
        return studentService.save(studentDO);
    }

    @PostMapping("/findAll")
    Flux<StudentDO> findAll(@RequestBody StudentDO studentDO) {
        return studentService.findAll(studentDO);
    }

    @GetMapping("/find/{id}")
    Mono<StudentDO> findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

//    @DeleteMapping("/delete")
//    Mono<Boolean> deleteByName(@RequestParam String name){
//        return studentService.deleteByName(name);
//    }

    @DeleteMapping("/delete/{id}")
    Mono<Void> deleteById(@PathVariable Long id) {
        return studentService.deleteById(id);
    }
}
