package org.example.springssr.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "app_user")
public class User {
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

    private String username;

    @OneToMany
    private List<Post> posts;
}
