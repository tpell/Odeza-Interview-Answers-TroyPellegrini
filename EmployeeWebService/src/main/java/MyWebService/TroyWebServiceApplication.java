package MyWebService;

import MyWebService.core.Employee;
import MyWebService.db.EmployeeDAO;
import MyWebService.resources.EmployeeResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TroyWebServiceApplication extends Application<TroyWebServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TroyWebServiceApplication().run(args);
    }

    private final HibernateBundle<TroyWebServiceConfiguration> hibernateBundle =
            new HibernateBundle<TroyWebServiceConfiguration>(Employee.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(TroyWebServiceConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public String getName() {
        return "TroyWebService";
    }

    @Override
    public void initialize(final Bootstrap<TroyWebServiceConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final TroyWebServiceConfiguration configuration,
                    final Environment environment) {

        final EmployeeDAO dao = new EmployeeDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new EmployeeResource(dao));
        environment.jersey().register(new JsonProcessingExceptionMapper(true));
    }
}
