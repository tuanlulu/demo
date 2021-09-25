package service;

import entity.EmployeeEntity;
import mapper.EmployeeMapper;
import model.EmployeeReq;
import model.EmployeeRes;
import model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;


@Service
public class EmployeeService {
    private final EmployeeMapper mapper;
    private  final EmployeeRepository repo;

    @Autowired
    public EmployeeService(EmployeeMapper mapper, EmployeeRepository repo){
        this.mapper = mapper;
        this.repo =repo;
    }

    public EmployeeRes addEmployee(EmployeeReq req){
        EmployeeEntity entity = mapper.mapEmployeeEntityFromEmployeeReq(req);

        EmployeeEntity saved = repo.save(entity);

        return mapper.mapEmployeeResFromEmployeeEntity(saved);
    }

    public EmployeeRes updateEmployee(String id, EmployeeReq req){
        EmployeeEntity entity = mapper.mapEmployeeEntityFromEmployeeReq(id, req);

        EmployeeEntity saved = repo.save(entity);

        return mapper.mapEmployeeResFromEmployeeEntity(saved);
    }

    public Employees getAllEmployees(){
        Employees ls = mapper.mapEmployeesFromEmployeeEntities(repo.findAll());

        return ls;
    }

    public EmployeeRes getEmployeeById(String id){
        EmployeeEntity entity = repo.getOne(id);

        return mapper.mapEmployeeResFromEmployeeEntity(entity);
    }
    public void removeEmployee(String EmployeeId){
        EmployeeEntity entity = repo.getOne((EmployeeId));

        repo.delete(entity);
    }

    public EmployeeRes getEmployeeFromDepartment(String deptId,String empId){
        EmployeeEntity empEntity = repo.getOne(empId);
        if(empEntity.getDepartmentId().equals(deptId)){
            return mapper.mapEmployeeResFromEmployeeEntity(empEntity);
        }
        return null;
    }
}

