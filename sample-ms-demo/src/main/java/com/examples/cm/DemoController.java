package com.examples.cm;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {
    private MessageProps properties;
    
	@Value("${demo.message}")
	private String demoMessage;

	
	@Value("${demo.key}")
	private String demoKey;
	
	@Value("${address}")
	private String address;
	
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
    
    @RequestMapping("/testlocal")
    public String testlocal() {
    	 RestTemplate restTemplate = new RestTemplate();
         
         String consumeJSONString = restTemplate.getForObject(address, String.class);
         System.out.println("JSON String: "+consumeJSONString);
         return consumeJSONString;
    }
   
}
