package com.exemple.user.controller;

import com.exemple.user.dto.UsuarioDTO;
import com.exemple.user.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/user")
public class Controller {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public Flux<UsuarioDTO> getUsers(){
        return service.usuarios();
    }

    @GetMapping("/age")
    public Flux<UsuarioDTO> getUsersByRangeAge(@RequestParam("min") int min, @RequestParam("max") int max){
        return service.getUsuarioByRangeAge(min, max);
    }

    @GetMapping("/{id}")
    public Mono<UsuarioDTO> getUserById(@PathVariable String id){
        return service.getUsuarioById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteUserById(@PathVariable String id){
        return service.deleteUsuario(id);
    }

    @PostMapping
    public Mono<UsuarioDTO> saveUser(@RequestBody Mono<UsuarioDTO> usuarioDTOMono){
        return service.saveUsuario(usuarioDTOMono);
    }

    @PutMapping("/update/{id}")
    public Mono<UsuarioDTO> updateUser(@RequestBody Mono<UsuarioDTO> usuarioDTOMono, @PathVariable String id){
        return service.updateUsuario(usuarioDTOMono, id);
    }

}
