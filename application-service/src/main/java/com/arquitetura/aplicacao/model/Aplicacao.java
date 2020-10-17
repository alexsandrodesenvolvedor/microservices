package com.arquitetura.aplicacao.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TB_APLICACAO", indexes = {@Index(name = "IDX_NOME",  columnList="NOME", unique = true)})
public class Aplicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_APLICACAO")
    @SequenceGenerator(name = "SEQ_APLICACAO", sequenceName = "SEQ_APLICACAO", allocationSize = 1)
    private Long id;

    @EqualsAndHashCode.Include
    @Column(name = "NOME", length = 25, nullable = false)
    private String nome;

}
