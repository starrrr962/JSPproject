package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.CustomerDAO;
import vo.Customer;

public class LoginCustomerservice {
	public Customer login(String email, String pw) {
		Customer loginCustomer = null;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		loginCustomer = customerDAO.loginCustomer(email, pw);
		return loginCustomer;
	}

}
