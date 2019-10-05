package com.kuchipudi.jdbcalldbs.dao;

import java.util.List;

import com.kuchipudi.jdbcalldbs.model.Customer;

public interface CustomerDao {
	void insert(Customer cus);
	void inserBatch(List<Customer> customers);
	List<Customer> loadAllCustomer();
	Customer findCustomerById(long cust_id);
	String findNameById(long cust_id);
	int getTotalNumberCustomer();
}
