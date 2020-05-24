package IP_Project_akselele.IP_Project_akselele.dto;

import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskDTO {
    private long id;


    @NotEmpty(message = "Name of Task cannot be empty")
    private String taskName;

    @NotEmpty(message = "Description of Task cannot be empty")
    private String taskDescription;


    @NotNull(message = "Due date of Task cannot be empty")
    @Future(message = "Description must be in the future")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime taskDue;
    private static final String DATE_FORMATTER = "dd-MM-yyyy HH:mm";


    public LocalDateTime getTaskDue() {
        return taskDue;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskDue(LocalDateTime taskDue) {
        this.taskDue = taskDue;
    }

    public void setTaskDue(String taskDue){
        this.taskDue = LocalDateTime.parse(taskDue);
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }


}
