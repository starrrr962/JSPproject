package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.Product;

public class ListProductService {
	public ArrayList<Product> getProductList(){
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		ArrayList<Product> productsList = productDAO.listProduct();
		close(con);
		return productsList;
	}


}
