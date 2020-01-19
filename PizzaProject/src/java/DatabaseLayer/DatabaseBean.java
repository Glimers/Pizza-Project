/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseLayer;

import BusinessLayer.CrustTypes;
import BusinessLayer.Customer;
import BusinessLayer.Orders;
import BusinessLayer.Pizza;
import BusinessLayer.PizzaSizes;
import BusinessLayer.ToppingBean;
import BusinessLayer.ToppingMappingBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ethan
 */
@Stateless
public class DatabaseBean {

    @EJB
    private Orders orders;

    
   // private static DatabaseBean instance;
    //public static Connection conn;
    
    protected DatabaseBean(){
    
    }
    /*public static DatabaseBean GetInstance(){
        if(instance == null){
            instance = new DatabaseBean();
            conn = GetConnection();
        }
        return instance;
    }*/
    public static Connection GetConnection(){
            Connection conn = null;
        
            String dbURL = "jdbc:mysql://localhost:3306/pizzadb";
            String username = "root";
            String password = "";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(dbURL, username, password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DatabaseBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        return conn;
    }//end of get connection
    
   /* @PreDestroy
    protected void Disconnect(){
        try{
            conn.close();
        }
        catch(SQLException ex){
            //logging information goes here
        }
    }*/
    
    public static boolean Login(String username, String password){
        
        String sql = "SELECT * FROM employee WHERE username = ?";
        
        try{
            Connection conn = GetConnection();
            PreparedStatement s = conn.prepareStatement(sql);
            s.setString(1, username);
            ResultSet rs = s.executeQuery();
            rs.first();
            if(rs.getString("password").equals(password)){
                return true;
            }
                
            
            
        }
        catch(SQLException ex){
            //log error here
        }
        return false;
    }//end of login
    
    public static ArrayList<ToppingBean> toppings(){
        String name;
        int empAddBy, isActive, toppingId;
        float price;
        
        String sql = "SELECT name, price, empAddedBy, isActive, toppingId FROM toppings";
        
        try{
            ArrayList<ToppingBean> toppingList = new ArrayList<>();
            Connection conn = GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.first();
            
            do{
                name = rs.getString(1);
                price = rs.getFloat(2);
                empAddBy = rs.getInt(3);
                isActive = rs.getInt(4);
                toppingId = rs.getInt(5);
                
                ToppingBean tp = new ToppingBean(toppingId, name, price, isActive, empAddBy);
                toppingList.add(tp);
                
            }while(rs.next());
                        
            return toppingList;
            
        }
        catch(SQLException ex){
            //log here
        }
                
        return null;        
    }//end of toppings
    
    public static ArrayList<ToppingBean> activeToppings(){
        String name;
        int empAddBy, isActive, toppingId;
        float price;
        
        String sql = "SELECT name, price, empAddedBy, isActive, toppingId FROM toppings WHERE isActive = 1";
        
        try{
            ArrayList<ToppingBean> toppingList = new ArrayList<>();
            Connection conn = GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.first();
            
            do{
                name = rs.getString(1);
                price = rs.getFloat(2);
                empAddBy = rs.getInt(3);
                isActive = rs.getInt(4);
                toppingId = rs.getInt(5);
                
                ToppingBean tp = new ToppingBean(toppingId, name, price, isActive, empAddBy);
                toppingList.add(tp);
                
            }while(rs.next());
                        
            return toppingList;
            
        }
        catch(SQLException ex){
            //log here
        }
                
        return null;        
    }//end of active toppings
    
    public static ArrayList<PizzaSizes> pizzaList(){
        int id;
        String name;
        float price;
        
        Connection conn = GetConnection();
        String sql = "SELECT sizeid, name, price FROM sizes";
        
        try{
            ArrayList<PizzaSizes> sizeList = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.first();
            do{
                id = rs.getInt(1);
                name = rs.getString(2);
                price = rs.getFloat(3);
                PizzaSizes pizza = new PizzaSizes(id, name, price);
                sizeList.add(pizza);
            }while(rs.next());
            
            return sizeList;
            
        }
        catch(SQLException ex){
            return null;
        }
    }//end of pizzaList
    
    public static ArrayList<CrustTypes> CrustList(){
        int id;
        String name;
        float price;
        
        Connection conn = GetConnection();
        String sql = "SELECT crustTypeId, name, price FROM crusttypes";
        
        try{
            ArrayList<CrustTypes> crustList = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.first();
            do{
                id = rs.getInt(1);
                name = rs.getString(2);
                price = rs.getFloat(3);
                CrustTypes crust = new CrustTypes(id, name, price);
                crustList.add(crust);
            }while(rs.next());
            
            return crustList;
            
        }
        catch(SQLException ex){
            return null;
        }
    }//end of get CrustList
    
    public static int InsertCustomer(Customer c){
    
        String sql = "INSERT INTO customer(firstName, lastName, phoneNumber, email, houseNumber, street, province, postalCode, delivery) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            Connection conn = GetConnection(); //inject this instead? might have to move this method into a backingbean
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName()); 
            ps.setString(3, c.getPhoneNumber());
            ps.setString(4, c.getEmail());
            ps.setInt(5, c.getHouseNumber());
            ps.setString(6, c.getStreet());
            ps.setString(7, c.getProvince());
            ps.setString(8, c.getPostalCode());
            ps.setInt(9, c.getDelivery());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
                    
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
            }
            return id;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return 0;
        }
        
    }//need to overload this because there will be 2 customer inserts
    
    public static float GetSizePrice(int id){
        float price;
        String sql = "SELECT price FROM sizes WHERE sizeid= " + id;
        
        try{
            Connection conn = GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.first();
            price = rs.getFloat(1);
            return price;
        }
        catch(SQLException ex){
            //log here
        }
        return 1;
    }// end of GetSizePrice
    
    public static float GetCrustPrice(int id){
        float price = 0;
        String sql = "SELECT price FROM crusttypes WHERE crustTypeId= " + id;
        
        try{
            Connection conn = GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.first();
            price = rs.getFloat(1);
            
        }
        catch(SQLException ex){
            //log here
        }
        return price;
    }// end of GetCrustPrice
    
    public static float GetToppingPrice(String name){
        float price = 0;
        String sql = "SELECT price FROM toppings WHERE name = '" + name + "'";
        
        try{
            Connection conn = GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.first();
            price = rs.getFloat(1);
            
        }
        catch(SQLException ex){
            //log here
        }
        return price;
    }// End of GetToppingPrice
    
    public static int InsertOrder(Orders o){
    
        String sql = "INSERT INTO orders(totalPrice, deliveryDateTime, placedDateTime, customerId, orderStatus) VALUES (?, ?, ?, ?, ?)";
        
        try{
            Connection conn = GetConnection(); //inject this instead? might have to move this method into a backingbean
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            LocalDateTime dt = o.getDeliveryDateTime();
            
            
            LocalDateTime dt2 = o.getPlacedDateTime();
            
            
            ps.setFloat(1, o.getTotalPrice());
            ps.setTimestamp(2, Timestamp.valueOf(dt)); 
            ps.setTimestamp(3, Timestamp.valueOf(dt2));
            ps.setInt(4, o.getCustomerId());
            ps.setString(5, o.getOrderStatus());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
                    
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
            }
            return id;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return 0;
        }
    }//end of insertorder
    
    public static int InsertPizza(Pizza p){
    
        String sql = "INSERT INTO pizza(sizeId, isFinished, crustTypeId, price, orderId, quantity) VALUES (?, ?, ?, ?, ?, ?)";
        
        try{
            Connection conn = GetConnection(); //inject this instead? might have to move this method into a backingbean
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         
            ps.setInt(1, p.getSizeId());
            ps.setInt(2, p.getIsFinished()); 
            ps.setInt(3, p.getCrustTypeId());
            ps.setFloat(4, p.getPrice());
            ps.setInt(5, p.getOrderId());
            ps.setInt(6, p.getQuantity());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
                    
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
            }
            return id;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return 0;
        }
    }//end of insertpizza
    
    public static int GetToppingIdByName(String name){
        int id = 0;
        String sql = "SELECT toppingId FROM toppings WHERE name = '" + name + "'";
        
        try{
            Connection conn = GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.first();
            id = rs.getInt(1);
            
        }
        catch(SQLException ex){
            //log here
        }
        return id;
    }// End of GetToppingIdByName
    
    public static int InsertToppingMap(ToppingMappingBean tmp){
    
        String sql = "INSERT INTO pizza_toppings_map(toppingId, pizzaId) VALUES (?, ?)";
        
        try{
            Connection conn = GetConnection(); //inject this instead? might have to move this method into a backingbean
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         
            ps.setInt(1, tmp.getToppingId());
            ps.setInt(2, tmp.getPizzaId()); 
            
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
                    
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
            }
            return id;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return 0;
        }
    }//end of insertToppingMap
    
    public static void UpdateToActiveTopping(int id){
        String sql = "UPDATE toppings SET isActive = 1 WHERE toppingId = ?";
        
        try{
            Connection conn = GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch(SQLException ex){
        
        }
    }//end of updateto active
    
    public static void UpdateToInactiveTopping(int id){
        String sql = "UPDATE toppings SET isActive = 0 WHERE toppingId = ?";
        
        try{
            Connection conn = GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch(SQLException ex){
        
        }
    }//end of updateto inactive
    
    public static void CreateNewTopping(ToppingBean t){
        String sql = "INSERT INTO toppings (name, price, empAddedBy, isActive) VALUES (?,?,?,?)";
        
        try{
            Connection conn = GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setFloat(2, t.getPrice());
            ps.setInt(3, t.getEmployee());
            ps.setInt(4, t.getActive());
            ps.executeUpdate();
        }
        catch(SQLException ex){
        
        }
    }//end of create new topping
    
    public static ArrayList<Orders> GetListOfOrders(){
        
        int orderId;
        String fname, lname, fullname, orderstatus, time;
        float price;
        LocalDateTime expected;
        
        Connection conn = GetConnection();
        String sql = "SELECT o.orderId, o.totalPrice, o.deliveryDateTime, o.orderStatus, c.firstName, c.lastName FROM orders o INNER JOIN customer c ON c.customerid = o.customerId";
        
        try{
            ArrayList<Orders> orderList = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.first();
            do{
                Orders o = new Orders();
                o.setOrderId(rs.getInt(1));
                o.setTotalPrice(rs.getFloat(2));
                expected = rs.getTimestamp(3).toLocalDateTime();
                o.setDeliveryDateTime(expected);
                orderstatus = rs.getString(4);
                o.setOrderStatus(orderstatus);
                fname = rs.getString(5);
                lname = rs.getString(6);
                fullname = fname + " " + lname;
                o.setCustomerName(fullname);
                orderList.add(o);
                 
            }while(rs.next());
            
            return orderList;
            
        }
        catch(SQLException ex){
            return null;
        }
        
    }
    
    public static String GetSizeNameById(int id){
        String sql = "SELECT name FROM sizes WHERE sizeid = " + id;
        
        try{
            Connection conn = GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.first();
            return rs.getString(1);
           
        }
        catch(SQLException ex){
            
        }
        return null;
    }//end of get size name by id
    
    public static String GetCrustNameById(int id){
        String sql = "SELECT name FROM crusttypes WHERE crustTypeId = " + id;
        
        try{
            Connection conn = GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            rs.first();
            return rs.getString(1);
           
        }
        catch(SQLException ex){
            
        }
        return null;
    }//end of get size name by id
    
    public static int GetCustomerById(int id){
        
        String sql = "SELECT delivery FROM customer WHERE customerid = " + id;
        
        try{
            Connection conn = GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.first();
            return rs.getInt(1);
        }
        catch(SQLException ex){
            
        }
        return -1;
    }//end of get customerbyid
    
    public static void ChangeOrderStatus(int id){
    
        String sql = "UPDATE orders SET orderStatus = 'filled' WHERE orderId = ?";
        
        try{
            Connection conn = GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch(SQLException ex){
        
        }
    }//end of change orderstatus
}
