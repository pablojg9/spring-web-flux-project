package br.com.gntech.webflux.service;


import br.com.gntech.webflux.entity.User;
import br.com.gntech.webflux.mapper.UserMapper;
import br.com.gntech.webflux.model.request.UserRequest;
import br.com.gntech.webflux.repository.UserRepository;
import br.com.gntech.webflux.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public Mono<User> save(final UserRequest userRequest) {
        return repository.save(mapper.toEntity(userRequest));
    }

    public Mono<User> findById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(
                        new ObjectNotFoundException(format("Object not found. id: %s, type: %s", id, User.class.getSimpleName()))
                ));
    }

}
