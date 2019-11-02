package com.qym.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.qym.pojo.User;
import com.qym.service.UserService;
import com.qym.service.Impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private UserService userService;
	@Override
	public void init() throws ServletException {
		ApplicationContext ac= (ApplicationContext) WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		userService=ac.getBean("userService",UserServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String code=req.getParameter("code");
		String codeSession=req.getSession().getAttribute("code").toString();
		if(codeSession.equals(code)){
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			User user1=null;
			user1=userService.login(user);
			if (user1!=null) {
				System.out.println("登陆成功了");
				resp.sendRedirect("main.jsp");
			}else {
				System.out.println("用户名错误");
				req.setAttribute("error", "用户名或者密码不正确");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		}else {
			System.out.println("验证码错误");
			req.setAttribute("error", "验证码错误");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		}
	}