package hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hb_departnment")
public class Department {

    @Id
    private int idDept;

    private String DeparmentName;

    private String CostCentar;

    public int getIdDept() {
        return idDept;
    }

    public void setIdDept(int idDept) {
        this.idDept = idDept;
    }

    public String getDeparmentName() {
        return DeparmentName;
    }

    public void setDeparmentName(String deparmentName) {
        DeparmentName = deparmentName;
    }

    public String getCostCentar() {
        return CostCentar;
    }

    public void setCostCentar(String costCentar) {
        CostCentar = costCentar;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDept=" + idDept +
                ", DeparmentName='" + DeparmentName + '\'' +
                ", CostCentar='" + CostCentar + '\'' +
                '}';
    }

}
