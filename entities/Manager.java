package entities;

public class Manager extends Employee implements INonprogrammer_member  {
    private int salary;
    public Manager(int EmpId, String Name, String address, String status, String level, String Department){
        super();
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
        return "He get salary "+gettingSalary()+"$ permonth.";
    }
    public void ManagerInfo(){
        System.out.println(work());
        System.out.println(getSalary());
        System.out.println(manage());
    }
}