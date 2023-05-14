package com.joaopedroluz57.monitoramentopacote;

import com.joaopedroluz57.monitoramentopacote.modelo.navio.Navio;
import com.joaopedroluz57.monitoramentopacote.modelo.pacote.Pacote;
import com.joaopedroluz57.monitoramentopacote.borda.impl.GeradorImpl;
import com.joaopedroluz57.monitoramentopacote.nuvem.pesquisador.PesquisadorPacote;

import java.util.ArrayList;
import java.util.List;

public class App {

    // Cada container possui 5 pacotes, no final serão simulados 10 pacotes como pede o descritivo da atividade.
    private static final Integer QUANTIDADE_DE_NAVIOS = 10;
    private static final Integer QUANTIDADE_DE_PACOTES_ESPECIAIS = 15;

    private static final List<PesquisadorPacote> pesquisadorPacotes = new ArrayList<>();
    private static final List<Thread> executores = new ArrayList<>();


    public static void iniciarProcessamentoDePesquisa(List<Navio> navios, List<Pacote> pacotesEspeciais) {
        for (Navio navio : navios) {
            PesquisadorPacote pesquisador = new PesquisadorPacote(navio, pacotesEspeciais);
            Thread thread = new Thread(pesquisador);
            pesquisadorPacotes.add(pesquisador);
            executores.add(thread);
            thread.start();
        }
    }

    public static void esperarFinalizacaoDosExecutores() throws InterruptedException {
        for (Thread executor : executores) {
            executor.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GeradorImpl gerador = new GeradorImpl();

        List<Navio> naviosMonitorados = gerador.gerarNavio(QUANTIDADE_DE_NAVIOS);
        List<Pacote> pacotesEspeciais = gerador.gerarPacotesEspeciais(QUANTIDADE_DE_PACOTES_ESPECIAIS, naviosMonitorados);

        System.out.println("##### Iniciando pesquisadores de pacotes #####");
        iniciarProcessamentoDePesquisa(naviosMonitorados, pacotesEspeciais);
        esperarFinalizacaoDosExecutores();

        System.out.println("\n### Pacotes especiais encontrados ###");
        for (PesquisadorPacote pesquisador : pesquisadorPacotes) {
            for (Pacote pacote: pesquisador.getPacotesEspeciaisEncontrados()) {
                System.out.println(pacote);
            }
        }

        System.out.println("### Simulação finalizada ###");

    }

}
