package com.arquitetura.dblogger.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Aplicacao implements Serializable {

    private Long id;
    private String nome;

}
