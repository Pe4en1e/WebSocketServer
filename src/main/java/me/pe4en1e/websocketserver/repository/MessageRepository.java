package me.pe4en1e.websocketserver.repository;

import me.pe4en1e.websocketserver.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> save(List<Message> messages);

}
