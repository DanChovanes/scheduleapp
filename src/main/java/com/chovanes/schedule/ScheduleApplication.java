package com.chovanes.schedule;

import com.chovanes.schedule.dto.Schedule;
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
import java.util.Arrays;
import java.util.Map;

@SpringBootApplication
@Controller
public class ScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);

	}

	@GetMapping("/")
	public String schedule(Model model) {
		model.addAttribute("schedule", new Schedule().getSch());
		return "welcome";
	}

	@GetMapping("/day")
	public String scheduleDay(Model model) throws IOException {
		model.addAttribute("localDateTime", LocalDateTime.now());
		model.addAttribute("schedule", new Schedule());
		Schedule schedule = new Schedule();
		return "day";
	}
}