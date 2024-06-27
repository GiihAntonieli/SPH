package DTO;

public class Edificio {
    // Campos da tabela Edificio
    private int id_edificio;
    private String nome_ed;
    private String endereco;
    private String nome_user;
    private String email;
    private String senha;
    
    // Métodos Especiais
        // Getters and Setters
    public int getId_edificio() {
        return id_edificio;
    }
    public void setId_edificio(int id_edificio) {
        this.id_edificio = id_edificio;
    }

    public String getNome_ed() {
        return nome_ed;
    }
    public void setNome_ed(String nome_ed) {
        this.nome_ed = nome_ed;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome_user() {
        return nome_user;
    }
    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
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
    
    
}
