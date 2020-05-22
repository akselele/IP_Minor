package IP_Project_akselele.IP_Project_akselele.controller;

import IP_Project_akselele.IP_Project_akselele.domain.SubtaskDTO;
import IP_Project_akselele.IP_Project_akselele.dto.TaskDTO;
import IP_Project_akselele.IP_Project_akselele.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService= taskService;
    }

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String getTask(Model model, @PathVariable("id") int id) {
        model.addAttribute("taskId", id);
        model.addAttribute("task", taskService.getTask(id));
        model.addAttribute("tasks", taskService.getSubtasks(id));
        return "task";
    }

    @GetMapping("/tasks/new")
    public String getAddTask(Model model) {
        model.addAttribute("task", new TaskDTO());
        return "newtask";
    }

    @PostMapping("/tasks/new")
    public String addTask(@ModelAttribute("task") @Valid TaskDTO task, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "newtask";
        }
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("tasks/edit/{id:\\d}")
    public String editTaskPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("taskId", id);
        model.addAttribute("task", taskService.getTask(id));
        model.addAttribute("id", id);
        return "edittask";
    }

    @PostMapping("/tasks/edit/{id:\\d}")
    public String editTask(@ModelAttribute TaskDTO task, @PathVariable("id") int id) {

        taskService.editTask(id, task);

        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id:\\d}/sub/create")
    public String showSubtask(Model model, @PathVariable("id") int id){
        model.addAttribute("task",taskService.getTask(id));
        model.addAttribute("subtask", new SubtaskDTO());
        return "subtask";
    }

    @PostMapping("/tasks/{id:\\d}/sub/create")
    public String addSubtask(@ModelAttribute SubtaskDTO subTask, @PathVariable("id") int id, BindingResult br){
        if(br.hasErrors()){
            return "subtask";
        }
        taskService.addSubtask(taskService.getTask(id),subTask);
        return "redirect:/tasks/"+ id;
    }
}
