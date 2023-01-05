package br.gov.sp.procon.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id @GeneratedValue
    @Getter @Setter private int id;
    @Getter @Setter @Column private String usuario;
    @Getter @Setter @Column private String senha;
    @Getter @Setter @Column private String nome;
    @Getter @Setter @Column private String sobreNome;
    @Getter @Setter @Column private String email;
}
