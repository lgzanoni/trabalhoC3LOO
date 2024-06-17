package arquivos;

import entities.Tutor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 *
 * @author Luis
 */
public class LeitorArquivoTutor extends LeitorArquivo<Tutor> {

    public LeitorArquivoTutor() throws FileNotFoundException, IOException {
        super();
    }

    @Override
    protected Arquivos getArquivo() {
        return Arquivos.TUTORES;
    }

    @Override
    protected Tutor separarDados(String linha) throws NoSuchElementException, ArrayIndexOutOfBoundsException {
        String[] dados = linha.split(";");

        // Executa .trim() em todos os dados
        for (int i = 0; i < dados.length; i++) {
            dados[i] = dados[i].trim();
        }

        return new Tutor(
                dados[0],
                dados[1],
                dados[2],
                dados[3],
                dados[4],
                dados[5],
                dados[6]
        ){};
    }
}
