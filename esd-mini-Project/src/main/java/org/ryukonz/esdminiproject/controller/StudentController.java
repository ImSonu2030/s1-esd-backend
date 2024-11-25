package org.ryukonz.esdminiproject.controller;

import jakarta.validation.Valid;
import org.ryukonz.esdminiproject.dto.StudentReqDto;
import org.ryukonz.esdminiproject.model.Students;
import org.ryukonz.esdminiproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<Students> registerStudent(@RequestBody @Valid StudentReqDto studentRequestDTO) {
        Students student = studentService.saveStudent(studentRequestDTO);
        return ResponseEntity.ok(student);
    }
}
