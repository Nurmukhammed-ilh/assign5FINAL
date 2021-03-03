package repositories;

import data.interfaces.IDB;
import entities.BackendDeveloper;
import entities.Employee;
import repositories.interfaces.IEmployeeRepositories;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepositories implements IEmployeeRepositories {
    private final IDB db;

    public EmployeeRepositories(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO medicine (id,name,address,status,level,department) VALUES(?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, employee.getEmpId());
            st.setString(2, employee.getName());
            st.setString(3, employee.getAddress());
            st.setString(4, employee.getStatus());
            st.setString(5, employee.getLevel());
            st.setString(6, employee.getDepartment());
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Employee getEmployeeId(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,address,status,level,department FROM medicine WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("status"),
                        rs.getString("level"),
                        rs.getString("department"));
                return employee;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    public Employee getEmployeeLevel(String level) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,address,status,level,department FROM medicine WHERE level=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, level);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("status"),
                        rs.getString("level"),
                        rs.getString("department"));
                return employee;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
       public boolean addProject(BackendDeveloper backendDeveloper) {
            Connection con = null;
            try {
                con = db.getConnection();
                String sql = "INSERT INTO medicine (nameofproject,deadline) VALUES(?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, backendDeveloper.nameOfProject);
                st.setInt(2, backendDeveloper.getDeadline());
                st.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return false; }
    @Override
    public boolean dismissEmployee(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM medicine WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    /*
    @Override
    public Employee getAllBack() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "select * from medicine where department='Junior'";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Integer> idList = new LinkedList<>();
            while (rs.next()){
                idList.add(rs.getInt("id"));
            }
            int counter = 0;
            while (counter < idList.size()){
                sql = "select name,address from medicine where id = ?";
                st = con.prepareStatement(sql);
                st.setInt(1,idList.get(counter));
                rs = st.executeQuery();
                counter++;
                while(rs.next()){
                    Employee employee= new Employee(rs.getString("name"), rs.getString("address"));
                    idList.add(employee);
                }
            }
            return idList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }
    /*/
}
