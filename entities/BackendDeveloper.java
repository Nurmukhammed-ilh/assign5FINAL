package entities;

public class BackendDeveloper extends Employee implements IProgrammer_member {
    private int deadline;
    public static int Bonus;
    public static int Penalty;
    public static int deadline1;
    private int doTime;
    private int Salary;
    private String nameofproject;
    public BackendDeveloper(int EmpId, String Name, String address, String status, String level, String Department){
        super();
        super.setEmpID(EmpId);
        super.setName(Name);
        super.setAddress(address);
        super.setStatus(status);
        super.setLevel(level);
        super.setDepartment(Department);
    }

    public BackendDeveloper(int EmpId, String nameofproject, int deadline) {
        super.setEmpID(EmpId);
        this.nameofproject=nameofproject;
        this.deadline=deadline;
    }

    public void setSalary(int money){
        this.Salary=money;}

    public int gettingSalary(){
        return Salary;
    }

    public void setDeadline( int deadline){
        this.deadline=deadline;}

    public int getDeadline(){
        return deadline;
    }

    public void setNameofproject(String nameofproject){
        this.nameofproject=nameofproject;}

        public String getNameofproject(){
        return nameofproject;
        }

    public void setDoTime(int day) {
        this.doTime = day;
    }

    public int getDoTime() {
        return doTime;
    }

    public void backSalary(){
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
        } else {
            System.out.println("The employee can't be the manager. He lacks experience");
        }
    }

    public String programs() {
        return super.getName() + " programs in "+ super.getDepartment()+" department";
    }

    public String work() {
        return super.getName() + " works in IT company as Backend developer.";
    }

    public String getSalary() {
        return "He get salary "+gettingSalary()+"$ per month.";
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
        return "He writes Java";
    }
    public String checking() {
        if (deadline < doTime)
            return "He got bonus in "+getBonus()+"$ for early done.";

        else
            return "He got penalty in "+getPenalty()+"$ tg for late";
    }
    public void BackendInfo(){
        System.out.println(work());
        System.out.println(programs());
        System.out.println(getSalary());
        System.out.println(write());
        System.out.println(checking());
    }

}