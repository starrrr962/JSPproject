package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.ProductDAO;
import vo.Product;

public class insertProductService {
	public boolean insertProduct(Product product) {
		boolean insertSucess = false;
		ProductDAO productDAO = ProductDAO.getInstance();
		Connection con = getConnection();
		productDAO.setConnection(con);
		int insertCount = productDAO.insertProduct(product);
		if (insertCount > 0) {
			insertSucess = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return insertSucess;
	}
}
