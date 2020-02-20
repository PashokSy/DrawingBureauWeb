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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public String engineers(Model model) {
        model.addAttribute("projects", projectService.getAll());
        return "projects";
    }

    @GetMapping("project/add")
    public String adding(Model model){

        return "projectAdd";
    }

    @PostMapping("project/add")
    public String add(@RequestParam String projectName,
                      @RequestParam SimpleDateFormat releaseDate,
                      @RequestParam Double materialsCost,
                      Model model) {


        Project project = new Project();
        project.setName(projectName);
        project.setReleaseDate(LocalDate.now());

        projectService.create(project);

        model.addAttribute("projects", projectService.getAll());
        return "projects";
    }
}
