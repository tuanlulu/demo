package service;

import entity.DepartmentEntity;
import mapper.DepartmentMapper;
import model.DepartmentReq;
import model.DepartmentRes;
import model.Departments;
import model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DepartmentRepository;

@Service
public class DepartmentService {
    private DepartmentMapper mapper;
    private DepartmentRepository repo;
    @Autowired
    public DepartmentService(DepartmentMapper mapper,DepartmentRepository repo){
        this.mapper = mapper;
        this.repo = repo;

    }

    public DepartmentRes addDepartment(DepartmentReq req){
        DepartmentEntity entity = mapper.mapDepartmentEntityFromDepartmentReq(req);
        DepartmentEntity saved = repo.save(entity);

        return mapper.mapDepartmentResFromDepartmentEntity(saved);
    }

    public DepartmentRes updateDepartment(String id, DepartmentReq req){
        DepartmentEntity entity = mapper.mapDepartmentEntityFromDepartmentReq(id,req);
        DepartmentEntity saved = repo.save(entity);

        return mapper.mapDepartmentResFromDepartmentEntity(saved);
    }

    public Departments getAllDepartments(){
        Departments ls = mapper.mapDepartmentsFromDepartmentEntities(repo.findAll());

        return ls;
    }


    public DepartmentRes getDepartment(String id){
        DepartmentEntity entity = repo.getOne(id);

        return mapper.mapDepartmentResFromDepartmentEntity(entity);
    }



    public void removeDepartment(String id){
        DepartmentEntity entity = repo.getOne(id);

        repo.delete(entity);
    }

    public Employees getEmployeesFromDepartment(String id){
        DepartmentEntity entity = repo.getOne(id);
        DepartmentRes deptRes = mapper.mapDepartmentResFromDepartmentEntity(entity);

        return deptRes.getEmployees();
    }

}