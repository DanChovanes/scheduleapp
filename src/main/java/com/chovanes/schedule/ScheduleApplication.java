package com.chovanes.schedule;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;


// these @ symbols are Annotations, and they basically help Spring configure your application.
// in this case, there's background magic that happens due to it being a Spring Boot application and Controller
@SpringBootApplication
@Controller
public class ScheduleApplication {

	//default Spring Boot main method
	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);

	}

	//this guy responds to HTTP requests on your Tomcat server
	//when someone comes to the server at the specified endpoint, I.E. "http://localhost:8080/", it returns the
	//	welcome.html file.
	@GetMapping("/")
	public String schedule() {
		return "welcome";
	}

	@GetMapping("/day")
	public String scheduleDay(Model model) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(new File("src/main/resources/static/schedule.json"), Map.class);
		model.addAttribute("localDateTime", LocalDateTime.now());
		model.addAttribute("schedule", map);
		return "day";
	}
}