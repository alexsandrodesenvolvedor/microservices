package com.arquitetura.dblogger.service;

import com.arquitetura.dblogger.model.Aplicacao;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class AplicacaoServiceImpl implements AplicacaoService{

    private final RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "defaultAplicacao")
    public Aplicacao findByAplicacaoId(Long aplicacaoId) {
        return restTemplate.getForObject("http://application-service/api/application/{aplicacaoId}", Aplicacao.class, aplicacaoId);
    }

    private Aplicacao defaultAplicacao(Long aplicacaoId) {
        return new Aplicacao();
    }

}
