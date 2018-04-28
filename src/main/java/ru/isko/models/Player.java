package ru.isko.models;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "player_number")
    private int number;

    @Column(name = "player_position")
    private String position;

    @Column(name = "player_name")
    private String name;

    @Column(name = "player_lastname")
    private String lastname;

    @Column(name = "player_age")
    private int age;

    @Column(name = "player_photo")
    private String photo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country.id")
    private Country country;
}
