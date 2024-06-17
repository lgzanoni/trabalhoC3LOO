package arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class LeitorArquivo<T> {

    protected Scanner entrada;

    /**
     * Construtor
     *
     * @throws FileNotFoundException => Exceção se não encontrar o arquivo
     */
    public LeitorArquivo() throws FileNotFoundException, IOException {
        try {
            String basePath = new File(System.getProperty("user.dir")).getAbsolutePath();
            String fullPath = basePath + File.separator + "files" + File.separator + getArquivo().getNomeArquivo();
            System.out.println("Caminho completo do arquivo: " + fullPath);

            File arquivo = new File(fullPath);
            if (!arquivo.exists()) {
                // Certifica-se de que o diretório pai existe, cria se não existir
                arquivo.getParentFile().mkdirs();
                // Tenta criar o arquivo se ele não existir
                arquivo.createNewFile();
            }
            this.entrada = new Scanner(arquivo);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("ARQUIVO NÃO ENCONTRADO");
        }
    }

    protected abstract Arquivos getArquivo();

    /**
     * Ler os dados contidos no arquivo
     */
    public List<T> ler() throws NoSuchElementException {
        List<T> lista = new ArrayList();
        String linha;

        if (this.entrada.hasNext()) {
            while (this.entrada.hasNext()) {
                linha = this.entrada.nextLine();

                if (!linha.isEmpty()) {
                    lista.add(separarDados(linha));
                }
            }
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
    public void fechar() throws IllegalStateException {
        try {
            this.entrada.close();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("ERRO AO FECHAR O ARQUIVO");
        }
    }
}
