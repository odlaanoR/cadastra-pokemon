package com.oakscompany.cadastra_pokemon.controller;

import com.oakscompany.cadastra_pokemon.business.PokemonService;
import com.oakscompany.cadastra_pokemon.infrastructure.entitys.Pokemon;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor

public class PokemonController {

    private final PokemonService pokemonService;

    @PostMapping //para gravar dados
    public ResponseEntity<Void> salvarPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.salvarPokemon(pokemon);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Pokemon> buscarPokemonPorPokedex(@RequestParam Integer pokedexnum) {
        return ResponseEntity.ok(pokemonService.buscarPokemonPorPokedex(pokedexnum));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarPokemonPorPokedex(@RequestParam Integer pokedexnum) {
        pokemonService.deletarPokemonPorPokedex(pokedexnum);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarPokemonPorPokedex(@RequestParam Integer pokedexnum,
                                                      @RequestBody Pokemon pokemon) {
        pokemonService.atualizarPokemonPorPokedex(pokedexnum, pokemon);
        return ResponseEntity.ok().build();
    }
}