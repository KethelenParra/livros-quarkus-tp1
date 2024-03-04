package br.unitins.topicos1.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity 
public class Login extends PanacheEntity{
  
    public String usuario;
    public String senha;

}
