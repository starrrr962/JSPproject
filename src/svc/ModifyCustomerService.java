package svc;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.CustomerDAO;
import vo.Customer;

public class ModifyCustomerService {
	public boolean modify(Customer customer) {
		boolean modifyOk = false;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		modifyOk = customerDAO.modifyCustomer(customer);
		return modifyOk;
	}

}
