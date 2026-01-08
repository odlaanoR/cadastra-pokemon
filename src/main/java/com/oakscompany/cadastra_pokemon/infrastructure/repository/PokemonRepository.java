package com.oakscompany.cadastra_pokemon.infrastructure.repository;

import com.oakscompany.cadastra_pokemon.infrastructure.entitys.Pokemon;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    Optional<Pokemon> findByPokedexnum(Integer pokedexnum);

    @Transactional
    void deleteByPokedexnum(Integer pokedexnum);
}
