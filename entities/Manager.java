package entities;

import java.io.PrintStream;

public class Manager extends Employee implements INonprogrammer_member  {
    private int salary;
    public Manager(int EmpId, String Name, String address, String status, String level, String Department){
        super.setEmpID(EmpId);
        super.setName(Name);
        super.setAddress(address);
        super.setStatus(status);
        super.setLevel(level);
        super.setDepartment(Department);
    }
    public void setSalary(int money){
        this.salary=money;
    }
    public int gettingSalary(){
        return salary;
    }
    public void setDoingDuration(int day){
        BackendDeveloper.deadline1=day;
        FrontendDeveloper.deadline=day;
    }
    public void setBonus(int bonus){
        BackendDeveloper.Bonus=bonus;
        FrontendDeveloper.Bonus=bonus;
    }
    public void setPenalty(int penalty){
        BackendDeveloper.Penalty=penalty;
        FrontendDeveloper.Penalty=penalty;
    }
    public String manage(){
        return super.getName()+ " manage the department "+super.getDepartment();
    }
    public String work(){
        return super.getName()+ " works in IT company as manager";
    }
    public String getSalary(){
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
        return "He get salary "+gettingSalary()+"$ permonth.";
    }
    public void ManagerInfo(){
        System.out.println(work());
        System.out.println(getSalary());
        System.out.println(manage());
    }
    public void ManagerPrivateInfo() {
        PrintStream var10000 = System.out;
        String var10001 = this.getName();
        var10000.println("Manager " + var10001 + " with id " + this.getEmpId());
        System.out.println("Address: " + this.getAddress());
        System.out.println("Level: " + this.getLevel());
        System.out.println("Status: " + this.getStatus());
    }
}