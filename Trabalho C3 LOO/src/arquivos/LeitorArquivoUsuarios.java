package arquivos;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import entities.Usuario;
import java.io.IOException;

public class LeitorArquivoUsuarios extends LeitorArquivo<Usuario>
{
    public LeitorArquivoUsuarios() throws FileNotFoundException, IOException {
        super();
    }
    
    @Override
    protected Arquivos getArquivo() {
        return Arquivos.USUARIOS;
    }

    @Override
    protected Usuario separarDados(String linha) throws NoSuchElementException, ArrayIndexOutOfBoundsException 
    {
        String[] dados = linha.split(";");
            
        // Executa .trim() em todos os dados
        for(int i = 0; i < dados.length; i++)
            dados[i] = dados[i].trim();

        return new Usuario(
            dados[0],
            dados[1],
            dados[2],
            dados[3]
        ) {};
    }
}
