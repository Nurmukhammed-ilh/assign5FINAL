import controllers.EmployeeController;
import entities.BackendDeveloper;
import entities.FrontendDeveloper;
import entities.Manager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final EmployeeController controller;
    private final Scanner scanner;

    public MyApplication(EmployeeController controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }
    Manager manager=new Manager(1,"Chase","HIlltop","works","Lead","Manager");
    BackendDeveloper backendDeveloper=new BackendDeveloper(2,"Hudson","Alexandria","works","Lead","Backend");
    FrontendDeveloper frontendDeveloper=new FrontendDeveloper(3,"Rick","OceanSide","works","Senior","Frontend");
    int option;
    public void start(){
        while(option!=14){
            System.out.println("===============================");
            //jut average programmers information is on database but the main employers information declared by constructor
            System.out.println("1. Get information of the Manager");
            System.out.println("2. Get information of the main Frontend Developer");
            System.out.println("3. Get information of the main Backend Developer");
            System.out.println("4. Get main developers private info");
            System.out.println("5. Dismiss an employee");
            System.out.println("6. Add project");
            System.out.println("7. Get employee by level");
            System.out.println("8. Add new employee to DB");
            System.out.println("9. Get employee by ID");
            System.out.println("10. Get information of the main Frontend Developer's current project");
            System.out.println("11. Add project for main Frontend Developer");
            System.out.println("12. Get information of the main Backend Developer's current project");
            System.out.println("13. Add project for main Backend Developer");
            System.out.println("14. Exit.");
            System.out.println("===============================");
            try {
                System.out.println("What do you want to do?");
                option = scanner.nextInt();
                if (option==1){
                    consoleinfo();
                }
                if(option==2){
                    consoleinfoFront();
                }
                if(option == 8){
                    consoleEmpAdd();
                }
                if(option == 9){
                    consoleEmpById();
                }
                if (option==5){
                    consoleDismissEmp();
                }
                if (option==6){
                    consoleAddProject();
                }
                if(option==7){
                    consoleEmpByLevel();
                }
                if (option == 10){
                    frontendDeveloper.CurrentProject();
                }
                if(option==11){
                   frontendDeveloper.addProject();
                }
                if(option==3){
                    consoleinfoBack();
                }
                if(option==13){
                    backendDeveloper.addProject();
                }
                if(option==12){
                    frontendDeveloper.CurrentProject();
                }
                if(option==4){
                    System.out.println("1. Get Backend Developer's private information");
                    System.out.println("2. Get Frontend Developer's private information");
                    System.out.println("3. Get Manager's private information");
                    int menu2 = scanner.nextInt();
                    if (menu2 == 1) {
                        backendDeveloper.BackendPrivateInfo();
                    }
                    if (menu2 == 2) {
                        frontendDeveloper.FrontendPrivateInfo();
                    }
                    if (menu2 == 3) {
                        manager.ManagerPrivateInfo();
                    }
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
    public void consoleEmpByLevel(){
        System.out.println("Enter level");
        String level=scanner.next();
        String response=controller.getEmpLevel(level);
        System.out.println(response);
    }
    public void consoleAddProject(){
        System.out.println("Enter name of project");
        String nameofproject = scanner.next();
        System.out.println("Enter Deadline");
        int deadline = scanner.nextInt();
        String response = controller.addProject(nameofproject,deadline);
        System.out.println(response);
    }
    public void consoleinfo(){
        manager.ManagerInfo();
    }
    public void consoleinfoBack(){
        backendDeveloper.BackendInfo();
    }
    public void consoleinfoFront(){
        frontendDeveloper.FrontendInfo();
    }
    public void consoleDismissEmp(){
        System.out.println("Enter ID of employee to dismiss");
        int id=scanner.nextInt();
        String response = controller.dismissEmp(id);
        System.out.println(response);
    }
    }

