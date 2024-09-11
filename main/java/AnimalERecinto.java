package com.anchietaalbano;

import java.util.List;


class Animal {
    private String especie;
    private int tamanho;
    private List<String> bioma;

    public Animal(String especie, int tamanho, List<String> bioma) {
        this.especie = especie;
        this.tamanho = tamanho;
        this.bioma = bioma;
    }

    public String getEspecie() {
        return especie;
    }

    public int getTamanho() {
        return tamanho;
    }

    public List<String> getBioma() {
        return bioma;
    }

}

class Recinto {
    private String nome;
    private String bioma;  // Novo atributo
    private int espacoLivre;
    private int capacidadeTotal;

    public Recinto(String nome, String bioma, int espacoLivre, int capacidadeTotal) {
        this.nome = nome;
        this.bioma = bioma;  // Inicializa o novo atributo
        this.espacoLivre = espacoLivre;
        this.capacidadeTotal = capacidadeTotal;
    }

    public String getNome() {
        return nome;
    }

    public String getBioma() {
        return bioma;  // Getter para o bioma
    }

    public int getEspacoLivre() {
        return espacoLivre;
    }

    public int getCapacidadeTotal() {
        return capacidadeTotal;
    }
}


