package ru.isko.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * created by Iskander Valiev
 * on 12/1/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storageFileName;

    private String originalFileName;

    private long size;

    private String type;

    private String url;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "photo", cascade = CascadeType.DETACH)
    private List<User> user;

    @OneToOne(mappedBy = "image")
    private News news;

    @OneToOne(mappedBy = "flag")
    private Country country;
}
