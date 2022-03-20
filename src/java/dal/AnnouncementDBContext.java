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
import model.Announcement;

/**
 *
 * @author Admin
 */
public class AnnouncementDBContext extends DBContext{
   public ArrayList<Announcement> getAnns(){
       ArrayList<Announcement> annList = new ArrayList();
       try {
            String sql = "SELECT aid, title, content, [time] FROM Announcement";                 
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Announcement an = new Announcement();
                an.setAid(rs.getInt("aid"));
                an.setTitle(rs.getString("title"));
                an.setContent(rs.getString("content"));
                an.setTime(rs.getDate("time"));
                annList.add(an);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnnouncementDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
       return annList;
   } 
}
