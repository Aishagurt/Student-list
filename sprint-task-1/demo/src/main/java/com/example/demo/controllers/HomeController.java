package com.example.demo.controllers;

import com.example.demo.db.DBManager;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;


@Controller

public class HomeController {
    ArrayList<Student> students = DBManager.getStudents();

    @GetMapping(value = "/")

    public String indexPage(Model model){
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping(value = "/addstud")

    public String AddStud(){
        return "addingstud";
    }

    @PostMapping(value = "/add-student")

    public String AddingStud(Student stud){

        for(Student s : students){
            if(stud.getName().equals(s.getName()) && stud.getSurname().equals(s.getSurname())){
                return "redirect:/";
            }
        }
        DBManager.addStudent(stud);
        return "redirect:/";
    }

}