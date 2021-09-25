package mapper;


import entity.EmployeeEntity;
import model.EmployeeReq;
import model.EmployeeRes;
import model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import repository.EmployeeRepository;

import java.util.List;
import java.util.UUID;

public class EmployeeMapper {
    private  final EmployeeRepository repo;

    @Autowired
    public EmployeeMapper(EmployeeRepository repo){
        this.repo = repo;
    }

    public EmployeeRes mapEmployeeResFromEmployeeEntity(EmployeeEntity from){
        EmployeeRes to = new EmployeeRes();
        to.setId(from.getId());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setEmail(from.getEmail());

        return  to;
    }

    public Employees mapEmployeesFromEmployeeEntities(List<EmployeeEntity> from){
        Employees to = new Employees();

        from.stream().forEach((employee) -> {
            to.add(mapEmployeeResFromEmployeeEntity(employee));
        });
        return to;
    }

    public EmployeeEntity mapEmployeeEntityFromEmployeeReq(EmployeeReq from){
        EmployeeEntity to =new EmployeeEntity();

        to.setId(UUID.randomUUID().toString());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setEmail(from.getEmail());
        to.setDepartmentId(from.getDepartmentId());
        to.setPhone(from.getPhone());
        return to;
    }

    public EmployeeEntity mapEmployeeEntityFromEmployeeReq(String id,EmployeeReq from){
        EmployeeEntity to = repo.getOne(id);

        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setEmail(from.getEmail());
        to.setDepartmentId(from.getDepartmentId());
        to.setPhone(from.getPhone());
        return to;
    }

}
