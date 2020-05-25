package IP_Project_akselele.IP_Project_akselele;

import IP_Project_akselele.IP_Project_akselele.domain.Subtask;
import IP_Project_akselele.IP_Project_akselele.dto.SubtaskDTO;
import IP_Project_akselele.IP_Project_akselele.domain.Task;
import IP_Project_akselele.IP_Project_akselele.dto.TaskDTO;
import IP_Project_akselele.IP_Project_akselele.service.TaskService;
import IP_Project_akselele.IP_Project_akselele.service.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class testTaskService {
    @Autowired
    private TaskService taskService;

    @Test
    public void testAddAndGetTasks(){
        //setup
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskName("Task1");
        taskDTO.setTaskDescription("Testing this task");
        taskDTO.setTaskDue(LocalDateTime.now().plusWeeks(2));
        taskService.addTask(taskDTO);

        //method to be tested
        List<Task> tasks = taskService.getTasks();

        //tests
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(1,tasks.size());
        Task task = tasks.get(0);
        assertNotNull(task);
    }

    @Test
    public void testAddAndGetSubtaks(){
        //setup
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskName("Task1");
        taskDTO.setTaskDescription("Testing this task");
        taskDTO.setTaskDue(LocalDateTime.now().plusWeeks(2));
        taskService.addTask(taskDTO);
        SubtaskDTO subtaskDTO = new SubtaskDTO();
        subtaskDTO.setTaskName("Subtask1 test");
        subtaskDTO.setTaskDescription("Testing this subtask");
        taskService.addSubtask(taskService.getTask(1),subtaskDTO);

        //method to be tested
        List<Subtask> subtasks = taskService.getSubtasks(1);

        //tests
        assertNotNull(subtasks);
        assertFalse(subtasks.isEmpty());
        assertEquals(1,subtasks.size());
        Subtask subtask = subtasks.get(0);
        assertNotNull(subtask);
    }


}
