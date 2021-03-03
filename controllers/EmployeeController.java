package controllers;

import entities.BackendDeveloper;
import entities.Employee;
import repositories.interfaces.IEmployeeRepositories;

public class EmployeeController {
    private final IEmployeeRepositories repo;

    public EmployeeController(IEmployeeRepositories repo) {
        this.repo = repo;
    }

    public String addEmployee(int id, String name, String address, String status, String level, String department) {
        Employee employee = new Employee(id, name, address, status, level, department);
        boolean add = repo.addEmployee(employee);
        if (add == true) {
            return "Employee was added!";
        } else
            return "Employee was not added!";
    }
    public String getEmpId(int id) {
        Employee employee = repo.getEmployeeId(id);
        if (employee != null) {
            return employee.toString();
        } else
            return "Employee was not found! Seems like he does not work here";
    }
    public String addProject(int EmpId,String nameofproject, int deadline) {
        BackendDeveloper backendDeveloper = new BackendDeveloper(EmpId, nameofproject, deadline);
        boolean addpr= repo.addProject(backendDeveloper);
        if (addpr==true) {
            return "Project has added";
        } else
            return "Error 404";
    }
    public String dismissEmp(int id){
        boolean delete=repo.dismissEmployee(id);
        if (delete!=false){
            return "Employee was dismissed!";
        }
        else
            return "Employee can not be dismissed.";
    }
}
