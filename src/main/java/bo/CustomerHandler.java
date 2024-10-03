package bo;

import ui.CustomerInfo;
import ui.ProductInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class CustomerHandler {

    public static boolean addCustomer(CustomerInfo c) throws SQLException {
        Customer cust = new Customer(-1, c.getPasswordHash(), c.getPhoneNumber(),c.getEmail(),c.getLastName(),c.getFirstName());
        return Customer.addCustomer(cust);
    }

    public static Collection<CustomerInfo> getCustomersByEmail(String email) {
        Collection c = Customer.getCustomersByEmail(email);
        ArrayList<CustomerInfo> customers = new ArrayList<CustomerInfo>();
        for(Iterator i = c.iterator(); i.hasNext();) {
            Customer customer = (Customer) i.next();
            customers.add(new CustomerInfo(customer.getCustomerID(), customer.getPasswordHash(), customer.getPhoneNumber(), customer.getEmail(), customer.getLastName(), customer.getFirstName()));
        }
        return customers;
    }
}
