package entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class DepartmentEntity {
    @Id
    @Column(name = "DEPARTMENT_ID", nullable = false)
    private String id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "ADDRESS",nullable = false)
    private String address;
    @Column(name = "PHONE",nullable = false)
    private int phone;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
