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
import model.Report;

/**
 *
 * @author Admin
 */
public class ReportDBContext extends DBContext {

    public void insertRp(Report r) {
        try {
            String sql = "INSERT INTO [Report] ([reid], [title], [content])\n"
                    + "VALUES (?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, r.getReid());
            stm.setString(2, r.getTitle());
            stm.setString(3, r.getContent());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getLastRpId(){
        int lreid = 0;
        try {
            String sql = "SELECT reid FROM Report";
            PreparedStatement stm = connection.prepareStatement(sql);           
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                lreid = rs.getInt("reid");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lreid;
    }
    
    public ArrayList<Report> getReports(){
        ArrayList<Report> rps = new ArrayList();
         try {
            String sql = "SELECT reid, title, content FROM Report";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Report r = new Report();
                r.setReid(rs.getInt("reid"));
                r.setTitle(rs.getString("title"));
                r.setContent(rs.getString("content"));
                rps.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rps;
    }
}
