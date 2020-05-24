package IP_Project_akselele.IP_Project_akselele.rest.controller;

import IP_Project_akselele.IP_Project_akselele.domain.Task;
import IP_Project_akselele.IP_Project_akselele.dto.TaskDTO;
import IP_Project_akselele.IP_Project_akselele.service.TaskService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {
    private final TaskService taskService;

    public TaskRestController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    @ResponseBody
    public List<Task> getTasks()
    {
        return taskService.getTasks();
    }

    @PostMapping("/tasks/new")
    public TaskDTO newTask(@RequestBody @Valid TaskDTO taskDTO){
        return taskService.addTaskAPI(taskDTO);
    }

    @GetMapping("/tasks/{id}")
    @ResponseBody
    public Task getTask(@PathVariable("id") int id)
    {
        return taskService.getTask(id);
    }

}
