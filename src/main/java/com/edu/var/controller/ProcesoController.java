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
        System.out.println("Var del Sistema user email: " + emailO);

        String passworx = System.getProperty("USER_PASSWORD");
        System.out.println("Var del Sistema password: " + passworx);

        String usuario = env.getProperty("spring.mail.username");
        String password = env.getProperty("spring.mail.password");

        System.out.println("=========================================================");
        System.out.println("Credenciales SMTP - encriptadas");
        System.out.println("Usuario - Email: " + usuario);
        System.out.println("Usuario - Password: " + password);
        System.out.println("=========================================================");
        return ResponseEntity.ok(usuario + " " + password);
    }

}
