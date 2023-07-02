package br.com.gntech.webflux.controller.impl;

import br.com.gntech.webflux.controller.UserController;
import br.com.gntech.webflux.mapper.UserMapper;
import br.com.gntech.webflux.model.request.UserRequest;
import br.com.gntech.webflux.model.response.UserResponse;
import br.com.gntech.webflux.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserControllerImpl implements UserController {

    private final UserService service;
    private final UserMapper mapper;


    @Override
    public ResponseEntity<Mono<Void>> save(final UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(userRequest).then());
    }

    @Override
    public ResponseEntity<Mono<UserResponse>> findById(String id) {
        return ResponseEntity.ok(service.findById(id).map(mapper::toResponse));
    }

    @Override
    public ResponseEntity<Flux<UserResponse>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Mono<UserResponse>> update(String id, UserRequest userRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Mono<Void>> deleteById(String id) {
        return null;
    }
}
