package arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class LeitorArquivo<T>
{
    protected Scanner entrada;

    /**
     * Construtor
     *
     * @throws FileNotFoundException => Exceção se não encontrar o arquivo
     */
    public LeitorArquivo() throws FileNotFoundException
    {
        try {
            this.entrada = new Scanner(new File(
                // "src/files/" + getNomeArquivo().getArquivo()
                getClass().getResource("../resources/files/" + getArquivo().getNomeArquivo()).getPath()
            ));
        }
        catch(FileNotFoundException e) {
            throw new FileNotFoundException("ARQUIVO NÃO ENCONTRADO");
        }
    }
    
    protected abstract Arquivos getArquivo();

    /**
     * Ler os dados contidos no arquivo
     */
    public List<T> ler() throws NoSuchElementException
    {
        List<T> lista = new ArrayList();
        String linha;
        
        if(this.entrada.hasNext())
            while(this.entrada.hasNext())
            {
                linha = this.entrada.nextLine();
                
                if(!linha.isEmpty())
                    lista.add(separarDados(linha));
            }
        
        return lista;
    }

    /**
     * Transformar uma linha do arquivo em um objeto do tipo
     */
    protected abstract T separarDados(String linha)
        throws NoSuchElementException, ArrayIndexOutOfBoundsException;

    /**
     * Fechar o arquivo de leitura
     *
     * @throws IllegalStateException => Exceção causada se não conseguir fechar
     * o arquivo.
     */
    public void fechar() throws IllegalStateException
    {
        try {
            this.entrada.close();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("ERRO AO FECHAR O ARQUIVO");
        }
    }
}
