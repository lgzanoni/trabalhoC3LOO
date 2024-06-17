package entities;

public class Aluno extends Usuario {

    private String nome;
    private String materiaDesejada;
    private String escolaridade;

    public Aluno(String login, String senha, String email, String funcao, String nome, String materiaDesejada,
            String escolaridade) {
        super(login, senha, email, funcao);
        this.nome = nome;
        this.materiaDesejada = materiaDesejada;
        this.escolaridade = escolaridade;
    }

    public Aluno(String login, String senha, String email, String funcao) {
        super(login, senha, email, funcao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMateriaDesejada() {
        return materiaDesejada;
    }

    public void setMateriaDesejada(String materiaDesejada) {
        this.materiaDesejada = materiaDesejada;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    @Override
    public String toString() {
        return login + ";" + senha + ";" + email + ";" + funcao + ";" + nome + ";" + materiaDesejada + ";" + escolaridade;
    }
}
