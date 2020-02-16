package com.dbpm.repository;

import com.dbpm.domain.EngineerDB;
import org.springframework.data.repository.CrudRepository;

public interface EngineerRepo extends CrudRepository<EngineerDB, Long> {

}
