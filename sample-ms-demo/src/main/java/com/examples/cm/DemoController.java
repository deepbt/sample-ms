package com.examples.cm;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private MessageProps properties;
    
	@Value("${demo.message}")
	private String demoMessage;

	
	@Value("${demo.key}")
	private String demoKey;
	
    @Autowired
    public DemoController(MessageProps properties) {
        this.properties = properties;
    }
    @RequestMapping("/demo/{name}")
    public Message greeting(@PathVariable("name") String name) {
        Objects.requireNonNull(properties.getMessage(), "Message was not set in the properties");
        String message = String.format(properties.getMessage(), name);
        return new Message("DemoController: "+ message);
    }
    
    @RequestMapping("/demo")
    public Message demo() {
        Objects.requireNonNull(properties.getMessage(), "Message was not set in the properties");
        String message = "demoKey = "+demoKey+" and demoMessage = "+demoMessage;
        return new Message("DemoController" + message);
    }
   
}
