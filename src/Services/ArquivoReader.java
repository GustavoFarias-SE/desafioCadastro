package Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoReader {
    public static void main(String[] args) {

        File file = new File("Arquivo/formulario.txt");

        try (FileReader fr = new FileReader(file);
             BufferedReader bf = new BufferedReader(fr)) {

            String linha;

            while((linha = bf.readLine()) != null ){
                System.out.println(linha);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
