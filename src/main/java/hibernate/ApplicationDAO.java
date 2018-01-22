package hibernate;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        try {



            Query query = session.createQuery("from Employer where idEmploy= :idEmploy")
                    .setString("idEmploy", String.valueOf(idEmploy));

            return (Employer) query.uniqueResult();
        }
        finally {
            tx.commit();
        }

    }


    public List<Employer> GetAll()
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {

            Query query = session.createQuery("from Employer");
            tx.commit();
            return query.list();
        }
        finally {
            tx.commit();
        }
    }


    public List<Object []> GetEmployDepartments()
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
        Query query = session.createQuery("select e.fName,e.lName,d.DeparmentName from Employer e, Department d  where e.emplDepartment = d.idDept");
        return query.list();
        }
        finally {
            tx.commit();
        }
    }

    public List<Object []> GetEmployByDepartments(int idDepartment)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("select e.fName,e.lName,d.DeparmentName from Employer e, Department d  where e.emplDepartment = d.idDept and d.idDept=:department")
                    .setParameter("department",idDepartment);
            return query.list();
        }
        finally {
            tx.commit();
        }
    }

    public List<Map> NativeQuery ()
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("select fName,lName from Employer")
                    .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            List test =query.list();
            List<Map> lst = new ArrayList<>();
            for(Object obj: test)
            {
                Map m = (Map)obj;
                lst.add(m);
            }
            return lst;
        }
        finally {
            tx.commit();
        }
    }

}
