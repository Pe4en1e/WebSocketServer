package me.pe4en1e.websocketserver;

import me.pe4en1e.websocketserver.entity.Message;
import me.pe4en1e.websocketserver.entity.Username;
import me.pe4en1e.websocketserver.repository.MessageRepository;
import me.pe4en1e.websocketserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageController implements WebSocketHandler {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    List<WebSocketSession> activeSessions = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        activeSessions.add(session);

        Username username = Username.builder()
                        .username(session.getLocalAddress().toString())
                        .build();

        userRepository.save(username);

        for (WebSocketSession user : activeSessions) {
            user.sendMessage(new TextMessage(user.getRemoteAddress().toString() + " connected"));
        }

    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> msg) throws Exception {
        for (WebSocketSession user : activeSessions) {
            if (!user.equals(session)) {
                user.sendMessage(new TextMessage(user.getRemoteAddress().toString() + ": " + msg.getPayload()));
            }
        }

        Message message = Message.builder()
                .message(msg.getPayload().toString()).build();

        messageRepository.save(message);

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println(exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        activeSessions.remove(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
