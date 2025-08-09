package Controller.Files;

import model.Pet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PetWriter {

    public static void salvarPetEmArquivo(Pet pet) {
        File pasta = new File("petsCadastrados");

        if (!pasta.exists()){
            pasta.mkdirs();
        }

        //Nome do arquivo
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm"));
        String nomePetInformado = pet.getNome().toUpperCase().replace(" ", "");
        String nomeArquivo = timeStamp + "-" + nomePetInformado + ".txt";

        File arquivo = new File(pasta, nomeArquivo);

        //Escrevendo no arquivo
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo))){
            escritor.write(pet.getNome());
            escritor.newLine();
            escritor.write(pet.getTipoPet().toString());
            escritor.newLine();
            escritor.write(pet.getSexoPet().toString());
            escritor.newLine();
            escritor.write(pet.getEndereco());
            escritor.newLine();
            escritor.write(pet.getIdade());
            escritor.newLine();
            escritor.write(pet.getPeso() + "kg");
            escritor.newLine();
            escritor.write(pet.getRaca());

        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }

        System.out.println("Arquivo salvo com sucesso! ");

    }


}
