package br.gov.sp.procon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Getter @Setter private int id;
    @Getter @Setter private String usuario;
    @Getter @Setter private String senha;
    @Getter @Setter private String nome;
    @Getter @Setter private String sobreNome;
    @Getter @Setter private String email;
}
