/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.DB;
import model.Bean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Bal {
    
    public void insertDataSignup(Bean beanObj){
        try {
            //create querry for inserting signup data
            String query = "insert into signup values (null,?,?,?)";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setString(1, beanObj.getFullName());//get full name from bean class which have set likes getter setter we have set value throught constructor and now we are accessing that value here
            ps.setString(2, beanObj.getEmail());
            ps.setString(3, beanObj.getPass());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "you have signup successfully,now login");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"" +e);
        }
    }
    
    
    // create method here which will check data from signup table
    
    public boolean checkLogin(String email, String pass){
        boolean b = false;
        try {
            //create query
            String query = "select Email, Password from signup where Email= '"+email+"' AND Password ='"+pass+"'";
            Statement st =DB.con.createStatement();
            ResultSet rs= st.executeQuery(query);
            if (rs.next()) {
                b= true;
                
            }else {
                JOptionPane.showMessageDialog(null,"invalid email or password  try again");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"" + e);
        }
        
        return b;
    }
    
}
