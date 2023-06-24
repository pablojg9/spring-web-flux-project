package br.com.gntech.webflux.controller;

import br.com.gntech.webflux.model.request.UserRequest;
import br.com.gntech.webflux.model.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserController {

    @PostMapping
    ResponseEntity<Mono<Void>> save(@Valid @RequestBody UserRequest userRequest);

    @GetMapping("{id}")
    ResponseEntity<Mono<UserResponse>> findById(@PathVariable String id);

    @GetMapping
    ResponseEntity<Flux<UserResponse>> findAll();

    @PatchMapping("{id}")
    ResponseEntity<Mono<UserResponse>> update(@PathVariable String id, UserRequest userRequest);

    @DeleteMapping("{id}")
    ResponseEntity<Mono<Void>> deleteById(@PathVariable String id);


}
