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
import model.Bill;

/**
 *
 * @author Admin
 */
public class BillDBContext extends DBContext {

    public ArrayList<Bill> getBills(int bid) {
        ArrayList<Bill> bills = new ArrayList();
        try {
            String sql = "SELECT bid, month, electric, water, reduce, rid FROM StudentBill WHERE bid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, bid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Bill b = new Bill();
                b.setBid(rs.getInt("bid"));
                b.setMonth(rs.getInt("month"));
                b.setElectric(rs.getFloat("electric"));
                b.setWater(rs.getFloat("water"));
                b.setReduce(rs.getFloat("reduce"));
                b.setRid(rs.getInt("rid"));
                bills.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }
}
