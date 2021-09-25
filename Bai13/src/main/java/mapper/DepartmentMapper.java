package mapper;

import entity.DepartmentEntity;
import model.DepartmentReq;
import model.DepartmentRes;
import model.Departments;
import model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DepartmentRepository;
import repository.EmployeeRepository;
import java.util.List;
import java.util.UUID;

@Service
public class DepartmentMapper {
    private DepartmentRepository deRepo;
    private EmployeeRepository emRepo;

    @Autowired
    public DepartmentMapper(DepartmentRepository deRepo, EmployeeRepository emRepo){
        this.deRepo = deRepo;
        this.emRepo = emRepo;
    }
    public DepartmentRes mapDepartmentResFromDepartmentEntity(DepartmentEntity from){
        DepartmentRes to = new DepartmentRes();
        to.setId(from.getId());
        to.setAddress(from.getAddress());
        to.setName(from.getName());
        to.setPhone(from.getPhone());

        return to;
    }
    public Departments mapDepartmentsFromDepartmentEntities(List<DepartmentEntity> from){
        Departments to =new Departments();
        from.stream().forEach(departmentEntity -> {
            to.add(mapDepartmentResFromDepartmentEntity(departmentEntity));
        });
        return to;
    }
    public DepartmentEntity mapDepartmentEntityFromDepartmentReq(DepartmentReq from){
        DepartmentEntity to = new DepartmentEntity();
        to.setId(UUID.randomUUID().toString());
        to.setAddress(from.getAddress());
        to.setName(from.getName());
        to.setPhone(from.getPhone());

        return to;
    }
    public DepartmentEntity mapDepartmentEntityFromDepartmentReq(String id,DepartmentReq from){
        DepartmentEntity to = deRepo.getOne(id);

        to.setAddress(from.getAddress());
        to.setName(from.getName());
        to.setPhone(from.getPhone());

        return to;
    }



}
