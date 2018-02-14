package dao;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.ArrayList;

import javax.sql.*;

import vo.Customer;


public class CustomerDAO {
	public static CustomerDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private CustomerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static CustomerDAO getInstance() {
		if(instance == null) {
			instance = new CustomerDAO();
		}
		return instance;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int insertCustomer(Customer customer) {
		String sql = "insert into Customer(c_name,c_email,c_pw,c_phone,c_address) values(?,?,?,?,?)";
		int insertCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getC_name());
			pstmt.setString(2, customer.getC_email());
			pstmt.setString(3, customer.getC_pw());
			pstmt.setString(4, customer.getC_phone());
			pstmt.setString(5, customer.getC_address());
			insertCount = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("insert 에러 : "+e);
		}finally {
			close(pstmt);
		}
		return insertCount;
	}
	
	public Customer loginCustomer(String email, String pw) {
		String sql = "select * from Customer where c_email = ? and c_pw = ? ";
		Customer customerOK = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				customerOK = new Customer();
				customerOK.setC_email(rs.getString("c_email"));
				customerOK.setC_pw(rs.getString("c_pw"));
				customerOK.setC_name(rs.getString("c_name"));
				customerOK.setC_phone(rs.getString("c_phone"));
				customerOK.setC_address(rs.getString("c_address"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("login 에러 : "+e);
		}finally {
			close(pstmt);
		}
		return customerOK;
	}
	
	public boolean modifyCustomer(Customer customer) {
		boolean modifyOk = false;
		int count = 0;
		String sql = "update customer set c_pw=?, c_phone=?, c_address=? where c_email=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getC_pw());
			pstmt.setString(2, customer.getC_phone());
			pstmt.setString(3, customer.getC_address());
			pstmt.setString(4, customer.getC_email());
			count = pstmt.executeUpdate();
			if (count != 0) {
				modifyOk = true;
				commit(con);
			}else {
				rollback(con);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("customer modify 에러 : "+e);
		}finally {
			close(pstmt);
		}
		return modifyOk;
	}
	
	public ArrayList<Customer> listcustomer(){
		String sql = "select * from customer";
		ArrayList<Customer> customerList = new ArrayList<>();
		Customer cs = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					cs = new Customer();
					cs.setC_email(rs.getString("c_email"));
					cs.setC_pw(rs.getString("c_pw"));
					cs.setC_name(rs.getString("c_name"));
					cs.setC_phone(rs.getString("c_phone"));
					cs.setC_address(rs.getString("c_address"));
					customerList.add(cs);
				}while(rs.next());
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("getDeatilCustomer 에러 : "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return customerList;
	}
	

}
