package com.arquitetura.dblogger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@JsonPropertyOrder({"uri","id"})
@Data
@Entity
@Table(name = "LOGGER")
public class Logger implements Serializable {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOGGER")
    @SequenceGenerator(name = "SEQ_LOGGER", sequenceName = "SEQ_LOGGER", allocationSize = 1)
    private Long id;

    @JsonProperty("uri")
    private String uri;

    private String requisicao;
    private String resposta;
    private Long aplicacaoId;

    @Transient
    private Aplicacao aplicacao;

}

