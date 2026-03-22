package com.spring.ai.springAi.Controlers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AiController {

    private ChatClient chatClient;

    public AiController(ChatClient.Builder builder){
         this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<?> chat(@RequestParam String q){
        var resultResponse = chatClient.prompt(q).call().content();
        return new ResponseEntity<>(resultResponse, HttpStatus.OK);
    }
}
