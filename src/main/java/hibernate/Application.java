package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Map;


public class Application {

    public static void main(String[] args) {

        ApplicationDAO dao = new ApplicationDAO();


        Department department1 = new Department();
        department1.setIdDept(1);
        department1.setDeparmentName("IT-NEW");
        department1.setCostCentar("77889");
        /*--------Update---------
        dao.Update(department1);
        ----------END-------------*/

        Department department2 = new Department();
        department2.setIdDept(2);
        department2.setDeparmentName("SALES");
        department2.setCostCentar("4555");
        /*--------Update---------
        dao.Update(department);
         ----------END-------------*/

        Employer emp = new Employer();
        emp.setfName("Goran");
        emp.setlName("Cvetanoski-N");
        emp.setSallary(123654);
        emp.setIdEmploy(101);
        emp.setEmplDepartment(department1);
        /*--------Update---------
        dao.Update(emp);
        ----------END-------------*/


        /*System.out.println(dao.GetByID(101));

        System.out.println("---------------------------------------------------------");

        for (Employer employ: dao.GetAll()
             ) {
                System.out.println(employ);
        }

        List<Object[]> result = dao.GetEmployByDepartments(1);

        for (Object[] fEmp: result) {
            System.out.println(fEmp[0]+" : "+fEmp[1]+" : "+fEmp[2]);
        }*/

        System.out.println("-Goran Cvetanoski-");

       /* List<Map> lstMap = dao.NativeQuery1();

        for(Map map: lstMap)
        {
            System.out.println(map.get("0")+" : "+map.get("1"));
        }*/

    }
}
