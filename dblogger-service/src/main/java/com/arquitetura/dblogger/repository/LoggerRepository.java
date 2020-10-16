package com.arquitetura.dblogger.repository;

import com.arquitetura.dblogger.model.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoggerRepository extends JpaRepository<Logger, Long> {

    List<Logger> findAllByAndAplicacaoId(Long aplicaoId);

}
