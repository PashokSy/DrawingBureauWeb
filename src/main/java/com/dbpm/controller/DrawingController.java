package com.dbpm.controller;


import DBPM_classLibrary.*;
import com.dbpm.repository.EngineerDAO;
import com.dbpm.service.DrawingService;
import com.dbpm.service.EngineerService;
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
public class DrawingController {

    private DrawingService drawingService;

    @Autowired
    public DrawingController(DrawingService drawingService) {
        this.drawingService = drawingService;
    }

    @GetMapping("/drawings")
    public String engineers(Model model) {

        return "index";
    }
}