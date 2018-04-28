package ru.isko.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Long id;

    @Column(name = "news_header")
    private String header;

    @Column(name = "news_content")
    private String content;

//    @Column(name = "news_image")
//    private String image;

    @Column(name = "news_date")
    private Date date;

    @Column(name = "news_type")
    private String type;

    @OneToMany(mappedBy = "news")
    private Set<Comment> commentSet;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_info.id")
    private FileInfo image;
}