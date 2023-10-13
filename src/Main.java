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


class fulltimeEmployee extends Employee{
    
    private double monthlySalary;

    public fulltimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class partTimeEmployee extends Employee{
    
    private double hourlyRate;
    private int hoursWorked;


    public partTimeEmployee(String name, int id, double hourlyRate, int hoursWorked){
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary(){
        return hourlyRate * hoursWorked;
    }
}


public class Main{
    public static void main(String [] args){
        System.out.println("This the Employee Payroll System");
    }
}