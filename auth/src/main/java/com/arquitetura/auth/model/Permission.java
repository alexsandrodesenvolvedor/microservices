package com.arquitetura.auth.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@Table(name = "permission")
public class Permission implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = -4460602054299804896L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERMISSION")
	@SequenceGenerator(name = "SEQ_PERMISSION", sequenceName = "SEQ_PERMISSION", allocationSize = 1)
	private Long id;

	@Column(name = "description", nullable = false)
	private String description;

	@Override
	public String getAuthority() {
		return this.description;
	}

}
