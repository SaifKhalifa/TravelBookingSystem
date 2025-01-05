package com.groupnine.travelbookingsystem.model.customerManagment;

import java.util.List;

public interface CustomerDAO {
    void saveCustomer(Customer customer);

    // get the number of customers
    long getCustomersCount();

    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);

}
