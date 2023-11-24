package br.com.cz.Model;

import java.util.UUID;

public class Utilizador<T extends Pessoa> {
    private UUID idUtilizador;
    private String nomeUsuario;
    private String email;
    private String senha;

    public Utilizador(String nomeUsuario, String email, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.idUtilizador = UUID.randomUUID();
    }

    public UUID getIdUtilizador() {
        return idUtilizador;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Utilizador{" +
                "idUtilizador=" + idUtilizador +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
