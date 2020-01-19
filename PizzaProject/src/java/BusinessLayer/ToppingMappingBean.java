/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import javax.ejb.Stateless;

/**
 *
 * @author ethan
 */
@Stateless
public class ToppingMappingBean {

    private int pizzaToppingId;
    private int pizzaId;
    private int toppingId;

    public ToppingMappingBean() {
    }

    public int getPizzaToppingId() {
        return pizzaToppingId;
    }

    public void setPizzaToppingId(int pizzaToppingId) {
        this.pizzaToppingId = pizzaToppingId;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }
    
    
}
