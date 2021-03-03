package entities;

import java.io.PrintStream;
import java.util.Scanner;

public class FrontendDeveloper extends Employee implements IProgrammer_member {
    public static int deadline;
    public static int Bonus;
    public static int Penalty;
    private int doTime;
    private int Salary;
    int checkitnow = 0;
    public String nameOfProject;
    public int deadline1;
    Scanner scanner = new Scanner(System.in);
    public FrontendDeveloper(int EmpId, String Name, String address, String status, String level, String Department){
        super.setEmpID(EmpId);
        super.setName(Name);
        super.setAddress(address);
        super.setStatus(status);
        super.setLevel(level);
        super.setDepartment(Department);
    }
    public void setSalary(int money) {
        this.Salary = money;
    }

    public int gettingSalary() {
        return Salary;
    }

    public void setDoTime(int day) {
        this.doTime = day;
    }

    public int getDoTime() {
        return doTime;
    }

    public String programs() {
        return super.getName() + " programs in " + super.getDepartment() + " department";
    }

    public String work() {
        return super.getName() + " works in IT company as Frontend developer.";
    }

    public String getSalary() {
        if (getLevel() == "Junior") {
            setSalary(1500);
        }
        if (getLevel() == "Middle") {
            setSalary(2500);
        }
        if (getLevel() == "Senior") {
            setSalary(4000);
        }
        if (getLevel() == "Lead") {
            setSalary(7000);
        }
        return "He get salary " + gettingSalary() + "$ per month.";
    }

    public int get_doing_duration() {
        return deadline;
    }

    public int getBonus() {
        return Bonus;
    }

    public int getPenalty() {
        return Penalty;
    }
    public String write(){
        return "He writes HTML and CSS pages.";
    }
    public String checking() {
        if (deadline < doTime)
            return "He got bonus in "+getBonus()+"$ for early done.";
        else
            return "He got penalty in "+getPenalty()+"$ for late";
    }
    public void FrontendInfo(){
        System.out.println(work());
        System.out.println(programs());
        System.out.println(getSalary());
        System.out.println(write());
        System.out.println(checking());
    }
    public void FrontendPrivateInfo() {
        PrintStream var10000 = System.out;
        String var10001 = this.getName();
        var10000.println("FrontEnd Developer " + var10001 + " with id " + this.getEmpId());
        System.out.println("Address: " + this.getAddress());
        System.out.println("Level: " + this.getLevel());
        System.out.println("Status: " + this.getStatus());
    }
    public void addProject() {
        System.out.println("Enter name of project");
        this.nameOfProject = scanner.nextLine();
        System.out.println("How many days programmer have to finish the Project");
        deadline = scanner.nextInt();
        System.out.println("The project is added!");
        PrintStream var10000 = System.out;
        var10000.println("Frontend Developer have " + deadline + " days to finish the project: " + this.nameOfProject + "'");
    }
    public void CurrentProject() {
       if (this.nameOfProject == null) {
            System.out.println("Currently He does not have any project to do.");
            System.out.println("You can add project using menu");
        } else {
           System.out.println("How many days he is doing project - " + this.nameOfProject + "?");
           doTime = scanner.nextInt();
           String var10001 = this.nameOfProject;
           System.out.println("He is doing the project-" + var10001 + " for " + this.getDoTime() + " days");;
               System.out.println("He will get 200 bonus if he finish it by time");
           }
       }
}
