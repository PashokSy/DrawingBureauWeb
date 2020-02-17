package com.dbpm.service;

import DBPM_classLibrary.Engineer;
import com.dbpm.repository.EngineerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EngineerService {
    private final EngineerDAO engineerDAO;

    @Autowired
    public EngineerService(EngineerDAO engineerDAO) {
        this.engineerDAO = engineerDAO;
    }

    public Engineer create(Engineer engineer){
        return engineerDAO.create(engineer);
    }
}
