package com.joaopedroluz57.monitoramentopacote.pacote;

import java.time.LocalDate;

public class Pacote {

    private Integer id;
    private String origem;
    private String destino;
    private LocalDate previsaoEntrega;

    public Pacote(Integer id, String origem, String destino, LocalDate previsaoEntrega) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.previsaoEntrega = previsaoEntrega;
    }

    @Override
    public String toString() {
        return "\nIdentificador: " + this.id + "\nOrigem: " + this.origem + "\nDestino: "
                + this.destino + "\nPrevisão de entrega: " + this.previsaoEntrega.toString();
    }

}
