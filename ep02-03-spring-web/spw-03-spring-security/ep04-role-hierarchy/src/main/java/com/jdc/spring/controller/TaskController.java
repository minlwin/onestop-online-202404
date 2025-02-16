package com.jdc.spring.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.spring.controller.model.TaskDto;
import com.jdc.spring.controller.model.TaskRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping({
	"staff/tasks"
})
@RequiredArgsConstructor
public class TaskController {
	
	private final TaskRepository taskRepository;

	@GetMapping
	String search(ModelMap model) {
		model.put("tasks", taskRepository.getAll());
		return "staff";
	}
	
	@PostMapping
	String upload(@RequestParam MultipartFile file) {
		
		try(var reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			
			String line = null;
			var tasks = new ArrayList<TaskDto>();
			while(null != (line = reader.readLine())) {
				var array = line.split("\t");
				tasks.add(new TaskDto(array[0], array[1]));
			}
			
			taskRepository.add(tasks);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/staff/tasks";
	}
}
