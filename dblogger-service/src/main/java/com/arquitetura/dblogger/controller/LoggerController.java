package com.arquitetura.dblogger.controller;

import com.arquitetura.dblogger.model.Aplicacao;
import com.arquitetura.dblogger.model.Logger;
import com.arquitetura.dblogger.repository.LoggerRepository;
import com.arquitetura.dblogger.service.AplicacaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/logger")
public class LoggerController {

    private final LoggerRepository loggerRepository;
    private final AplicacaoService aplicacaoService;

    @GetMapping("/{aplicacaoId}")
    public Iterable<Logger> findByAplicationId(@PathVariable Long aplicacaoId) {
        List<Logger> loggers = loggerRepository.findAllByAndAplicacaoId(aplicacaoId);
        Aplicacao aplicacao = aplicacaoService.findByAplicacaoId(aplicacaoId);
        loggers.forEach(logger -> logger.setAplicacao(aplicacao));
        return loggers;
    }

}
