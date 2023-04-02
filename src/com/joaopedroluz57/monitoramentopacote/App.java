package com.joaopedroluz57.monitoramentopacote;

import com.joaopedroluz57.monitoramentopacote.container.Container;
import com.joaopedroluz57.monitoramentopacote.impl.GeradorImpl;
import com.joaopedroluz57.monitoramentopacote.pacote.Pacote;

import java.util.ArrayList;
import java.util.List;

public class App {

    // Cada container possui 5 pacotes, no final serão simulados 10 pacotes como pede o descritivo da atividade.
    private static final Integer QUANTIDADE_DE_CONTAINERS = 2;
    private static final Integer[] IDENTIFICADORES_DOS_PACOTES_ESPECIAIS = {1, 10, 32, 42};

    public static void main(String[] args) {

        GeradorImpl gerador = new GeradorImpl();

        List<Pacote> pacotesMonitorados = gerador.pacotesMonitorados;
        List<Container> containersMonitorados = gerador.gerarContainers(QUANTIDADE_DE_CONTAINERS);

        List<Pacote> pacotesEspeciais = gerador.buscarPacotesEspeciais(IDENTIFICADORES_DOS_PACOTES_ESPECIAIS);

        List<Pacote> pacotesEspeciaisEncontrados = new ArrayList<>();

        for (Pacote pacoteEspecial : pacotesEspeciais) {
            for (Container container : containersMonitorados) {
                for (Pacote pacote : container.getPacotes()) {
                    if (pacote.equals(pacoteEspecial)) {
                        pacotesEspeciaisEncontrados.add(pacote);
                    }
                }
            }
        }

        System.out.println("##### Pacotes Monitorados #####");

        for (Pacote pacote : pacotesMonitorados) {
            System.out.println(pacote);
        }

        System.out.println("\n###############################\n");


        System.out.println("###### Pacotes Especiais ######");

        if (pacotesEspeciais.isEmpty()) {
            System.out.println("Nenhum pacote especial encontrado");
        } else {
            for (Pacote pacote : pacotesEspeciaisEncontrados) {
                System.out.println(pacote);
            }
        }

        System.out.println("\n###############################");

    }

}
