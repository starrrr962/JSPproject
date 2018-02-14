package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.insertCustomerservice;
import svc.insertProductService;
import vo.ActionForward;
import vo.Customer;
import vo.Product;

public class InsertProductAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String realFolder = "";
		String saveFolder = "/ProductUpload";
		int fileSize = 5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder,fileSize,"UTF-8",new DefaultFileRenamePolicy());
		
		Product product = new Product();
		boolean insertResult = false;
		
		product.setP_id(multi.getParameter("p_id"));
		product.setP_name(multi.getParameter("p_name"));
		product.setP_price(Integer.parseInt(multi.getParameter("p_price")));
		product.setP_count(Integer.parseInt(multi.getParameter("p_count")));
		product.setP_image(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		insertProductService insertservice = new insertProductService();

		insertResult = insertservice.insertProduct(product);  
		
		ActionForward forward = null;
		
		if (insertResult == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("admin.jsp");
		}
		return forward;
	}

}
