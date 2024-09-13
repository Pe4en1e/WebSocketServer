package me.pe4en1e.websocketserver.repository;

import me.pe4en1e.websocketserver.entity.Username;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Username, Long> {

    List<Username> save(List<Username> users);

}
