package com.dbpm;

import DBPM_classLibrary.Department;
import DBPM_classLibrary.Project;
import com.dbpm.domain.EngineerDB;
import com.dbpm.repository.EngineerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class MainController {
    @Autowired
    private EngineerRepo engineerRepo;

    @GetMapping
    public String greeting(Model model) {
    model.addAttribute("engineers", engineerRepo.findAll());
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name, @RequestParam String secondName, Model model){
        EngineerDB engineer = new EngineerDB(name, secondName,
                new Department(94,"Precisiaon mechanics"),
                new Project("Protazan",
                        LocalDate.of(2020,6,21), 7)
        );

        engineerRepo.save(engineer);

        model.addAttribute("engineers", engineerRepo.findAll());

        return "main";
    }
}
