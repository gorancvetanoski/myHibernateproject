package lambda;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        Repository repo = new Repository();

        System.out.println("----------TUKA------------");

       /* for (Student s:repo.StudentRepository()
             ) {
            System.out.println(s);
        }*/


       // repo.StudentRepository().forEach(n -> System.out.println(n));

        repo.GetStudentsBySex("male").forEach(n -> System.out.println(n));



        Runnable r2 = ()->System.out.println("Hello RUN 2");


        r2.run();

    }




}
