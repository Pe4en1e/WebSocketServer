package me.pe4en1e.websocketserver;

import me.pe4en1e.websocketserver.representation.Greeting;
import me.pe4en1e.websocketserver.representation.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {

    @MessageMapping("/hello")
    public Greeting greeting(HelloMessage helloMessage) throws Exception {
        Thread.sleep(1000);
        return new Greeting("Hello" + HtmlUtils.htmlEscape(helloMessage.getName()));
    }

}
