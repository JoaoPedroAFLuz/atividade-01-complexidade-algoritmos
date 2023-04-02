package com.joaopedroluz57.monitoramentopacote.container;

import com.joaopedroluz57.monitoramentopacote.pacote.Pacote;

import java.util.List;

public class Container {

    private Integer id;
    private List<Pacote> pacotes;

    public Container() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Pacote> getPacotes() {
        return pacotes;
    }

    public void setPacotes(List<Pacote> pacotes) {
        this.pacotes = pacotes;
    }

    @Override
    public String toString() {
        return id.toString() + "\nPacotes:\n" + pacotes.toString();
    }
}