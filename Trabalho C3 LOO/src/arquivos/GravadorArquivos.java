package arquivos;
import java.io.*;

public class GravadorArquivos
{
    private FileWriter writer;
    private PrintWriter saida;

    /**
     * Construtor
     * 
     * @param nome => nome do arquivo que será aberto para gravação
     * @throws IOException => Exceção se houver algum problema se o arquivo não
     * puder ser aberto para grava��o
     */
    public GravadorArquivos(Arquivos arquivo) throws IOException
    {
        try {
            // false significa que se o arquivo já existir, ele será sobrescrito
            // caso queira acrescentar dados ao final do arquivo, deve usar true
            writer = new FileWriter(
                new File(getClass().getResource("../files/" + arquivo.getNomeArquivo()).getPath()),
                true
            );
            
            saida = new PrintWriter (writer);
        }
        catch(IOException e) {
            throw new IOException ("ARQUIVO N�O PODE SER ABERTO PARA GRAVA��O");
        }
    }

    /**
     * Este método grava uma String qualquer em um arquivo tipo texto
     * @param str => String a ser gravada no arquivo
     */
    public void gravar(String str)
    {
        this.saida.println(str);
    }
    
    /**
     * Método para fechar o arquivo de gravação
     * @throws IOException => Exceção, se ocorrer erro ao fechar o arquivo.
     */
    public void fechar() throws IOException
    {
        try {
            this.saida.close();
            this.writer.close();
        }
        catch(IOException e) {
            throw new IOException ("ERRO AO FECHAR O ARQUIVO");
        }
    }
}
