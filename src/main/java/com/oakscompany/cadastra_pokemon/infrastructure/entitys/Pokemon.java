package com.oakscompany.cadastra_pokemon.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pokemon")
@Entity

public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "pokedexnum", unique = true)
    private Integer pokedexnum;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo1")
    private String tipo1;

    @Column(name = "tipo2")
    private String tipo2;
}
