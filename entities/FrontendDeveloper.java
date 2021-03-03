package entities;

public class FrontendDeveloper extends Employee implements IProgrammer_member {
    public static int deadline;
    public static int Bonus;
    public static int Penalty;
    private int doTime;
    private int Salary;
    public FrontendDeveloper(int EmpId, String Name, String address, String status, String level, String Department){
        super();
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
}
