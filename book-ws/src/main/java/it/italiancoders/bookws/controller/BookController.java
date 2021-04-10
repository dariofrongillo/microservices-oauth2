package it.italiancoders.bookws.controller;

import it.italiancoders.bookws.dto.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static java.util.List.of;


@Slf4j
@RestController
public class BookController {

    @GetMapping("/books")
    ResponseEntity<?> getBooks() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt principal= (Jwt) authentication.getPrincipal();
        log.info("Principal {}", principal);
        return ResponseEntity.ok(of(Book.builder().id(0).title("Promessi Sposi").build()));
    }

    @DeleteMapping("/books/{id}")
    ResponseEntity<?> deleteBook(@PathVariable long id) {
        return ResponseEntity.noContent().build();
    }

}
