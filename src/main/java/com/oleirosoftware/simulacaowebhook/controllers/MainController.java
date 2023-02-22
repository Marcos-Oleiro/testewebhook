package com.oleirosoftware.simulacaowebhook.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.oleirosoftware.simulacaowebhook.controllers.model.ReturnObj;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MainController {

    @GetMapping("/consulta")
    public ResponseEntity<?> consulta(@RequestHeader Map<String, String> headers) {

        headers.forEach((key, value) -> {
            log.info(String.format("Header '%s' = %s", key, value));
        });

        double random = Math.round(Math.random() * 100);

        ReturnObj returnObj = new ReturnObj();
        returnObj.setProd(Boolean.valueOf(random % 2 == 0));
        log.info("Retorno: {}", returnObj);
        return ResponseEntity.ok(returnObj);
    }

    @PostMapping("/dev")
    public ResponseEntity<?> dev(@RequestBody Object obj, @RequestHeader Map<String, String> headers) {
        log.info("Ambiente DEV chamado");

        // headers.forEach((key, value) -> {
        //     log.info(String.format("Header '%s' = %s", key, value));
        // });

        log.info("Objeto Recebido {}", obj);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/prd")
    public ResponseEntity<?> prd(@RequestBody Object obj, @RequestHeader Map<String, String> headers) {

        log.info("Ambiente PRD chamado");

        // headers.forEach((key, value) -> {
        //     log.info(String.format("Header '%s' = %s", key, value));
        // });

        log.info("Objeto Recebido {}", obj);
        return ResponseEntity.ok(null);
    }
    
    @GetMapping("/clean")
    public ResponseEntity<?> cleanLogs(){
        
        log.info("");
        log.info("");
        log.info("");
        log.info("");
        log.info("");
        log.info("");
        log.info("");
        log.info("");
        log.info("");
        
        return ResponseEntity.ok(null);
    }
}