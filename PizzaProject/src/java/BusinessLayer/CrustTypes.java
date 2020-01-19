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
public class CrustTypes {

    int crustId;
    String name;
    Float price;

    public CrustTypes(){
    
    }
    
    public CrustTypes(int crustId, String name, Float price) {
        this.crustId = crustId;
        this.name = name;
        this.price = price;
    }

    public int getCrustId() {
        return crustId;
    }

    public void setCrustId(int crustId) {
        this.crustId = crustId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
    public static ArrayList<CrustTypes> GetCrustList(){
        return DatabaseBean.CrustList();
                
    }
    
    public static float GetPriceById(int id){
        return DatabaseBean.GetCrustPrice(id);
    }
    
    public static String GetNameById(int id){
        return DatabaseBean.GetCrustNameById(id);
    }
}
