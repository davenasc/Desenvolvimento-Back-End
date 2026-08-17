package br.edu.ifsp.bra.tarefa;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//mesmo alterando para service a saída continua a mesma.
//após alterar para o AppConfig e usar a notation @configuration, continua funcionando.
public class TarefaImpl implements Tarefa {

    @Override
    public void executar() {
        System.out.println("Executando tarefa...");
    }
}
