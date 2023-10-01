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

    /*
    public ProcesoController(Environment env) {
        this.env = env;
    }
*/
    @GetMapping("/credenciales-email")
    public ResponseEntity<String> getCredencialesEmail() {
        String usuario = env.getProperty("dts.username");
        String password = env.getProperty("dts.password");
        System.out.println("usuario: " + usuario);
        System.out.println("password: " + password);
        return ResponseEntity.ok(usuario + " " + password);
    }

}
