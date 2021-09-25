package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {
    @Id
    @Column(name = "EMPLOYEE_ID",nullable = false)
    private String id;
    @Column (name = "FIRST_NAME",nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME",nullable = false)
    private String lastName;
    @Column(name = "EMAIL",nullable = false)
    private String email;
    @Column(name = "PHONE",nullable = false)
    private int phone;
    @Column(name = "DEPARTMENT_ID",nullable = false)
    private String departmentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }



}
