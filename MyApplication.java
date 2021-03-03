import controllers.EmployeeController;
import entities.BackendDeveloper;
import entities.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final EmployeeController controller;
    private final Scanner scanner;

    public MyApplication(EmployeeController controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }
    public void start(){
        while(!false){
            System.out.println("1. Get information of employee");
            System.out.println("2. Get medicine by medicine_id");
            System.out.println("3. Add new employee to DB");
            System.out.println("4. Get employee by ID");
            System.out.println("5. Dismiss an employee");
            System.out.println("6. Add project");
            try {
                System.out.println("What do you want to do?");
                int option = scanner.nextInt();
                if (option==1){
                    consoleinfo();
                }
                if(option == 3){
                    consoleEmpAdd();
                }
                if(option == 4){
                    consoleEmpById();
                }
                if (option==5){
                    consoleDismissEmp();
                }
                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error!");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void consoleEmpAdd(){
        System.out.println("Enter ID");
        int id = scanner.nextInt();
        System.out.println("Enter NAME");
        String name = scanner.next();
        System.out.println("Enter ADDRESS");
        String address = scanner.next();
        System.out.println("Enter STATUS");
        String status = scanner.next();
        System.out.println("Enter LEVEL");
        String level = scanner.next();
        System.out.println("Enter DEPARTMENT");
        String department = scanner.next();
        String response = controller.addEmployee(id, name, address, status, level, department);
        System.out.println(response);
    }
    public void consoleEmpById(){
        System.out.println("Enter ID");
        int id = scanner.nextInt();
        String response = controller.getEmpId(id);
        System.out.println(response);
    }
    public void consoleAddProject(){
        System.out.println("Enter ID");
        int id = scanner.nextInt();
        System.out.println("Enter name of project");
        String nameofproject = scanner.next();
        System.out.println("Enter Deadline");
        int deadline = scanner.nextInt();
        String response = controller.addProject(id,nameofproject,deadline);
        System.out.println(response);
    }
    public void consoleinfo(){
        BackendDeveloper backendDeveloper=new BackendDeveloper(1,"Hey","10","works","Middle","Backend Developer");
        backendDeveloper.BackendInfo();
    }
    public void consoleDismissEmp(){
        System.out.println("Enter ID of employee to dismiss");
        int id=scanner.nextInt();
        String response = controller.dismissEmp(id);
        System.out.println(response);
    }
}
