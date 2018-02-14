package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ModifyCustomerService;
import vo.ActionForward;
import vo.Customer;

public class ModifyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		HttpSession session = request.getSession();
		boolean modifyOk = false;
		Customer customer = null;
		
		customer = (Customer)session.getAttribute("customer");
		
		if(customer != null) {
			customer.setC_pw(request.getParameter("c_pw"));
			customer.setC_phone(request.getParameter("c_phone"));
			customer.setC_address(request.getParameter("c_address"));
		}
		ModifyCustomerService modifyservise = new ModifyCustomerService();
		modifyOk = modifyservise.modify(customer);
		
		if(modifyOk) {
			forward = new ActionForward();
			forward.setPath("index.jsp");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
