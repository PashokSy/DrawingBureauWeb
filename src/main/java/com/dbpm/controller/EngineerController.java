package com.dbpm.controller;


import DBPM_classLibrary.*;
import com.dbpm.repository.EngineerDAO;
import com.dbpm.service.EngineerService;
import com.dbpm.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
public class EngineerController {

    private EngineerService engineerService;
    private ProjectService projectService;

    @Autowired
    public EngineerController(EngineerService engineerService) {
        this.engineerService = engineerService;
    }

    @GetMapping("/engineers")
    public String engineers(Model model) {
        model.addAttribute("engineers", engineerService.getAll());
        return "engineers";
    }

    @GetMapping("/add")
    public String adding(Model model){

        return "engineerAdd";
    }

    @PostMapping("/add")
    public String add(@RequestParam int cardNum,
                      @RequestParam String name,
                      @RequestParam String secondName,
                      @RequestParam String departmentName,
                      @RequestParam int roomNum,
                      @RequestParam String projectName,
                      Model model) {

        Engineer engineer = new Engineer();
        engineer.setIdCard(new IdCard(cardNum));
        engineer.setName(name);
        engineer.setSecondName(secondName);
        engineer.setRoom(roomNum);
        Department department = new Department();
        department.setName(departmentName);
        engineer.setDepartment(department);
        Project project = new Project(projectName, LocalDate.now(), 7);
        engineer.setProject(project);

        projectService.create(project);
        engineerService.create(engineer);

        model.addAttribute("engineers", engineerService.getAll());
        return "engineers";
    }
}
