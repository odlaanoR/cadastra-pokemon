package com.oakscompany.cadastra_pokemon.business;

import com.oakscompany.cadastra_pokemon.infrastructure.entitys.Pokemon;
import com.oakscompany.cadastra_pokemon.infrastructure.repository.PokemonRepository;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    private final PokemonRepository repository;

    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }

    public void salvarPokemon(Pokemon pokemon) {
        repository.saveAndFlush(pokemon);
    }

    public Pokemon buscarPokemonPorPokedex(Integer pokedexnum) {

        return repository.findByPokedexnum(pokedexnum).orElseThrow(
                () -> new RuntimeException("Número da pokedéx não encontrado!")
        );
    }

    public void deletarPokemonPorPokedex(Integer pokedexnum) {
        repository.deleteByPokedexnum(pokedexnum);
    }

    public void atualizarPokemonPorPokedex(Integer pokedexnum, Pokemon pokemon) {
        Pokemon pokemonEntity = buscarPokemonPorPokedex(pokedexnum);
        Pokemon pokemonAtualizado = Pokemon.builder()
                .pokedexnum(pokedexnum)
                .nome(pokemon.getNome() != null ?
                        pokemon.getNome() : pokemonEntity.getNome())
                .tipo1(pokemon.getTipo1() != null ?
                        pokemon.getTipo1() : pokemonEntity.getTipo1())
                .tipo2(pokemon.getTipo2() != null ?
                        pokemon.getTipo2() : pokemonEntity.getTipo2())
                .id(pokemonEntity.getId())
                .build();
        repository.saveAndFlush(pokemonAtualizado);
    }
}