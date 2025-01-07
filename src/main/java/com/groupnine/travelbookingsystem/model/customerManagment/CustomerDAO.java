package com.groupnine.travelbookingsystem.model.customerManagment;

import java.util.List;

public interface CustomerDAO {
    //Creation
    void saveCustomer(Customer customer);

    //Reading
    long getCustomersCount();
    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();

    //Updating
    void updateCustomer(Customer customer);

    //Deletion
    void deleteCustomer(int id);
}
