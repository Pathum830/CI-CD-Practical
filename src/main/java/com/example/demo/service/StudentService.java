
package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student(1L, "Pathum", "pathum@gmail.com", 25));
        students.add(new Student(2L, "Kamal", "kamal@gmail.com", 24));
        students.add(new Student(3L, "Nimal", "nimal@gmail.com", 23));
    }

    // Get all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Add student
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    // Update student
    public Student updateStudent(Long id, Student updatedStudent) {

        for (Student student : students) {
            if (student.getId().equals(id)) {

                student.setName(updatedStudent.getName());
                student.setEmail(updatedStudent.getEmail());
                student.setAge(updatedStudent.getAge());

                return student;
            }
        }

        return null;
    }

    // Delete student
    public boolean deleteStudent(Long id) {
        return students.removeIf(
            student -> student.getId().equals(id)
        );
    }
}
