/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author Admin
 */
public class StudentDBContext extends DBContext {

    public void UpdateStudent(Student s) {
        try {
            String sql = "UPDATE Student\n"
                    + "SET sname =  ? , gender = ?, idcard = ?, phonnumber = ?, email = ?, grade = ?,address = ?\n"
                    + "WHERE sid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm = connection.prepareStatement(sql);
            stm.setString(1, s.getSname());
            stm.setBoolean(2, s.isGender());
            stm.setString(3, s.getIdCard());
            stm.setString(4, s.getPhoneNumber());
            stm.setString(5, s.getEmail());
            stm.setInt(6, s.getGrade());
            stm.setString(7, s.getAddress());
            stm.setInt(8, s.getSid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
