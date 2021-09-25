package api;
import model.EmployeeReq;
import model.EmployeeRes;
import model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;

@RestController
@RequestMapping("/training/backend/v1")
public class EmployeeController {
    private final EmployeeService service;
    @Autowired
    public EmployeeController(EmployeeService service){
        this.service = service;
    }
    @RequestMapping(value = "/employees",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Employees> getAllEmployees(){
            Employees response = service.getAllEmployees();
            return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/employees/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<EmployeeRes> getEmployeeById(@PathVariable("id") String id){
            EmployeeRes response = service.getEmployeeById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/employees",
            produces = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<EmployeeRes> addEmployee(@RequestBody EmployeeReq req){

        EmployeeRes response = service.addEmployee(req);

        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
    @RequestMapping(value = "/employees/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeRes> delEmployee(@PathVariable("id") String id){

        service.removeEmployee(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/employees/{id}",
            produces = {"application/json"},
            method = RequestMethod.PATCH)
    public ResponseEntity<EmployeeRes> patchEmployee(@PathVariable("id") String id,@RequestBody EmployeeReq req){

        service.updateEmployee(id, req);

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
