package c3loo.entities;

public class Usuario {
    protected String login;
    protected String senha;
    protected String email;
    protected String funcao;
    
    public Usuario(String login, String senha, String email, String funcao) {
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.funcao = funcao;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
