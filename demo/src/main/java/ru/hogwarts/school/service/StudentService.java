package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {

    private final static Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        logger.debug("Method addStudent is called with student = {}", student);
        return studentRepository.save(student);
    }

    public Student getStudent(long id) {
        logger.debug("Method getStudent is called with id = {}", id);
        return studentRepository.findById(id).orElse(null);
    }

    public Student editStudent(Student student) {
        logger.debug("Method editStudent is called with student = {}", student);
        return studentRepository.save(student);
    }

    public void removeStudent(long id) {
        logger.debug("Method removeStudent is called with id = {}", id);
        studentRepository.deleteById(id);
    }

    public Collection<Student> getStudentsByAge(int age) {
        logger.debug("Method getStudentByAge is called with age = {}", age);
        return studentRepository.findByAgeLessThan(age);
    }

    public Collection<Student> getAll() {
        logger.debug("Method getAll is called");
        return studentRepository.findAll();
    }

    public Collection<Student> getStudentsByAgeBetween(int minAge, int maxAge) {
        logger.debug("Method getStudentsByAgeBetween is called with minAge = {} and maxAge = {}", minAge, maxAge);
        return studentRepository.findStudentsByAgeBetween(minAge, maxAge);
    }

    public Faculty getFaculty(long id) {
        logger.debug("Method getFaculty is called with id = {}", id);
        Student s =  studentRepository.findById(id).orElse(null);
        if (s == null) {
            return null;
        }
        return s.getFaculty();
    }

    // Возможность получить количество всех студентов в школе.
    public Integer getTotalNumber() {
        logger.debug("Method getTotalNumber is called");
        return studentRepository.getTotalNumber();
    }

    public Double getAverageAge() {
        logger.debug("Method getAverageAge is called");
        return studentRepository.getAverageAge();
    }

    public Collection<Student> getLastFive() {
        logger.debug("Method getLastFive is called");
        return studentRepository.getLastFive();
    }
}
