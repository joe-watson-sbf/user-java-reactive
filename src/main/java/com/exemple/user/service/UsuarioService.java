package com.exemple.user.service;

import com.exemple.user.dto.UsuarioDTO;
import com.exemple.user.repository.UsuarioRepo;
import com.exemple.user.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo repository;

    public Flux<UsuarioDTO> usuarios(){
        return repository.findAll().map(Mapper::entityToDTO); // convert each Entity to DTO
    }

    public Mono<UsuarioDTO> getUsuarioById(String id){
        return repository.findById(id).map(Mapper::entityToDTO); // convert the found entity to DTO
    }

    public Flux<UsuarioDTO> getUsuarioByRangeAge(int min, int max){

        return repository.findByAgeBetween(Range.closed(min,max)); // Custom query
    }

    public Mono<UsuarioDTO> saveUsuario(Mono<UsuarioDTO> usuarioDTOMono){
        return usuarioDTOMono.map(Mapper::dtoToEntity) // convert the DTO entry to Entity
                .flatMap(repository::insert) // Save the entity in the DataBase and return the entity saved
                .map(Mapper::entityToDTO); // Convert the entity saved to DTO
    }

    public Mono<UsuarioDTO> updateUsuario(Mono<UsuarioDTO> usuarioDTOMono, String id){
        return repository.findById(id) // first try to get the user on the database
                .flatMap( usuario -> usuarioDTOMono.map(Mapper::dtoToEntity)) // convert the user found with the properties of the entry DTO
                .doOnNext(newUsuario -> newUsuario.setId(id)) // make sure the new entity id is the same with the param id
                .flatMap(repository::save) // save the entity and return it
                .map(Mapper::entityToDTO); // convert the return entity to DTO
    }

    public Mono<Void> deleteUsuario(String id){
        return repository.deleteById(id);
    }




}
