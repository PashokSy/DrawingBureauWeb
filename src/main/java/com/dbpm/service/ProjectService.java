package com.dbpm.service;

import DBPM_classLibrary.Project;
import com.dbpm.repository.ProjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectDAO projectDAO;

    @Autowired
    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public Project create(Project project){
        return projectDAO.create(project);
    }
    public List<Project> getAll(){
        return projectDAO.getAll();
    }
}
