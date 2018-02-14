package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Product;

public class ProductDAO {
	public static ProductDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private ProductDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static ProductDAO getInstance() {
		if(instance == null) {
			instance = new ProductDAO();
		}
		return instance;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int insertProduct(Product product) {
		String sql = "insert into Product(p_id,p_name,p_price,p_count,p_image) values(?,?,?,?,?)";
		int insertCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getP_id());
			pstmt.setString(2, product.getP_name());
			pstmt.setInt(3, product.getP_price());
			pstmt.setInt(4, product.getP_count());
			pstmt.setString(5, product.getP_image());
			insertCount = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("상품 insert 에러 : "+e);
		}finally {
			close(pstmt);
		}
		return insertCount;
	}
	
	public ArrayList<Product> listProduct(){
		String sql = "select * from product";
		ArrayList<Product> productList = new ArrayList<>();
		Product pd = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					pd = new Product();
					pd.setP_id(rs.getString("p_id"));
					pd.setP_name(rs.getString("p_name"));
					pd.setP_price(rs.getInt("p_price"));
					pd.setP_count(rs.getInt("p_count"));
					pd.setP_image(rs.getString("p_image"));
					productList.add(pd);
				}while(rs.next());
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("getProductList 에러 : "+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return productList;
	}

}
