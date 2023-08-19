package com.average.school.grade.controller;


import com.average.school.grade.model.Student;
import com.average.school.grade.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        studentRepository.save(student);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        List<Student> list = studentRepository.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> findById(@PathVariable Integer id) {
        Optional<Student> student;
        try {
            student = studentRepository.findById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }catch (NoSuchElementException nsee) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Student>> deleteById (@PathVariable Integer id) {
        try {
            studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NoSuchElementException nsee) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent (@PathVariable Integer id, @RequestBody Student newStudent) {
       return studentRepository.findById(id)
               .map(student -> {
                   student.setNome(newStudent.getNome());
                   student.setNota(newStudent.getNota());
                   Student studentUpdated = studentRepository.save(student);
                   return ResponseEntity.ok().body(studentUpdated);
               }).orElse(ResponseEntity.notFound().build());
    }


}
