package MyWebService.resources;

import MyWebService.core.Employee;
import MyWebService.db.EmployeeDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("")
public class EmployeeResource {

    public final EmployeeDAO employeeDAO;

    public EmployeeResource(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @POST
    @Path("/addEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Employee createEmployee(@Valid Employee employee) {
        return employeeDAO.create(employee);
    }

    @GET
    @Path("/getEmployeesInDepartment")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<Employee> getEmployeesInDepartment(@QueryParam("department") String department) {
        return employeeDAO.findByDepartment(department);
    }
}
