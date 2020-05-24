package IP_Project_akselele.IP_Project_akselele.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Subtask {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Id
    private String id;
    @NotEmpty(message = "Name of task cannot or description cannot be empty")
    private String taskName;
    @NotEmpty(message = "Description of task cannot be empty")
    private String taskDescription;

    public Subtask(Task task,String taskName, String taskDescription){
        setTaskName(taskName);
        setTaskDescription(taskDescription);
    }

    public Subtask(){

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
