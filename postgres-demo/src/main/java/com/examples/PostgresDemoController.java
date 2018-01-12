package com.examples;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostgresDemoController {
    private MessageProps properties;
    
	@Value("${demo.message}")
	private String demoMessage;

	
	@Value("${demo.key}")
	private String demoKey;
	
	@Autowired
	private SampleRepository  repository;
	
    @Autowired
    public PostgresDemoController(MessageProps properties) {
        this.properties = properties;
    }
    @RequestMapping("/getemployeecount")
    public Message greeting() {
        String message = String.format(properties.getMessage(), String.valueOf(repository.count()));
        return new Message(message);
    }
}
