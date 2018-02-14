package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.insertCustomerservice;
import vo.ActionForward;
import vo.Customer;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Customer customer = new Customer();
		boolean joinResult = false;

		customer.setC_name(request.getParameter("c_name"));
		customer.setC_email(request.getParameter("c_email"));
		customer.setC_pw(request.getParameter("c_pw"));
		customer.setC_address(request.getParameter("c_address"));
		customer.setC_phone(request.getParameter("c_phone"));

		insertCustomerservice joinservice = new insertCustomerservice();

		joinResult = joinservice.joinMember(customer);
		
		request.setAttribute("c_name",customer.getC_name());

		ActionForward forward = null;
		if (joinResult == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.jsp");
		}
		return forward;
	}
}
