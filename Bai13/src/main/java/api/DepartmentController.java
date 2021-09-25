package api;

import model.DepartmentReq;
import model.DepartmentRes;
import model.Departments;
import model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.DepartmentService;
import service.EmployeeService;

@RestController
@RequestMapping("/training/backend/v1")
public class DepartmentController {
    private final DepartmentService service;
    private final EmployeeService empService;

    @Autowired
    public DepartmentController(DepartmentService service, EmployeeService empService){
        this.service = service;
        this.empService = empService;
    }
    @RequestMapping(value = "/departments",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Departments> getAllDepartment(){
        Departments res = service.getAllDepartments();
        return new ResponseEntity<>(res, HttpStatus.OK);

    }
    @RequestMapping(value = "/departments/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<DepartmentRes> getDepartmentById(@PathVariable("id") String id){
        DepartmentRes respose = service.getDepartment(id);
        return new ResponseEntity<>(respose, HttpStatus.OK);
    }
    @RequestMapping(value = "/departments",
            produces = {"application/json"},
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<DepartmentRes> addDepartment (@RequestBody DepartmentReq req){
            DepartmentRes response = service.addDepartment(req);
            return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/departments/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    public ResponseEntity<DepartmentRes> delDepartment(@PathVariable("id") String id){

        service.removeDepartment(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/departments/{id}",
            produces = {"application/json"},
            method = RequestMethod.PATCH)
    public ResponseEntity<DepartmentRes> updateDepartment(@PathVariable("id") String id,@RequestBody DepartmentReq req){

        DepartmentRes response = service.updateDepartment(id, req);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/departments/{departmentId}/employees",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Employees> getEmployeesFromDepartment(@PathVariable("departmentId") String deptId){

        Employees response = service.getEmployeesFromDepartment(deptId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
