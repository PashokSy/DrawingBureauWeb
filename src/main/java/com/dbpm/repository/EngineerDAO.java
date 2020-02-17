package com.dbpm.repository;

import DBPM_classLibrary.Engineer;
import com.dbpm.DatabaseConfiguration;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class EngineerDAO implements AbstractDAO<Engineer> {
    DatabaseConfiguration dataBaseConfiguration = new DatabaseConfiguration();


    @Override
    public Engineer create(Engineer engineer) {
        try (Connection connection = dataBaseConfiguration.getDataSource().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into engineers(idCard, name, secondName) values (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setInt(1, engineer.getIdCard().getNumber());
            preparedStatement.setString(2, engineer.getName());
            preparedStatement.setString(3, engineer.getSecondName());

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            Long lastId = null;
            if (resultSet.next()) lastId = resultSet.getLong(1);

            return findById(lastId);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Engineer findById(Long id) {
        return null;
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
        return null;
    }
}
