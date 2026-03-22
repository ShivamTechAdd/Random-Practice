package com.example.SpringGemniAi.Controller;

import com.example.SpringGemniAi.Service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {
    @Autowired
    private AiService aiService;

    @GetMapping
    public ResponseEntity<String> getResponseFromAi(@RequestParam String q){
        String res = aiService.getResponseFromAi(q);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }
}








































