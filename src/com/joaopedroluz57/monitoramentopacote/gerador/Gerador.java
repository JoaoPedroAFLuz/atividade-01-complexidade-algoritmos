package com.joaopedroluz57.monitoramentopacote.gerador;

import com.joaopedroluz57.monitoramentopacote.container.Container;
import com.joaopedroluz57.monitoramentopacote.pacote.Pacote;

import java.util.List;

public interface Gerador {

    List<Pacote> gerarPacotes(Integer quantidade);

    List<Pacote> gerarPacotesEspeciais(Integer quantidade);

    List<Container> gerarContainers(Integer quantidade);

}
