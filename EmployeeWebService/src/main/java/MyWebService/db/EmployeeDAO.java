package MyWebService.db;

import MyWebService.core.Employee;
import io.dropwizard.hibernate.AbstractDAO;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAO extends AbstractDAO<Employee> {
    public EmployeeDAO(SessionFactory factory) {
        super(factory);
    }

    public Employee create(Employee employee) {
        return persist(employee);
    }

    public List<Employee> findByDepartment(String department) {
        Query query = namedTypedQuery("core.Employee.findByDepartment");
        query.setParameter("dep", department);
        return list(query);
    }
}
