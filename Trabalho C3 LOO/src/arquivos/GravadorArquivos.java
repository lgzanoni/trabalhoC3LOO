package arquivos;

import java.io.*;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GravadorArquivos {

    private FileWriter writer;
    private PrintWriter saida;

    /**
     * Construtor
     *
     * @param nome => nome do arquivo que será aberto para gravação
     * @throws IOException => Exceção se houver algum problema se o arquivo não
     * puder ser aberto para grava��o
     */
    public GravadorArquivos(Arquivos arquivo) throws IOException {
        try {
            // false significa que se o arquivo já existir, ele será sobrescrito
            // caso queira acrescentar dados ao final do arquivo, deve usar true
            String basePath = new File(System.getProperty("user.dir")).getAbsolutePath();
            File directory = new File(basePath + File.separator + "files");
            if (!directory.exists()) {
                directory.mkdirs();  // Cria o diretório se ele não existir
            }
            File file = new File(basePath + File.separator + "files" + File.separator + arquivo.getNomeArquivo());
            writer = new FileWriter(file, true);  // true para acrescentar ao arquivo, false para sobrescrever
            saida = new PrintWriter(writer);
        } catch (IOException e) {
            throw new IOException("ARQUIVO N�O PODE SER ABERTO PARA GRAVA��O");
        }
    }

    /**
     * Este método grava uma String qualquer em um arquivo tipo texto
     *
     * @param str => String a ser gravada no arquivo
     */
    public void gravar(String str) {
        this.saida.println(str);
    }

    /**
     * Método para fechar o arquivo de gravação
     *
     * @throws IOException => Exceção, se ocorrer erro ao fechar o arquivo.
     */
    public void fechar() throws IOException {
        try {
            this.saida.close();
            this.writer.close();
        } catch (IOException e) {
            throw new IOException("ERRO AO FECHAR O ARQUIVO");
        }
    }
}
