package c3loo.entities;

public class Tutor extends Usuario{
    private String nome;
    private String especialidade;
    private String graduacao;
    
    public Tutor(String login, String senha, String email, String funcao, String nome, String especialidade,
            String graduacao) {
        super(login, senha, email, funcao);
        this.nome = nome;
        this.especialidade = especialidade;
        this.graduacao = graduacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
        }
}
