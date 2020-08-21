package vixorg.playground.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import vixorg.playground.websocket.view.Greeting;
import vixorg.playground.websocket.view.HelloMessage;

@Controller
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws InterruptedException {
		Thread.sleep(1000); // simulated delay
		return Greeting.builder().content("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!").build();
	}
}
