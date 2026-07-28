package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    private final List<Student> students = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student) {
        student.setId((long) (students.size() + 1));
        students.add(student);
        return "redirect:/";
    }
}