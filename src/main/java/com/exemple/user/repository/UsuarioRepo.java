package com.exemple.user.repository;

import com.exemple.user.dto.UsuarioDTO;
import com.exemple.user.entity.Usuario;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UsuarioRepo extends ReactiveMongoRepository<Usuario, String> {
    Flux<UsuarioDTO> findByAgeBetween(Range<Integer> ageRange);

}
