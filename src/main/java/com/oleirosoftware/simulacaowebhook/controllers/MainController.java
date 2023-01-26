package com.oleirosoftware.simulacaowebhook.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oleirosoftware.simulacaowebhook.controllers.model.ReturnObj;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MainController {
    

    @GetMapping("/consulta")
    public ResponseEntity<?> consulta(){
        
        double random = Math.round(Math.random()*100);

        ReturnObj returnObj = new ReturnObj();
        returnObj.setProd(Boolean.valueOf(random%2==0));
        log.info("Retorno: {}", returnObj);
        return ResponseEntity.ok(returnObj);
    }
    
    @GetMapping("/dev")
    public ResponseEntity<?> dev(){
        log.info("Ambiente DEV chamado");
        return ResponseEntity.ok(null);
    }
    
    @GetMapping("/prd")
    public ResponseEntity<?> prd(){
        log.info("Ambiente PRD chamado");
        return ResponseEntity.ok(null);
    }
}