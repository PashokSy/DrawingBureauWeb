package com.dbpm.controller;


import DBPM_classLibrary.Department;
import DBPM_classLibrary.Engineer;
import DBPM_classLibrary.Project;
import com.dbpm.repository.EngineerDAO;
import com.dbpm.service.EngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class MainController {

    private EngineerService engineerService;

    @Autowired
    public MainController(EngineerService engineerService) {
        this.engineerService = engineerService;
    }

    @GetMapping
    public String greeting(Model model) {

        model.addAttribute("engineers", engineerService.getAll());
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name, @RequestParam String secondName, Model model) {

        Engineer engineer = new Engineer();
        engineer.setName(name);
        engineer.setSecondName(secondName);
        engineerService.create(engineer);

        model.addAttribute("engineers", engineerService.getAll());

        return "main";
    }
}
