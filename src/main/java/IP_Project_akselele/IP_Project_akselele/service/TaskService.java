package IP_Project_akselele.IP_Project_akselele.service;

import IP_Project_akselele.IP_Project_akselele.domain.Subtask;
import IP_Project_akselele.IP_Project_akselele.domain.SubtaskDTO;
import IP_Project_akselele.IP_Project_akselele.domain.Task;
import IP_Project_akselele.IP_Project_akselele.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    List<Task> getTasks();
    void addTask(TaskDTO taskDTO);
    Task getTask(long id);
    void editTask(long id, TaskDTO taskDTO);
    public List<Subtask> getSubtasks(long id);
    void addSubtask(Task task, SubtaskDTO subtaskDTO);

}
