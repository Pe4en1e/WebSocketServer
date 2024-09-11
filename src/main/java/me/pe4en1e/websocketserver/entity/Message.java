package me.pe4en1e.websocketserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Message")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;

}
