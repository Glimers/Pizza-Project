/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.DatabaseBean;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ethan
 */
@Named(value = "custBacking")
@Stateless
public class CustomerBackingBean {
    
    @EJB
    private Customer customer;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public CustomerBackingBean() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public String AddCustomer() throws IOException{
         
        int id = DatabaseBean.InsertCustomer(customer);
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        //check to see if address properly entered and return error if missing field
        if(customer.getDelivery() == 1){
            if(customer.getStreet().equals("") || customer.getHouseNumber() == 0 || customer.getPostalCode().equals("")){
                externalContext.redirect("CustomerInfo.xhtml?msg=Please fill out address when selecting delivery");
                return "error";
            }
        }
        
        if(id != 0){
            //direct to order page
            externalContext.redirect("orderPage.jsp?custId=" +  id);
            return "orderpage.jsp?custId=" + id;
        }
        else{
            //on should happen if error with database
            externalContext.redirect("CustomerInfo.xhtml?msg=error try again later");
            return "Error";
        }
        
        //have a redirect to orderPage.jsp?custId = x     x = whatever the customerId is that is returned from DB
    }
    
    public static int GetCustomerById(int id){
     
        return DatabaseBean.GetCustomerById(id);
        
    } //get customer by Id
    
}
