import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Employee{

    private String name;
    private int age;
    private int salary;

    public Employee(){   
    }

    public Employee(String name, int age, int salary){

        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    public String toString(){

        return "Name = " + this.name + " Age = " + this.age + " Salary = " + this.salary + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static void display(ArrayList<Employee> emp){

        for(Employee e : emp){

            System.out.print(e.toString());
        }
    }    
}


public class CollectionsAndSorting{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        ArrayList<Employee> emp = new ArrayList<>(Arrays.asList(

            new Employee("Afaq", 22, 100000),
            new Employee("Suryadev", 21, 90000),
            new Employee("Chottee", 22, 0),
            new Employee("Mahindre", 26, 15)

        ));

        
        Comparator<Employee> comDescendingBySalary = new Comparator<Employee>() {
            
            public int compare(Employee i, Employee j){

                // return i.getSalary() > j.getSalary() ? 1 : -1;
                return (j.getSalary() - i.getSalary());
            }
        };


        Comparator<Employee> comAscendingByName = new Comparator<Employee>() {
            
            public int compare(Employee i, Employee j){

                return i.getName().compareTo(j.getName());
            }
        };


        while(true){

            System.out.println(

                "\n1. Enter 1 for printing List sorted by Salary in Descending Order." +
                "\n2. Enter 2 for printing List sorted by Name in Ascending Order." +
                "\n3. Enter 3 for printing current List." +
                "\n4. Exit."
                
                );
            
            System.out.print("Option = ");

            int option = sc.nextInt();

            if(option == 1){

                Collections.sort(emp, comDescendingBySalary);
                Employee.display(emp);
            }
            else if(option == 2){

                Collections.sort(emp, comAscendingByName);
                Employee.display(emp);
            }
            else if(option == 3){

                Employee.display(emp);
            }
            else if(option == 4){

                sc.close();
                break;
            }
            else{

                System.out.println("Invalid User Input.");
            }
        }
    }
}