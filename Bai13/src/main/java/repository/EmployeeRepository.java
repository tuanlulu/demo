package repository;
import entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<EmployeeEntity,String> {
    @Override
    List<EmployeeEntity> findAll();
}
