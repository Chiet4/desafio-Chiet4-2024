package com.anchietaalbano;

import java.util.List;

public class ResultadoAnalise {
    private final String erro;
    private final List<String> recintosViaveis;

    public ResultadoAnalise(String erro, List<String> recintosViaveis) {
        this.erro = erro;
        this.recintosViaveis = recintosViaveis;
    }

    public String getErro() {
        return erro;
    }

    public List<String> getRecintosViaveis() {
        return recintosViaveis;
    }
}
