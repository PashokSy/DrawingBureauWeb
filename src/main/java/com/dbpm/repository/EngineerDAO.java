package com.dbpm.repository;

import DBPM_classLibrary.Engineer;
import DBPM_classLibrary.IdCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
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

            Long lastInsert = jdbcTemplate.queryForObject("select engineerId from engineers ORDER BY engineerId DESC LIMIT 1" , Long.class) + 1;


            jdbcTemplate.update(
                    "insert into engineers(engineerId, idCard, name, secondName) values (?,?,?,?)", ps -> {
                        ps.setLong(1, lastInsert);
                        ps.setInt(2, 1234);
                        ps.setString(3, engineer.getName());
                        ps.setString(4, engineer.getSecondName());
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


                        engineer.setIdCard(new IdCard(rs.getInt("idCard")));
                        engineer.setName(rs.getString("name"));
                        engineer.setSecondName(rs.getString("secondName"));

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
                        while (rs.next()){
                            Engineer engineer = new Engineer();
                            engineer.setIdCard(new IdCard(rs.getInt("idCard")));
                            engineer.setName(rs.getString("name"));
                            engineer.setSecondName(rs.getString("secondName"));

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
