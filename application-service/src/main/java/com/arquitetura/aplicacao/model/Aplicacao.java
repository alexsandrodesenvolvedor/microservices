package com.arquitetura.aplicacao.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "APLICACAO")
public class Aplicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_APLICACAO")
    @SequenceGenerator(name = "SEQ_APLICACAO", sequenceName = "SEQ_APLICACAO", allocationSize = 1)
    private Long id;

    @EqualsAndHashCode.Include
    private String nome;

}
