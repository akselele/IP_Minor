package IP_Project_akselele.IP_Project_akselele.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class SubtaskDTO extends Task {

    @Id
    @GeneratedValue
    private long id;
    @NotNull(message = "Name of task or description cannot be empty")
    @NotEmpty(message = "Name of task cannot or description cannot be empty")
    private String taskName, taskDescription;

    public SubtaskDTO(Task task,String taskName, String taskDescription){
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
