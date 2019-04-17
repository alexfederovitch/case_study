package com.homeinsurance.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.homeinsurance.DAO.PolicyDAO;
import com.homeinsurance.DAO.UserDAO;

import homeinsurance.model.Policy;
import homeinsurance.model.User;

@Controller
@SessionAttributes
public class HomeController {

	@RequestMapping("/admin")
	public String showAdminLoginPage(HttpSession session) {
		return "adminLoginPage";
	}
//        
//        @RequestMapping("/logout")
//        public String logout(HttpServletRequest request, HttpServletResponse response)
//        {
//            HttpSession session = request.getSession();
//            session.invalidate();
//            return "LoginPage";
//        }
//        
//        @RequestMapping(value = "/login", method = RequestMethod.POST)
//        public String loginUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException, SQLException
//        {
//            List<String> errorList;
//            HttpSession session = request.getSession();
//            
//            String userName = request.getParameter("userName");
//            String password = request.getParameter("password");
//            
//            UserBO u_bo = new UserBO();
//            User user = u_bo.getUserByLogin(userName, password);
//            if (user == null) {
//                errorList = new ArrayList<>();
//                errorList.add("Invalid Login");
//                request.setAttribute("errorList", errorList);
//                return "LoginPage";
//            } else {
//                if (password.equals(user.getPassword())) {
//                    session.setAttribute("currentUser", user);
//                    return "WelcomePage";
//                } else {
//                    errorList = new ArrayList<>();
//                    errorList.add("Invalid Login");
//                    request.setAttribute("errorList", errorList);
//                    return "LoginPage";
//                }
//            }
//        }
//        
//        @RequestMapping("/welcomePage")
//        public String welcomePage(HttpServletRequest request, HttpServletResponse response)
//        {
//            return "WelcomePage";
//        }

	@RequestMapping(value = "showAdminLoginPage", method = RequestMethod.GET)
	public String showAdminLoginPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/adminLoginPage.jsp");
		rd.forward(request, response);
		return "adminLoginPage";
	}
	
	@RequestMapping(value= {"/adminValidation"}, method= RequestMethod.POST)
	public ModelAndView adminValidation(@RequestParam("userName") String userName, @RequestParam("password") String password) throws ClassNotFoundException, IOException
	{
		
		UserDAO udao = new UserDAO();
		User user = null;
		ModelAndView model = null;
		try {
			 user = udao.getUserByName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(user==null || user.getAdminRole() == null) {
			//failed to find user
			model = new ModelAndView("adminLoginPage");
			model.addObject("message", "INCORRECT CREDENTIALS");
			return model;
		}
		else if(user.getUserName().equals(userName) && user.getPassword().equals(password) && user.getAdminRole().equals("admin"))
		{
			//passed
			model = new ModelAndView("adminControl");
		}
		else
		{
			//wrong password
			model = new ModelAndView("adminLoginPage");
			model.addObject("message", "INCORRECT CREDENTIALS");
			return model;
		}
		
		return model;
	}

//	@RequestMapping(value = "adminValidation", method = RequestMethod.POST)
//	public String adminValidation(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, ClassNotFoundException, SQLException {
//		HttpSession session = request.getSession();
//		List<String> errorList = new ArrayList<>();
//		String userName = request.getParameter("userName");
//		String password = request.getParameter("password");
//
//		if (userName == null || password == null) {
//			errorList.add("Please enter User Name and Password");
//			System.out.println("Username and password are empty");
//			errorList = new ArrayList<>();
//			errorList.add("Invalid Login");
//			request.setAttribute("errorList", errorList);
//			return "showAdminLoginPage";
//			
//		}
//		
//		System.out.println(userName);
//		System.out.println(password);
//
//		User user = new User();
//		UserDAO u_dao = new UserDAO();
//		u_dao.getUserByName(userName);
//		user.getUserName();
//		user.getAdminRole();
//		System.out.println(user.getUserName());
//		System.out.println(user.getAdminRole());
//		
//
//		if (errorList.isEmpty()) {
//			return "adminControl";
//		} else {
//			request.setAttribute("errorList", errorList);
//			return "showAdminLoginPage";
//		}
//
////		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/adminControl.jsp");
////		rd.forward(request, response);
////		return "adminControl";
//	}

	@RequestMapping(value = "/registerPage", method = RequestMethod.POST)
	public String registerUser(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		List<String> errorList = new ArrayList<>();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String adminRole = request.getParameter("adminRole");

		if (userName == null || password == null) {
			errorList.add("Please enter User Name and Password");
		}

		User user = new User(userName, password, adminRole);
		UserDAO u_dao = new UserDAO();

		if (errorList.isEmpty()) {
			int id = u_dao.insertUser(user);
			return "LoginPage";
		} else {
			request.setAttribute("errorList", errorList);
			return "RegistrationPage";
		}
	}
	
	@RequestMapping(value= {"/finduser"}, method= RequestMethod.POST)
	public ModelAndView findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException, IOException
	{
		System.out.println("Find User Method");
		HttpSession session = request.getSession();
		
		Policy policy = (Policy) session.getAttribute("currentPolicy");
		UserDAO udao = new UserDAO();
		PolicyDAO pdao = new PolicyDAO();
		User user = null;
//		List<Policy> policies = new ArrayList<Policy>();
		ModelAndView model = new ModelAndView("adminControl");
		try {
			
//			user = udao.getUserByName(userName);
//			System.out.println("The userName is " + userName);
//			System.out.println("This userID is " + user.getUserId());
//			System.out.println("The userID for this query is " + userId);
//			policies = pdao.getPolicyByUserId(user);
//			policies = pdao.getPolicyByUserId(2);
//			pdao.getPolicyByUserId(user);
			
			System.out.println(pdao.getPolicyByUserId(user));
		} catch (SQLException | NullPointerException e) {
			model.addObject("message", "User does not exist");
			return model;
		}
		if(user!=null)
		{
			model = new ModelAndView("showUserPolicies");
			model.addObject("policies", policy);
		}
		return model;
	}

	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public String showAboutUs(HttpServletRequest request, HttpServletResponse response) {
		return "AboutUsPage";
	}

	@RequestMapping(value = "/contactUs", method = RequestMethod.GET)
	public String showContactUs(HttpServletRequest request, HttpServletResponse response) {
		return "ContactPage";
	}

	@RequestMapping(value = "/contactUs", method = RequestMethod.POST)
	public String contactUs(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("ContactPage", true);

		return "WelcomePage";
	}
}