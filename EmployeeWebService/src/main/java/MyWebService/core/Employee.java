package MyWebService.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
@NamedQueries({
        @NamedQuery(
                name = "core.Employee.findByDepartment",
                query = "SELECT e FROM Employee e WHERE e.department = :dep"
        )
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeID;

    @Column(name = "FirstName", nullable = true)
    private String firstName;

    @Column(name = "LastName", nullable = true)
    private String lastName;

    @Column(name = "Title", nullable = true)
    private String title;

    @Column(name = "StartDate", nullable = true)
    private String startDate;

    @Column(name = "Department", nullable = true)
    private String department;

    public Employee() {}

    public Employee(String firstName, String lastName, String title, String startDate, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.startDate = startDate;
        this.department = department;
    }

    @JsonProperty
    public long getEmployeeID() {
        return employeeID;
    }

    @JsonProperty
    public void setEmployeeID(long id) {
        this.employeeID = id;
    }

    @JsonProperty
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty
    public void setFirstName(String name) {
        this.firstName = name;
    }

    @JsonProperty
    public String getLastName() {
        return lastName;
    }

    @JsonProperty
    public void setLastName(String name) {
        this.lastName = name;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty
    public void setStartDate(String date) {
        this.startDate = date;
    }

    @JsonProperty
    public String getDepartment() {
        return department;
    }

    @JsonProperty
    public void setDepartment(String department) {
        this.department = department;
    }
}
