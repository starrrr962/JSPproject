package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ListProductService;
import vo.ActionForward;
import vo.Product;

public class ProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		ActionForward forward = new ActionForward();
		ListProductService listProductService = new ListProductService();
		ArrayList<Product> productList = listProductService.getProductList();
		request.setAttribute("productList", productList);
		forward.setPath("./index.jsp");
		return forward;
	}

}
