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


@Controller
public class EngineerController {

    private EngineerService engineerService;

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
    public String add(@RequestParam String name, @RequestParam String secondName, Model model) {

        Engineer engineer = new Engineer();
        engineer.setName(name);
        engineer.setSecondName(secondName);
        engineerService.create(engineer);

        model.addAttribute("engineers", engineerService.getAll());

        return "engineerAdd";
    }
}
