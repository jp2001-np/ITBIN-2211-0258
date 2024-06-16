/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.DB;
import model.HomeBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class HomeBal {
    
    //create method for load read data from employee
    
    public List<HomeBean> loadData(){
        List<HomeBean> list= new ArrayList<HomeBean>();
        try {
            //make the query select all data from employee table
            String query=" select *from employee";
            PreparedStatement ps=DB.con.prepareStatement(query);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) { 
                int id= rs.getInt("Id");
                String firstName= rs.getString("FirstName"); // columns name
                String lastName= rs.getString("LastName");
                String gender= rs.getString("Gender");
                String city= rs.getString("City");
                String age= rs.getString("Age");
                String address= rs.getString("Address");
                
                //cresting homebean object
                
                HomeBean bean=new HomeBean( id,firstName, lastName, gender, city, age, address);
                list.add(bean); // add bean in list
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e);
        }
        return list;
    }
    
    //create method for inserting data
    
    public void insert (HomeBean homeBean){
        
        try {
           // make query of insert 
           String query= "insert into employee values (null,?,?,?,?,?,?)";
            PreparedStatement ps= DB.con.prepareStatement(query);
            ps.setString(1, homeBean.getFirstName());
            ps.setString(2, homeBean.getLastName());
            ps.setString(3, homeBean.getGender());
            ps.setString(4, homeBean.getCity());
            ps.setString(5, homeBean.getAge());
            ps.setString(6, homeBean.getAddress());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "A record has been inserted");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e);
        }
    }
    
    // create method for get data on click in jtable
    
    public HomeBean returnAllDataToTextFields(int id){
       HomeBean bean = null;
        try {
            
            String query = " select * from employee where id = "+id;
            PreparedStatement ps= DB.con.prepareStatement(query);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {  
                 int ids= rs.getInt("Id");
                String firstName= rs.getString("FirstName"); // columns name
                String lastName= rs.getString("LastName");
                String gender= rs.getString("Gender");
                String city= rs.getString("City");
                String age= rs.getString("Age");
                String address= rs.getString("Address");
                bean = new HomeBean(ids, firstName, lastName, gender, city, age, address);
                
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e);
        }
        
        return bean;
       
               }
    
    // create a method for update
    public void updatedate(HomeBean bean){
        
        try {
            String query = "update employee set FirstName= ?, LastName=?,Gender=?,City=?,Age=?,Address=? where Id=?";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setString(1, bean.getFirstName());
            ps.setString(2, bean.getLastName());
            ps.setString(3, bean.getGender());
            ps.setString(4, bean.getCity());
            ps.setString(5, bean.getAge());
            ps.setString(6, bean.getAddress());
            ps.setInt(7, bean.getId());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "A record has been updated");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e);
        }
       }
    
    // create a method for delete
    
         public void deleteRecord(int id){
             try {
                 String query = " delete from employee where Id= ?";
                 PreparedStatement ps = DB.con.prepareStatement(query);
                 ps.setInt(1, id);
                 ps.executeUpdate();
                 JOptionPane.showMessageDialog(null, " A record has been deleted ");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, ""+e);
             }
  
         }
    }
    

    
           

