package IP_Project_akselele.IP_Project_akselele.service;

import IP_Project_akselele.IP_Project_akselele.domain.Subtask;
import IP_Project_akselele.IP_Project_akselele.domain.SubtaskDTO;
import IP_Project_akselele.IP_Project_akselele.domain.Task;
import IP_Project_akselele.IP_Project_akselele.dto.TaskDTO;
import IP_Project_akselele.IP_Project_akselele.repository.TaskRepository;
import IP_Project_akselele.IP_Project_akselele.repository.TaskRepositoryMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository){
        this.repository = repository;
    }


    @Override
    public List<Task> getTasks() {
        return repository.findAll();
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTaskName(taskDTO.getTaskName());
        task.setTaskDescription(taskDTO.getTaskDescription());
        task.setTaskDue(taskDTO.getTaskDue());
        repository.save(task);
        repository.flush();
    }

    @Override
    public Task getTask(long id) {
        return repository.getOne(id);
    }

    @Override
    public void editTask(long id, TaskDTO taskDTO) {
        repository.getOne(id).setTaskDue(taskDTO.getTaskDue());
        repository.getOne(id).setTaskName(taskDTO.getTaskName());
        repository.getOne(id).setTaskDescription(taskDTO.getTaskDescription());
        repository.flush();
    }

    @Override
    public void addSubtask(Task task, SubtaskDTO subtaskDTO) {
        Subtask subtask = new Subtask();
        subtask.setTaskName(subtaskDTO.getTaskName());
        subtask.setTaskDescription(subtaskDTO.getTaskDescription());
        subtask.setTaskDue(subtaskDTO.getTaskDue());
        task.addSubTask(subtask);
        repository.save(task);
        repository.flush();
    }

    @Override
    public List<Subtask> getSubtasks(long id) {
        System.out.println(getTask(id).getSubtasks());
        return getTask(id).getSubtasks();
    }
}
