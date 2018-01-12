package hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ApplicationDAO {

    private org.hibernate.cfg.Configuration configuration;
    private StandardServiceRegistryBuilder builder;
    private SessionFactory sessionFactory;

    public ApplicationDAO() {
        configuration = new org.hibernate.cfg.Configuration();
        configuration.configure().addAnnotatedClass(Employer.class).addAnnotatedClass(Department.class);
        builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    public void Insert(Department department, Employer employer)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(department);
            session.save(employer);
            tx.commit();
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
    }

    public void Update(Department department)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            String hqlUpdate = "update Department c set c.CostCentar = :CostCentar, DeparmentName=:DeparmentName where c.idDept = :idDept";
            int updatedEntities = session.createQuery( hqlUpdate )
                    .setString( "CostCentar", department.getCostCentar() )
                    .setString( "DeparmentName", department.getDeparmentName() )
                    .setString("idDept",String.valueOf(department.getIdDept()))
                    .executeUpdate();
            tx.commit();
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
    }

    public void Update(Employer employer)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            String hqlUpdate = "update Employer c set c.fName = :fName, lName=:lName, sallary=:sallary, emp_dep_id=:emp_dep_id where c.idEmploy = :idEmploy";
            int updatedEntities = session.createQuery( hqlUpdate )
                    .setString( "fName", employer.getfName() )
                    .setString( "lName", employer.getlName() )
                    .setString( "sallary", String.valueOf(employer.getSallary()))
                    .setString( "emp_dep_id", String.valueOf(employer.getEmplDepartment().getIdDept()))
                    .setString("idEmploy",String.valueOf(employer.getIdEmploy()))
                    .executeUpdate();
            tx.commit();
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
    }

    public Employer GetByID(Integer idEmploy)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Employer where idEmploy= :idEmploy")
                .setString("idEmploy",String.valueOf(idEmploy));

        return (Employer)query.uniqueResult();
    }
}
