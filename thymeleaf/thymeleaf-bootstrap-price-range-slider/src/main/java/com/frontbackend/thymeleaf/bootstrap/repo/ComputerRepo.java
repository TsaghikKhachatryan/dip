package com.frontbackend.thymeleaf.bootstrap.repo;

import com.frontbackend.thymeleaf.bootstrap.model.Computer;
import org.springframework.data.repository.CrudRepository;

public interface ComputerRepo extends CrudRepository<Computer,Long> {
}
