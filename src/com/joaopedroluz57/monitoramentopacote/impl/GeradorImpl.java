package com.joaopedroluz57.monitoramentopacote.impl;

import com.joaopedroluz57.monitoramentopacote.container.Container;
import com.joaopedroluz57.monitoramentopacote.gerador.Gerador;
import com.joaopedroluz57.monitoramentopacote.pacote.Pacote;

import java.time.LocalDate;
import java.util.*;

public class GeradorImpl implements Gerador {

    private final static Integer QUANTIDADE_DE_PACOTES_POR_CONTAINER = 5;

    public List<Pacote> pacotesMonitorados = new ArrayList<>();

    public List<Pacote> gerarPacotes(Integer quantidade) {
        List<Pacote> pacotes = new ArrayList<>();

        Random random = new Random();
        List<String> cidades = Arrays.asList("São Paulo", "Pequim", "Vitória da Conquista");

        for (int i = 0; i < quantidade; i++) {
            int month = random.nextInt(6) + 1;
            int day = random.nextInt(28) + 1;
            int indexCidadeOrigem = random.nextInt(cidades.size());
            int indexCidadeDestino = random.nextInt(cidades.size());

            Pacote pacote = new Pacote(
                    pacotesMonitorados.size() + 1, cidades.get(indexCidadeOrigem), cidades.get(indexCidadeDestino), LocalDate.of(2023, month, day)
            );

            pacotes.add(pacote);
            this.pacotesMonitorados.add(pacote);
        }

        return pacotes;
    }

    public List<Pacote> buscarPacotesEspeciais(Integer[] identificadores) {
        List<Pacote> pacotesEspeciais = new ArrayList<>();

        for (Integer identificador : identificadores) {
            if (identificador <= pacotesMonitorados.size()) {
                Pacote pacote = pacotesMonitorados.get(identificador - 1);

                pacotesEspeciais.add(pacote);
            }
        }

        return pacotesEspeciais;
    }

    public List<Container> gerarContainers(Integer quantidade) {
        List<Container> containersMonitorados = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            Container container = new Container();

            List<Pacote> pacotes = gerarPacotes(QUANTIDADE_DE_PACOTES_POR_CONTAINER);

            container.setId(containersMonitorados.size() + 1);
            container.setPacotes(pacotes);

            containersMonitorados.add(container);
        }

        return containersMonitorados;
    }

}
