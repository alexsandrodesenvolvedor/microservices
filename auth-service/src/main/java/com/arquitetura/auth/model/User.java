package com.arquitetura.auth.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = -9020973236707102285L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER")
    @SequenceGenerator(name = "SEclQ_USER", sequenceName = "SEQ_USER", allocationSize = 1)
    private Long id;

    @Column(name = "username", length = 30, nullable = false)
    private String userName;

    @Column(name = "password", length = 100 ,nullable = false)
    private String password;

    @Column(name = "accountNonExpired")
    private Boolean accountNonExpired;

    @Column(name = "accountNonLocked")
    private Boolean accountNonLocked;

    @Column(name = "credentialsNonExpired")
    private Boolean credentialsNonExpired;

    @Column(name = "enabled")
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_permission", joinColumns = {@JoinColumn(name = "id_users")}, inverseJoinColumns = {@JoinColumn(name = "id_permissions")})
    private List<Permission> permissions;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.permissions;
    }

    public List<String> getRoles() {
        List<String> roles = new ArrayList<>();
        this.permissions.stream()
                .forEach(p -> {
                    roles.add(p.getDescription());
                });
        return roles;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

}






