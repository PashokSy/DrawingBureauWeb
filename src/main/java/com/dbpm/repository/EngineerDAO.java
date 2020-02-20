package com.dbpm.repository;

import DBPM_classLibrary.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EngineerDAO implements AbstractDAO<Engineer> {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public EngineerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Engineer create(Engineer engineer) {
        try {
            Long lastInsert = jdbcTemplate.queryForObject("select id from engineers ORDER BY id DESC LIMIT 1", Long.class) + 1;

            jdbcTemplate.update(
                    "insert into engineers(id, id_card, name, second_name, department_name, room_num, project_name, rank_num) values (?,?,?,?,?,?,?,?)", ps -> {
                        ps.setLong(1, lastInsert);
                        ps.setInt(2, engineer.getIdCard().getNumber());
                        ps.setString(3, engineer.getName());
                        ps.setString(4, engineer.getSecondName());
                        ps.setString(5, engineer.getDepartment().getName());
                        ps.setLong(6, engineer.getRoom().getNumber());
                        ps.setString(7, engineer.getProject().getName());
                        ps.setLong(8, 3);
                    }
            );

            return findById(lastInsert);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Engineer findById(Long id) {
        try {
            Engineer engineer = new Engineer();
            jdbcTemplate.queryForObject(
                    "select * from engineers where engineerId = ?", new Object[]{id}, (rs, rn) -> {

                        engineer.setIdCard(new IdCard(rs.getInt("id_card")));
                        engineer.setName(rs.getString("name"));
                        engineer.setSecondName(rs.getString("second_name"));
                        Department department = new Department();
                        department.setName(rs.getString("department_name"));
                        engineer.setDepartment(department);
                        engineer.setRoom(new Room(rs.getInt("room_num")));
                        Project project = new Project();
                        project.setName(rs.getString("project_name"));
                        engineer.setProject(project);
                        engineer.setRoom(rs.getInt("room_num"));

                        return engineer;
                    }
            );
            return engineer;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Engineer update(Engineer engineer) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Engineer> getAll() {
        List<Engineer> engineers = new ArrayList<>();

        try {

            jdbcTemplate.query(
                    "select * from engineers", rs -> {
                        while (rs.next()) {

                            Engineer engineer = new Engineer();
                            engineer.setIdCard(new IdCard(rs.getInt("id_card")));
                            engineer.setName(rs.getString("name"));
                            engineer.setSecondName(rs.getString("second_name"));
                            Department department = new Department();
                            department.setName(rs.getString("department_name"));
                            engineer.setDepartment(department);
                            engineer.setRoom(new Room(rs.getInt("room_num")));
                            Project project = new Project();
                            project.setName(rs.getString("project_name"));
                            engineer.setProject(project);
                            engineer.setRoom(rs.getInt("room_num"));

                            engineers.add(engineer);

                        }
                        return engineers;
                    }
            );
            return engineers;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
