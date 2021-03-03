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
            st.setString(6, employee.getLevel());
            st.setString(5, employee.getDepartment());
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

    @Override
       public boolean addProject(BackendDeveloper backendDeveloper) {
            Connection con = null;
            try {
                con = db.getConnection();
                String sql = "INSERT INTO medicine (nameofproject,deadline) VALUES(?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, backendDeveloper.getNameofproject());
                st.setInt(2, backendDeveloper.getDeadline());
                st.execute();
                String sql2 = "update medicine set nameofproject='?',deadline='?' where id='?'";
                PreparedStatement st2 = con.prepareStatement(sql2);
                st2.execute();
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
    public boolean addProject(BackendDeveloper backendDeveloper) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "update medicine set nameofproject='?',deadline='?' where id='?'";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, backendDeveloper.getEmpId());
            st.setString(2, backendDeveloper.getNameofproject());
            st.setInt(3, backendDeveloper.getDeadline());
            ResultSet rs = st.executeQuery();
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
    }*/
}
