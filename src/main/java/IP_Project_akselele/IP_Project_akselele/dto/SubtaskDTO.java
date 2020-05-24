package IP_Project_akselele.IP_Project_akselele.dto;

import IP_Project_akselele.IP_Project_akselele.domain.Task;
import javax.validation.constraints.NotEmpty;

public class SubtaskDTO{

    @NotEmpty(message = "Name of task cannot be empty")
    private String taskName;
    @NotEmpty(message = "Description of task cannot be empty")
    private String taskDescription;


    public SubtaskDTO(Task task, String taskName, String taskDescription){
        setTaskName(taskName);
        setTaskDescription(taskDescription);
    }

    public SubtaskDTO(){

    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {

        this.taskDescription = taskDescription;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskName() {
        return taskName;
    }

    public String toString(){
        return taskName + " - " + taskDescription;
    }

}
