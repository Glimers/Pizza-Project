/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.DatabaseBean;
import javax.ejb.Stateless;

/**
 *
 * @author ethan
 */
@Stateless
public class ToppingMappingBackingBean {

    public ToppingMappingBackingBean() {
    }

    public int ToppingMap(ToppingMappingBean tmp){
        return DatabaseBean.InsertToppingMap(tmp);
    }
}
