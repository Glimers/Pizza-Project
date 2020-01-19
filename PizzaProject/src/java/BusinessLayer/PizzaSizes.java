/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.DatabaseBean;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author ethan
 */
@Stateless
public class PizzaSizes {
    int sizeId;
    String name;
    float price;

    public PizzaSizes(){
    }
    
    public PizzaSizes(int sizeId, String name, float price) {
        this.sizeId = sizeId;
        this.name = name;
        this.price = price;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
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
    
    public static ArrayList<PizzaSizes> ListOfSizes(){
        return DatabaseBean.pizzaList(); //go to DB from here
    }
    
    public static float GetPriceById(int id){
        
        return DatabaseBean.GetSizePrice(id);
        
    }
    
    public static String GetNameById(int id){
        return DatabaseBean.GetSizeNameById(id);
    }
    
}
