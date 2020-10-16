package com.arquitetura.dblogger.service;

import com.arquitetura.dblogger.model.Aplicacao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface AplicacaoService {

    @GetMapping(value = "/dblogger/aplicao/{aplicacaoId}")
    Aplicacao findByAplicacaoId(@PathVariable("aplicacaoId") Long aplicacaoId);

}
