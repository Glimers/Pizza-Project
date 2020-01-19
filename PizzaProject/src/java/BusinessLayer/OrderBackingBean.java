/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.DatabaseBean;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ethan
 */
@Stateless
public class OrderBackingBean {

    @EJB
    public Orders order;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public OrderBackingBean() {
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
    
    public int AddNewOrder(Orders o){
        return DatabaseBean.InsertOrder(o);
    }
    
    public static ArrayList<Orders> listOfOrders(){
        return DatabaseBean.GetListOfOrders(); //change this to connect to DB to return list of orders
    }
    
    public void ChangeOrderStatus(int id){
        DatabaseBean.ChangeOrderStatus(id);
    }
}
