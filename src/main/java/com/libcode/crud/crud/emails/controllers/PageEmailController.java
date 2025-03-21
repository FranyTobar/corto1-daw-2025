package com.libcode.crud.crud.emails.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.libcode.crud.crud.emails.entities.Email;
import com.libcode.crud.crud.emails.repository.EmailRepository;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class PageEmailController {

    @Autowired
    private EmailRepository emailRepository;

    @GetMapping("/test/{email}")
    public Email comprobarEmail(@PathVariable String email) {
        Random random = new Random();
        boolean authorized = random.nextBoolean(); // Genera un valor booleano aleatorio
        
        // Crear un nuevo objeto Email con el correo y el valor booleano generado
        Email emailToSave = new Email(email, authorized);
        
        // Guardar el objeto Email en la base de datos usando el repositorio
        Email savedEmail = emailRepository.save(emailToSave);
        
        // Retornar el objeto guardado
        return savedEmail;
    }
}         
