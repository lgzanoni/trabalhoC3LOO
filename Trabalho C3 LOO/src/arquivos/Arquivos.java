package arquivos;

/**
 *
 * @author Luis
 */
public enum Arquivos {
    TUTORES("tutores.txt"),
    ALUNOS("alunos.txt"),
    USUARIOS("usuarios.txt");
    
    private String nomeArquivo;

    private Arquivos(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }
}
