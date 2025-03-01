package Controller;

import java.lang.reflect.AnnotatedArrayType;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Model.Task;
import Service.TasksService;
import config.config;

@Controller
public class HomeController {
 
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String gettasks(Model model) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(config.class);
		TasksService  tasksService=ctx.getBean("tasksService",TasksService.class);
		List<Task> tasks=tasksService.gettasks();
		model.addAttribute("tasks",tasks);
		ctx.close();
		return "index";
	}
	
	
	@RequestMapping(value="/deletetask",method=RequestMethod.POST)
	public String deleteTask(@RequestParam ("taskId")int taskId) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(config.class);
		TasksService  tasksService=ctx.getBean("tasksService",TasksService.class);
		boolean deleted=tasksService.deleteTask(taskId);
		ctx.close();
		return "redirect:/";
	}
	
	@PostMapping(value="/completetask")
	public String completeTask(@RequestParam ("taskId")int taskId) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(config.class);
		TasksService  tasksService=ctx.getBean("tasksService",TasksService.class);
		tasksService.completeTask(taskId);
		ctx.close();
		return "redirect:/";
	}
	
	@RequestMapping(value="/completedTask",method=RequestMethod.GET)
	public String getcompletetasks(Model model) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(config.class);
		TasksService  tasksService=ctx.getBean("tasksService",TasksService.class);
		List<Task> tasks=tasksService.getCompletedTasks();
		model.addAttribute("tasks",tasks);
		ctx.close();
		return "completedTask";
	}
	
	@RequestMapping(value="/addTask",method=RequestMethod.POST)
	public String addTask(@ModelAttribute Task task) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(config.class);
		TasksService  tasksService=ctx.getBean("tasksService",TasksService.class);
		tasksService.addTask(task);
		ctx.close();
		return "redirect:/";
	}
	
	@RequestMapping(value="/updateTask",method=RequestMethod.POST)
	public String updateTask(@ModelAttribute Task task) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(config.class);
		TasksService  tasksService=ctx.getBean("tasksService",TasksService.class);
		tasksService.updateTask(task);
		ctx.close();
		return "redirect:/";
	}
}
