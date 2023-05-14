package com.joaopedroluz57.monitoramentopacote.borda.gerador2;

import com.joaopedroluz57.monitoramentopacote.modelo.container.Container;
import com.joaopedroluz57.monitoramentopacote.modelo.navio.Navio;
import com.joaopedroluz57.monitoramentopacote.modelo.pacote.Pacote;

import java.util.List;

public interface Gerador {

    List<Pacote> gerarPacotes(Integer quantidade);

    List<Pacote> gerarPacotesEspeciais(Integer quantidade, List<Navio> navios);

    List<Navio> gerarNavio(Integer quantidade);

    List<Container> gerarContainers(Integer quantidade);

}
