package com.edu.var.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProcesoController {
    @Autowired
    private Environment env;

    @GetMapping("/credenciales-email")
    public ResponseEntity<String> getCredencialesEmail() {

        String emailO = System.getProperty("USER_EMAIL");
        System.out.println("Var del Sistema emailO: " + emailO);

        String usuario = env.getProperty("dts.username");
        String password = env.getProperty("dts.password");

        System.out.println("Var entorno - encriptada - usuario: " + usuario);
        System.out.println(" - ");
        System.out.println("password: " + password);
        return ResponseEntity.ok(usuario + " " + password);
    }

}
