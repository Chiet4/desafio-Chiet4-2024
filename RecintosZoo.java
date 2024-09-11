package com.anchietaalbano;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecintosZoo {

    private final List<Recinto> recintos;
    private final List<Animal> animais;

    public RecintosZoo() {
        // Inicializa os recintos
        recintos = new ArrayList<>();
        recintos.add(new Recinto("Recinto 1", "savana", 5, 10));
        recintos.add(new Recinto("Recinto 2", "floresta", 3, 5));
        recintos.add(new Recinto("Recinto 3", "savana", 2, 7));
        recintos.add(new Recinto("Recinto 4", "rio", 5, 8));

        // Inicializa os animais
        animais = new ArrayList<>();
        animais.add(new Animal("LEAO", 3, List.of("savana")));
        animais.add(new Animal("LEOPARDO", 2, List.of("savana")));
        animais.add(new Animal("CROCODILO", 3, List.of("rio")));
        animais.add(new Animal("MACACO", 1, List.of("savana", "floresta")));
        animais.add(new Animal("GAZELA", 2, List.of("savana")));
        animais.add(new Animal("HIPOPOTAMO", 4, List.of("savana", "rio")));
    }

    public ResultadoAnalise analisaRecintos(String tpanimal, int quantidade) {
        // Inicializa o objeto de resultado
        ResultadoAnalise resultado = new ResultadoAnalise(null, new ArrayList<>());

        // Seleciona o animal com base na espécie
        Optional<Animal> selecionarAnimal = animais.stream()
                .filter(animal -> animal.getEspecie().equalsIgnoreCase(tpanimal))
                .findFirst();

        // Se o animal não for encontrado, retorna um erro
        if (selecionarAnimal.isEmpty()) {
            return new ResultadoAnalise("Animal inválido", null);
        }

        Animal animal = selecionarAnimal.get();

        // Valida a quantidade de animais
        if (quantidade <= 0) {
            return new ResultadoAnalise("Quantidade inválida", null);
        }

        // Filtra os recintos que têm espaço livre suficiente e correspondem ao bioma do animal
        List<Recinto> recintosFiltrados = recintos.stream()
                .filter(recinto -> recinto.getEspacoLivre() >= quantidade &&
                        animal.getBioma().contains(recinto.getBioma()))
                .toList();

        // Se não houver recintos viáveis, retorna um erro
        if (recintosFiltrados.isEmpty()) {
            return new ResultadoAnalise("Não há recinto viável", null);
        }

        // Mapeia os recintos viáveis para strings formatadas
        List<String> recintosViaveis = recintosFiltrados.stream()
                .map(recinto -> String.format("%s (bioma: %s, espaço livre: %d, total: %d)",
                        recinto.getNome(), recinto.getBioma(), recinto.getEspacoLivre(), recinto.getCapacidadeTotal()))
                .collect(Collectors.toList());

        // Retorna o resultado com os recintos viáveis
        return new ResultadoAnalise(null, recintosViaveis);
    }


    public static void main(String[] args) {
        // Instancia o RecintosZoo
        RecintosZoo zoo = new RecintosZoo();

        // Exemplo de análise de recintos
        ResultadoAnalise resultado = zoo.analisaRecintos("LEAO", 2);

        // Exibe o resultado
        if (resultado.getErro() != null) {
            System.out.println("Erro: " + resultado.getErro());
        } else {
            System.out.println("Recintos viáveis:");
            resultado.getRecintosViaveis().forEach(System.out::println);
        }
    }
}
