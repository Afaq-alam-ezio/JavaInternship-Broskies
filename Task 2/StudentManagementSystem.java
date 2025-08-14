import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Student{

    private int id;
    private String name;
    private double grades;
    
    public Student(){


    }

    public Student(int id, String name, double grades){

        this.id = id;
        this.name = name;
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student [id = " + id + ", name = " + name + ", grades = " + grades + "]";
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrades() {
        return grades;
    }

    public void setGrades(double grades) {
        this.grades = grades;
    }

}



public class StudentManagementSystem{

    public static void main(String args[]){

        List<Student> student = new ArrayList<>(Arrays.asList(
                                    
                new Student(101, "Afaq alam", 100.00),
                new Student(102, "Suryadev pandey", 100.00),
                new Student(103, "Akshay Phadnis", 0.00)
                                        
                ));

        System.out.println("\n\tWelcome to Student Management System");
        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.print("\n\t\tBelow are options :\n\n1. Add new Student\t2. Remove a student\n3. Display students\t4. exit\n\nEnter option = ");
           
            int option = sc.nextInt();

            switch(option){

                case 1:

                    System.out.print("Enter id = ");
                        int newId = sc.nextInt();
                        sc.nextLine();

                    System.out.print("Enter name = ");
                        String newName = sc.nextLine();

                    System.out.print("Enter grades = ");
                        double newGrades = sc.nextDouble();

                    Student newStudent = new Student(newId, newName, newGrades);
                    student.add(newStudent);

                    break;

                case 2:

                    System.out.print("Enter id to remove = ");
                    int removalId = sc.nextInt();

                    // removing the object directly will also help in loosing the data for that object in class
                    student.removeIf(s -> s.getId() == removalId);

                    break;
                    
                case 3:

                    System.out.println("Below are the Student details : \n");
                    int i = 1;
                    for(Student s : student){

                        System.out.println("Student " + i + " details below :" + 

                            // "\nId = " + s.getId() +
                            // "\nName = " + s.getName() +
                            // "\nGrades = " + s.getGrades()

                            s.toString()
                            );

                        i++;
                    }

                    break;
                
                case 4:

                System.out.println("\n\tThanks for using.\n\tApplication closed!");
                    sc.close();
                    return;

                default : System.out.println("Invalid choice!");
            
            }
        }
    }
}