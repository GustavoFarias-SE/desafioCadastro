package Controller.EnumUtils;

import model.Pet;

public class EnumUtils {
    public static Pet.TipoPet parseTipoPet(String entrada){
        entrada = entrada.trim().toUpperCase();

        switch (entrada){
            case "CACHORRO":
                return Pet.TipoPet.CACHORRO;
            case "GATO":
                return Pet.TipoPet.GATO;
            default:
                throw new IllegalArgumentException("Tipo do pet inválido, escolha entre cachorro ou gato");
        }
    }

    public static Pet.SexoPet parseSexoPet(String entrada){
        entrada = entrada.trim().toUpperCase();

        switch (entrada){
            case "MACHO":
                return Pet.SexoPet.MACHO;
            case "FEMEA":
                return Pet.SexoPet.FEMEA;
            default:
                throw new IllegalArgumentException("Sexo do pet inválido, use 'machou' ou 'femea'");
        }
    }
}
