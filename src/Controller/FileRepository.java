package Controller;

import java.io.*;

public class FileRepository {

    public void CreateFile(){

        File file = new File("Arquivo");
        try(FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("1 - Qual o nome e sobrenome do pet?\n2 - Qual o tipo do pet (Cachorro/Gato)?\n3 - Qual o sexo do animal?\n4 - Qual endereço e bairro que ele foi encontrado?\n5 - Qual a idade aproximada do pet?\n6 - Qual o peso aproximado do pet?\n7 - Qual a raça do pet?");
            bw.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void fileReader() {

        File file = new File("Arquivo/formulario.txt");

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String linha;

            while((linha = br.readLine()) != null ){
                System.out.println(linha);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public static String ReadSpecifyLine(int line) {
//        File file = new File("Arquivo/formulario.txt");
//
//        try (FileReader fr2 = new FileReader(file) ;
//            BufferedReader br2 = new BufferedReader(fr2)){
//
//            String linha;
//            int cont = -1;
//            while ((linha = br2.readLine()) != null){
//                if (cont == line){
//                    System.out.println(linha);
//                    return linha;
//                }
//
//                cont++;
//
//            }
//
//            return linha;
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    public static String readSpecifyLine(int targetLine) {
        File file = new File("Arquivo/formulario.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            int cont = 0;

            while ((linha = br.readLine()) != null) {
                if (cont == targetLine) {
                    return linha;
                }
                cont++;
            }

            throw new IllegalArgumentException("Linha não encontrada: " + targetLine);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo", e);
        }
    }

}
