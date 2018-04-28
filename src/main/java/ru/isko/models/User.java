package ru.isko.models;

import lombok.*;
import ru.isko.security.role.Role;
import ru.isko.security.state.State;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by isko on 9/24/17.
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "bday")
    private Date bday;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo")
    private FileInfo photo;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private State state;

    private String tempPassword;

    @Column(name = "link")
    private String hashLink;

    private String resetPasswordLink;

//    @OneToMany(mappedBy = "author")
//    private List<Comment> comments;
}
