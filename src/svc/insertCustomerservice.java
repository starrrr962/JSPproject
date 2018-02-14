package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.CustomerDAO;
import vo.Customer;

public class insertCustomerservice {
	public boolean joinMember(Customer customer) {
		boolean JoinSucess = false;
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		Connection con = getConnection();
		customerDAO.setConnection(con);
		int insertCount = customerDAO.insertCustomer(customer);
		if(insertCount > 0) {
			JoinSucess = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return JoinSucess;
	}
}
