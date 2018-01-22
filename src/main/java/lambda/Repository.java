package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Repository {

    public  List<Student> listStudent=new ArrayList<Student>();

    public List<Student> StudentRepository() {
        listStudent.add(new Student(java.util.UUID.randomUUID(), "Goran", "Cvatenanoski", "prva godina", "1511 24 2-9", "male"));
        listStudent.add(new Student(java.util.UUID.randomUUID(), "Gordana", "Cvatenanoski", "prva godina", "1511 24 2-9", "female"));
        listStudent.add(new Student(java.util.UUID.randomUUID(), "Dimo", "Cvatenanoski", "prva godina", "1511 24 2-9", "male"));
        listStudent.add(new Student(java.util.UUID.randomUUID(), "Stojanka", "Cvatenanoski", "prva godina", "1511 24 2-9", "female"));
        return listStudent;
    }

    public List<Student> GetStudentsBySex(String sex)
    {
        return StudentRepository().stream().filter(x -> x.getSex() == sex).collect(Collectors.toList());
    }

    public List<Student> GetStudentsByGrade(String grade)
    {
        return StudentRepository().stream().filter(x -> x.getSex() == grade).collect(Collectors.toList());
    }

}
