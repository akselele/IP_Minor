package IP_Project_akselele.IP_Project_akselele.repository;

import IP_Project_akselele.IP_Project_akselele.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
