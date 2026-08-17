package br.edu.ifsp.bra.intro_spring;

import org.springframework.stereotype.Component;

@Component
public class GeradorProtocolo {
    public String gerar(){
        return "PROT - " + System.currentTimeMillis();
    }
}
