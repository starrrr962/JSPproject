package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LoginCustomerservice;
import vo.ActionForward;
import vo.Customer;

public class ViewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		Customer customer = null;
		HttpSession session = request.getSession();
		
		String email = (String)session.getAttribute("email");
		String pw = (String)session.getAttribute("pw");
		
		LoginCustomerservice login = new LoginCustomerservice();
		customer = login.login(email, pw);
		
		if(customer != null) {
			forward = new ActionForward();
			session.setAttribute("customer", customer);
			forward.setPath("./customerview.jsp");
		}
		
		return forward;
	}

}
