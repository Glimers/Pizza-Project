/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.DatabaseBean;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author ethan
 */
@Named(value="topping")
@Stateless
public class ToppingBean{
    private int id;
    private String name;
    private float price;
    private int active;
    private int employee;
    
    private ArrayList<ToppingBean> list;

    public ArrayList<ToppingBean> getList() {
        return list;
    }

    public void setList(ArrayList<ToppingBean> list) {
        this.list = list;
    }
    

    public ToppingBean() {
        list = FetchAllToppings();
    }

    public ToppingBean(int id, String name, float price, int active, int employee) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.active = active;
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public static ArrayList<ToppingBean> FetchAllToppings(){
        
        ArrayList<ToppingBean> top = DatabaseBean.toppings();
    //    ArrayList<ToppingBean> top = new ArrayList<>();
    //    top.add(new ToppingBean(("food",)))
        return top;
       //return null;
    }
    
    public static ArrayList<ToppingBean> FetchActiveToppings(){
    
        ArrayList<ToppingBean> top = DatabaseBean.activeToppings();
        return top;
    
    }
    
    public static float fetchToppingPriceByName(String name){
        return DatabaseBean.GetToppingPrice(name);
    }
    
    public int fetchToppingIdByName(String name){
        return DatabaseBean.GetToppingIdByName(name);
    }
    
    public static void activateTopping(int id){
        DatabaseBean.UpdateToActiveTopping(id);
    }
    
    public static void deactivateTopping(int id){
        DatabaseBean.UpdateToInactiveTopping(id);
    }
    
    public static void createNewTopping(ToppingBean t){
        DatabaseBean.CreateNewTopping(t);
    }
}
