package com.arquitetura.auth.endpoint.dto;

import java.io.Serializable;

import lombok.*;

/**
 * @author alexsandro
 *
 * Classe de transferencia de dados
 */
@Data
public class UserDTO implements Serializable {

	private static final long serialVersionUID = -8387927312441830960L;

	private String userName;
	private String password;

}
