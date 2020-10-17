package com.arquitetura.auth.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "permission")
public class Permission implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = -4460602054299804896L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERMISSION")
	@SequenceGenerator(name = "SEQ_PERMISSION", sequenceName = "SEQ_PERMISSION", allocationSize = 1)
	private Long id;

	@Column(name = "description", length = 20, nullable = false, unique = true)
	private String description;

	@Override
	public String getAuthority() {
		return this.description;
	}

}
