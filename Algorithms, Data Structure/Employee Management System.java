import java.util.Scanner;
class Employee{
    int employeeId;
    String name;
    String position;
    double salary;
    
    public Employee(int employeeId,
    String name,
    String position,
    double salary){
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    public String toString(){
        return  "[ " + employeeId + " ] " + name + " - " + position + " - Rs." + salary;
    }
}
class EmployeeManagementSystem{
    private Employee[] employees;
    private int size;
    
    public EmployeeManagementSystem(int capacity){
        employees = new Employee[capacity];
        size = 0;
    }
    public void addEmployee(Employee emp){
        if(size < employees.length){
            employees[size++] = emp;
            System.out.println("Employee added!");
        }
        else{
            System.out.println("Array is full. Cannot add more employees");
        }
    }
    public void viewAll(){
        if(size==0){
            System.out.println("No employees found");
            return;
        }
        for(int i=0;i<size;i++){
            System.out.println(employees[i]);
        }
    }
    public Employee search(int empId){
        for(int j=0;j<size;j++){
            if(employees[j].employeeId == empId) return employees[j];
        }
        return null;
    }
    public boolean delete(int empId){
        for(int i=0;i<size;i++){
            if(employees[i].employeeId==empId){
                for(int j=i;j<size-1;j++){
                    employees[j] = employees[j+1];
                }
                employees[--size] = null;
                return true;
            }
        }
        return false;
    }
}
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        EmployeeManagementSystem ems=new EmployeeManagementSystem(100);
        while(true){
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = in.nextInt();
            
            switch(ch){
                case 1:
                    System.out.println("Enter ID: ");
                    int id = in.nextInt();
                    in.nextLine();
                    System.out.print("Enter Name: ");
                    String name = in.nextLine();
                    System.out.print("Enter position: ");
                    String position = in.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = in.nextDouble();
                    ems.addEmployee(new Employee(id, name, position, salary));
                    break;
                case 2:
                    ems.viewAll();
                    break;
                case 3:
                    System.out.print("Enter Employee ID to search: ");
                    Employee found = ems.search(in.nextInt());
                    System.out.println(found != null ? found : "Not found.");
                    break;
                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    System.out.println(ems.delete(in.nextInt()) ? "Deleted." : "Not found.");
                    break;
                case 5:
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}