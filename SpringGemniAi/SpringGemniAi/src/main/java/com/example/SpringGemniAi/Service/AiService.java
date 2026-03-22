package com.example.SpringGemniAi.Service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private ChatClient chatClient;

    public AiService(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    public String getResponseFromAi(String prompt){
        var response = chatClient.prompt(prompt).call().content();
        return response;
    }
}
