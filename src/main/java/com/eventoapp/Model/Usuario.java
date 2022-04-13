package com.eventoapp.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@Entity
public class Usuario implements UserDetails {
    private static long serialVersionUID = 1L;

    public Usuario() {

    }

    public Usuario(String nome, String ultimoNome, String email, String senha, String confirmSenha) {
        this.nome = nome;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.senha = senha;
        this.ConfirmSenha = confirmSenha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    private String ultimoNome;

    private String email;

    private String senha;

    private String ConfirmSenha;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
