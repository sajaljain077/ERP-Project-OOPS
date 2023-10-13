import java.util.ArrayList;

abstract class Employee{

    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
    return name;
    }

    public int getId(){
    return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name=" + name + ", id=" +id+", salary=" +calculateSalary()+"]";
    }
}


class FulltimeEmployee extends Employee{
    
    private double monthlySalary;

    public FulltimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    
    private double hourlyRate;
    private int hoursWorked;


    public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked){
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary(){
        return hourlyRate * hoursWorked;
    }
}



class PayrollSystem{

    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee emp : employeeList){
            if(emp.getId() == id){
                employeeToRemove = emp;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for(Employee emp: employeeList){
            System.out.println(emp);
        }
    }

}

public class Main{
    public static void main(String [] args){
        PayrollSystem payrollSystemObj = new PayrollSystem();
        FulltimeEmployee emp1 = new FulltimeEmployee("Sajal", 1, 931111.00);
        PartTimeEmployee emp2 = new PartTimeEmployee("Ahmad", 2, 250.0, 8);
        payrollSystemObj.addEmployee(emp1);
        payrollSystemObj.addEmployee(emp2);
        System.out.println("Intial employee details:- ");
        payrollSystemObj.displayEmployee();
        System.out.println("Removing employee:- ");
        payrollSystemObj.removeEmployee(1);
        System.out.println("Remaining employee details");
        payrollSystemObj.displayEmployee();
    }
}