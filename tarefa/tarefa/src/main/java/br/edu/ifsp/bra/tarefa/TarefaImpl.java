package br.edu.ifsp.bra.tarefa;

import org.springframework.stereotype.Component;

@Component
public class TarefaImpl implements Tarefa {

    @Override
    public void executar() {
        System.out.println("Executando uma tarefa...");
    }    
}
