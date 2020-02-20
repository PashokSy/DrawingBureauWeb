package com.dbpm.repository;

import DBPM_classLibrary.Engineer;
import DBPM_classLibrary.IdCard;
import DBPM_classLibrary.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ProjectDAO implements AbstractDAO<Project> {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public ProjectDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Project create(Project project) {
        try {

            Long lastInsert = jdbcTemplate.queryForObject("select id from pojects ORDER BY id DESC LIMIT 1" , Long.class) + 1;


            jdbcTemplate.update(
                    "insert into pojects(id, name, release_date, materials_cost, is_archived) values (?,?,?,?,?)", ps -> {
                        ps.setLong(1, lastInsert);
                        ps.setString(2, project.getName());
                        ps.setString(3, project.getReleaseDate().toString());
                        ps.setInt(4, (int)project.getMaterialsCost());
                        ps.setBoolean(5, false);
                    }
            );

            return findById(lastInsert);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Project findById(Long id) {
        try {
            Project project = new Project();
            jdbcTemplate.queryForObject(
                    "select * from pojects where id = ?", new Object[]{id}, (rs, rn) -> {


                        project.setName(rs.getString("name"));
                        project.setReleaseDate(LocalDate.parse(rs.getString("release_date")));
                        project.setMaterialsCost(rs.getInt("materials_cost"));
                        if(rs.getBoolean("is_archived"))
                            project.isDone();

                        return project;
                    }
            );
        return project;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Project update(Project project) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Project> getAll() {
        List<Project> projects = new ArrayList<>();
        try {
            jdbcTemplate.query(
                    "select * from pojects", rs -> {
                        while (rs.next()){
                            Project project = new Project();
                            project.setName(rs.getString("name"));
                            project.setReleaseDate(LocalDate.parse(rs.getString("release_date")));
                            project.setMaterialsCost(rs.getInt("materials_cost"));
                            if(rs.getBoolean("is_archived"))
                                project.isDone();

                            projects.add(project);

                        }
                        return projects;
                    }
            );
            return projects;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
