package entities;

public abstract class Usuario {
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
    
    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
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
    @Override
    public String toString() {
        return "Usuario{" + "login=" + login + ", senha=" + senha + ", email=" + email + ", funcao=" + funcao + '}';
    }
}
