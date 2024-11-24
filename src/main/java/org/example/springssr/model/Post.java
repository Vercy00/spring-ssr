package org.example.springssr.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Post implements Serializable {
    @Id
    @SequenceGenerator(
            name = "user_id_seq",
            sequenceName = "user_id_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_seq"
    )
    private Integer id;

    private String title;

    @Column(length = 102400)
    private String content;

    private String imageUrl;

    @ManyToOne
    private User user;
}
