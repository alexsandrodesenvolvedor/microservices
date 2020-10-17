package com.arquitetura.aplicacao.controller;

import com.arquitetura.aplicacao.model.Aplicacao;
import com.arquitetura.aplicacao.repository.AplicacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/application")
@AllArgsConstructor
@RestController
public class AplicacaoController {

    private AplicacaoRepository aplicacaoRepository;

    @GetMapping(value = "/{aplicacaoId}")
    public Aplicacao findById(@PathVariable("aplicacaoId") Long aplicacaoId) {
        return aplicacaoRepository.findById(aplicacaoId).get();
    }

}
