/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ManagerAccount;
import model.Student;
import model.StudentAccount;

/**
 *
 * @author Admin
 */
public class AccountDBContext extends DBContext {

    public StudentAccount getStudentAccount(String username, String password) {
        try {
            String sql = "SELECT sa.id, sa.username, sa.password, s.sid, s.sname, s.gender, s.grade, s.idcard, s.email, s.phonnumber, s.address, s.pid, s.bid, s.cid\n"
                    + "FROM StudentAccount sa INNER JOIN Student s ON sa.sid = s.sid \n"
                    + "WHERE sa.username = ?  AND sa.password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                StudentAccount account = new StudentAccount();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setGender(rs.getBoolean("gender"));
                s.setIdCard(rs.getString("idcard"));
                s.setGrade(rs.getInt("grade"));
                s.setPhoneNumber(rs.getString("phonnumber"));
                s.setEmail(rs.getString("email"));
                s.setAddress(rs.getString("address"));
                s.setParent(rs.getInt("pid"));
                s.setBid(rs.getInt("bid"));
                s.setCid(rs.getInt("cid"));
                account.setStudent(s);
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*public ManagerAccount getManagerAccount(String username, String password) {
        try {
            String sql = "SELECT id, username, password\n"
                    + "FROM ManagerAccount"
                    + "WHERE username = ?  AND password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                ManagerAccount account = new ManagerAccount();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));        
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/
     public ArrayList<StudentAccount> getStudents() {
         ArrayList<StudentAccount> stu = new ArrayList();
        try {
            String sql = "SELECT sa.id, sa.username, sa.password, s.sid, s.sname, s.gender, s.grade, s.idcard, s.email, s.phonnumber, s.address, s.pid, s.bid, s.cid FROM StudentAccount sa INNER JOIN Student s ON sa.sid = s.sid \n";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                StudentAccount account = new StudentAccount();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setGender(rs.getBoolean("gender"));
                s.setIdCard(rs.getString("idcard"));
                s.setGrade(rs.getInt("grade"));
                s.setPhoneNumber(rs.getString("phonnumber"));
                s.setEmail(rs.getString("email"));
                s.setAddress(rs.getString("address"));
                s.setParent(rs.getInt("pid"));
                s.setBid(rs.getInt("bid"));
                s.setCid(rs.getInt("cid"));
                account.setStudent(s);
                stu.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stu;
    }
     
    public ManagerAccount getManagerAccount(String username, String password){
        ManagerAccount account = new ManagerAccount(1, "manager", "12345");
        
        if (username.equals(account.getUsername()) && password.equals(account.getPassword())){
           return account; 
        } 
        else return null;
        
    }
}
