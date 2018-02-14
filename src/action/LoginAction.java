package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LoginCustomerservice;
import vo.ActionForward;
import vo.Customer;



public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		
		String email = request.getParameter("c_email");
		String pw = request.getParameter("c_pw");
		Customer loginOk = null;
		
		LoginCustomerservice loginCustomerservice = new LoginCustomerservice();
		loginOk = loginCustomerservice.login(email, pw);
		
		if(loginOk != null) {
			HttpSession session = request.getSession(); 
			forward = new ActionForward();
			session.setAttribute("email", email);
			session.setAttribute("pw", pw);
			session.setAttribute("name",loginOk.getC_name());
			forward.setPath("index.jsp");
			
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
