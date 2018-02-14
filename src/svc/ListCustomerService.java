package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CustomerDAO;
import vo.Customer;


public class ListCustomerService {
	public ArrayList<Customer> getCustomerList(){
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		ArrayList<Customer> customerList = customerDAO.listcustomer();
		close(con);
		return customerList;
	}

}
