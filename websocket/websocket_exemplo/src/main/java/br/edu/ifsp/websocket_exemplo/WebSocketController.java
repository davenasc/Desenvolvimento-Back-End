package br.edu.ifsp.websocket_exemplo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller 
public class WebSocketController {
    @MessageMapping("/mensagem")
    @SendTo("/topic/publico")

    public String messageHandler(String msg){
        return "servidor recebeu: " + msg;
    }

}
