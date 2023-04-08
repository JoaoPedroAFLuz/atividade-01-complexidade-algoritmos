package com.joaopedroluz57.monitoramentopacote.impl;

import com.joaopedroluz57.monitoramentopacote.container.Container;
import com.joaopedroluz57.monitoramentopacote.gerador.Gerador;
import com.joaopedroluz57.monitoramentopacote.pacote.Pacote;

import java.time.LocalDate;
import java.util.*;

public class GeradorImpl implements Gerador {

    private final static Integer QUANTIDADE_DE_PACOTES_POR_CONTAINER = 5;

    public List<Pacote> pacotesMonitorados = new ArrayList<>();

    /**
     * gera uma lista de pacotes.
     *
     * a complexidade e linear ja que nao possui loops alinhados.
     * @param quantidadeDePacotes que serao gerados.
     * @return lista com a quantidade de pacotes passadas no parametro.
     */
    public List<Pacote> gerarPacotes(Integer quantidadeDePacotes) {
        List<Pacote> pacotes = new ArrayList<>();

        Random random = new Random();
        List<String> cidades = Arrays.asList("São Paulo", "Pequim", "Vitória da Conquista");

        for (int i = 0; i < quantidadeDePacotes; i++) {
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

    /**
     * gera uma lista de pacotes especiais.
     *
     * a complexidade e linear ja que nao possui loops alinhados.
     * @param quantidadeDePacotesEspeciais que serao gerados.
     * @return lista com a quantidade de pacotes especiais passadas no parametro.
     */
    public List<Pacote> gerarPacotesEspeciais(Integer quantidadeDePacotesEspeciais) {
        List<Pacote> pacotesEspeciais = new ArrayList<>();

        for (int i = 0; i < quantidadeDePacotesEspeciais; i++) {
            Random random = new Random();

            int identificadorPacoteEspecial = random.nextInt(quantidadeDePacotesEspeciais * 2);

            if (identificadorPacoteEspecial < pacotesMonitorados.size()) {
                Pacote pacote = pacotesMonitorados.get(identificadorPacoteEspecial);

                if (!pacotesEspeciais.contains(pacote)) {
                    pacotesEspeciais.add(pacote);
                }
            }
        }

        return pacotesEspeciais;
    }

    /**
     * gera uma lista de containers.
     *
     * a complexidade e linear ja que nao possui loops alinhados.
     * @param quantidadeDeContainers que serao gerados.
     * @return lista com a quantidade de containers passadas no parametro.
     */
    public List<Container> gerarContainers(Integer quantidadeDeContainers) {
        List<Container> containersMonitorados = new ArrayList<>();

        for (int i = 0; i < quantidadeDeContainers; i++) {
            Container container = new Container();

            List<Pacote> pacotes = gerarPacotes(QUANTIDADE_DE_PACOTES_POR_CONTAINER);

            container.setId(containersMonitorados.size() + 1);
            container.setPacotes(pacotes);

            containersMonitorados.add(container);
        }

        return containersMonitorados;
    }

}
