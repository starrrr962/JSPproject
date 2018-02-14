package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ListCustomerService;
import vo.ActionForward;
import vo.Customer;

public class ListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		ActionForward forward = null;
		if(name==null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./login.jsp");
		}else if(!name.equals("admin")){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자가 아닙니다.')");
			out.println("location.href='./login.jsp';");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			ListCustomerService listCustomerService = new ListCustomerService();
			ArrayList<Customer> customerList = listCustomerService.getCustomerList();
			request.setAttribute("customerList", customerList);
			forward.setPath("./customerList.jsp");
		}
		return forward;
	}

}
