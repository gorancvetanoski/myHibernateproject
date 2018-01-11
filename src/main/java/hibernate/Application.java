package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public class Application {

    public static void main(String[] args) {

        Department department = new Department();
        department.setIdDept(1);
        department.setDeparmentName("IT");
        department.setCostCentar("77889");

        Employer emp = new Employer();
        emp.setfName("Goran");
        emp.setlName("Cvetanoski");
        emp.setSallary(123654);
        emp.setIdEmploy(101);
        emp.setEmplDepartment(department);

        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.configure().addAnnotatedClass(Employer.class).addAnnotatedClass(Department.class);

        StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());


        SessionFactory sf = configuration.buildSessionFactory(builder.build());

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(department);
        session.save(emp);

        tx.commit();

    }
}
