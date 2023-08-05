package br.com.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CaminhoArquivo {


    private Path diretorio;

    private Path arquivo;

    private CaminhoArquivo(Path diretorio, Path arquivo) {
        super();
        this.diretorio = diretorio;
        this.arquivo = arquivo;
    }

    public Path getDiretorio() {
        return diretorio;
    }

    public Path getArquivo() {
        return arquivo;
    }

    public static CaminhoArquivo getInstance(Integer id) {
        String b = "/tmp/", d, a = String.valueOf(id);

        b += id <=1000? 1 : ((double)id /1000) == Integer.parseInt(a.substring(0, a.length()-3)) ? (id /1000): (id /1000)+1;

        d = b +"/"+ id;

        return new CaminhoArquivo(Paths.get(b), Paths.get(d));
    }

    public static RuntimeException getInstance() {

        return new RuntimeException("É esperado um valor inteiro no parâmetro do método CaminhoArquivo.getInstance()");
    }
}
