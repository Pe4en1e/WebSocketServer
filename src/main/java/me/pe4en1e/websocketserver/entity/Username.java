package me.pe4en1e.websocketserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Username")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Username {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
}
