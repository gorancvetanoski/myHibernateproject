package hibernate;

import javax.persistence.*;

@Entity
@Table(name = "hb_employer")
public class Employer {

    @Id
    private int idEmploy;
    private String fName;
    private String lName;
    private long sallary;

    @OneToOne
    @JoinColumn(name="emp_dep_id")
    private Department emplDepartment;

    public Department getEmplDepartment() {
        return emplDepartment;
    }

    public void setEmplDepartment(Department emplDepartment) {
        this.emplDepartment = emplDepartment;
    }


    public int getIdEmploy() {
        return idEmploy;
    }

    public void setIdEmploy(int idEmploy) {
        this.idEmploy = idEmploy;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public long getSallary() {
        return sallary;
    }

    public void setSallary(long sallary) {
        this.sallary = sallary;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "idEmploy=" + idEmploy +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", sallary=" + sallary +
                '}';
    }
}
