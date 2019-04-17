package com.homeinsurance.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.homeinsurance.DAO.HomeownerDAO;
import com.homeinsurance.DAO.LocationDAO;
import com.homeinsurance.DAO.PolicyDAO;
import com.homeinsurance.DAO.PropertyDAO;
import com.homeinsurance.DAO.QuoteDAO;
import com.homeinsurance.DAO.UserDAO;

import homeinsurance.model.Homeowner;
import homeinsurance.model.Location;
import homeinsurance.model.Policy;
import homeinsurance.model.Property;
import homeinsurance.model.Quote;
import homeinsurance.model.User;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> errorList;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("doGet method.");
		try {
			switch (action) {
			case "/showLogin":
				System.out.println("showLogin.");
				showLoginPage(request, response);
				break;
			case "/login":
				loginUser(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			case "/showRegistrationPage":
				showRegistrationPage(request, response);
				break;
			case "/registerUser":
				registerUser(request, response);
				break;
			case "/showWelcomePage":
				showWelcomePage(request, response);
				break;
			case "/showEditPage":
				showEditPage(request, response);
				break;
			case "/getQuote":
				getQuote(request, response);
				break;
			case "/registerLocation":
				registerLocation(request, response);
				break;
			case "/property":
				property(request, response);
				break;
			case "/registerProperty":
				registerProperty(request, response);
				break;
			case "/retrieveQuote":
				retrieveQuote(request, response);
				break;
			case "/editUser":
				editUser(request, response);
				break;
			case "/deleteUser":
				deleteUser(request, response);
				break;
			case "/homeowner":
				homeowner(request, response);
				break;
			case "/registerHomeowner":
				registerHomeowner(request, response);
				break;
			case "/coverageDetails":
				coverageDetails(request, response);
				break;
			case "/quoteSummary":
				quoteSummary(request, response);
				break;
			case "/buyPolicy":
				buyPolicy(request, response);
				break;
			case "/showBuyPolicy":
				showBuyPolicy(request, response);
				break;
			default:
				showLoginPage(request, response);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void showBuyPolicy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Show Buy Policy method.");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/buyPolicy.jsp");
		rd.forward(request, response);
		
	}

	private void buyPolicy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Buy Policy method.");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentUser");
		Location location = (Location) session.getAttribute("currentLocation");
		Property property = (Property) session.getAttribute("currentProperty");
		Quote quote = (Quote) session.getAttribute("currentQuote");
		Homeowner homeowner = (Homeowner) session.getAttribute("currentHomeowner");

		Policy policy = new Policy();
		PolicyDAO policyDAO = new PolicyDAO();
		
		//Create Policy ID
		String qID = Integer.toString(quote.getQuoteId());
		System.out.println("qID is " + qID);
//		int r = (Integer) null;
//		r = new Random().nextInt((9 - 1) + 1) + 1;
//		System.out.println("Random r is " + r);
//		String id2 = Integer.toString(r);
//		String pID = qID + id2;
//		int polId = Integer.parseInt(pID);
		
		//Format Effective Date and End Date
		int year = 0;
		int month = 0;
		int day = 0;

		String effDate = request.getParameter("policyStart");
		System.out.println("This is the date input " + effDate);
		String[] values = effDate.split("-");
		year = Integer.parseInt(values[0]);
		System.out.println(values[0]);
		month = Integer.parseInt(values[1]) - 1;
		System.out.println(values[1]);
		day = Integer.parseInt(values[2]);
		System.out.println(values[2]);

		Date effectiveDate = new Date(year, month, day);
		
		Date endDate = new Date(year +1, month, day);
		
		policy.setPolicyId(quote.getQuoteId() + 11);
		System.out.println("Policy ID " + policy.getPolicyId());
		policy.setQuoteId(quote.getQuoteId());
		policy.setUserId(user.getUserId());
		policy.setEffectiveDate(effectiveDate);
		policy.setEndDate(endDate);
		policy.setTerm(1);
		policy.setPolicyStatus("ACTIVE");
		
		policyDAO.createPolicy(policy);
		
		policy.setPolicyId(quote.getQuoteId() + 11);
		session.setAttribute("currentPolicy", policy);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/buyPolicy.jsp");
//		rd.forward(request, response);
		response.sendRedirect("showWelcomePage");
	}

	private void quoteSummary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Coverage Details method.");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentUser");
		Location location = (Location) session.getAttribute("currentLocation");
		Property property = (Property) session.getAttribute("currentProperty");
		Quote quote = (Quote) session.getAttribute("currentQuote");
		Homeowner homeowner = (Homeowner) session.getAttribute("currentHomeowner");
		
		//Set boolean for Retired Status
		String bool1 = homeowner.isRetiredStatus();
		String status = bool1.contains("0") ? "No" : "Yes";
		homeowner.setRetiredStatus(status);
		System.out.println(status);
		session.setAttribute("currentHomeowner", homeowner);
		//Set boolean for Pool
		Integer bool2 = property.isPool();
		System.out.println("bool2 " + bool2);
		System.out.println("Property value " + property.isPool());
		String pool = bool2.equals(0) ? "No" : "Yes";
		property.setHasPool(pool);
		System.out.println("Has a pool " + pool);
		
		System.out.println("Date of Birth " + homeowner.getDob());
		
		
		session.setAttribute("currentProperty", property);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/quoteSummary.jsp");
		rd.forward(request, response);
	}

	private void coverageDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Coverage Details method.");
		HttpSession session = request.getSession();
		Location location = (Location) session.getAttribute("currentLocation");
		Property property = (Property) session.getAttribute("currentProperty");
		Double marketValue = (double) property.getMarketValue();
		System.out.println("Market Value" + marketValue);
		String residenceType = location.getResidenceType();
		System.out.println("Residence Type " + residenceType);
		
		
		int sqFootage = property.getSquareFootage();
		int yearBuilt = property.getYearBuilt();

		double monthlyPremium = (5 * (marketValue / 1000)) / 12;

		if (residenceType.equals("single_family"))
			monthlyPremium = monthlyPremium * 1.05f;
		if (residenceType.equals("condo") || residenceType.equals("duplex") || residenceType.equals("apartment"))
			monthlyPremium = monthlyPremium * 1.06f;
		if (residenceType.equals("townhouse") || residenceType.equals("rowhouse"))
			monthlyPremium = monthlyPremium * 1.07f;

		double dwellingCoverage = sqFootage * 120.00f;

		if ((Year.now().getValue() - yearBuilt) <= 5)
			dwellingCoverage = dwellingCoverage * 0.90f;
		if ((Year.now().getValue() - yearBuilt) > 5 || (Year.now().getValue() - yearBuilt) <= 10)
			dwellingCoverage = dwellingCoverage * 0.80f;
		if ((Year.now().getValue() - yearBuilt) > 10 || (Year.now().getValue() - yearBuilt) <= 20)
			dwellingCoverage = dwellingCoverage * 0.70f;
		if ((Year.now().getValue() - yearBuilt) > 20)
			dwellingCoverage = dwellingCoverage * 0.50f;

		dwellingCoverage = 0.50f * marketValue + dwellingCoverage;

		double detachedStructures = dwellingCoverage * 0.10f;

		double personalProperty = dwellingCoverage * 0.60f;
		double livingExpenses = dwellingCoverage * 0.20f;
		float medicalExpenses = 5000.00f;
		double deductible = marketValue * 0.01f;

		Quote quote = new Quote();
		QuoteDAO quoteDAO = new QuoteDAO();
		quote.setLocationId(location.getLocationId());
		float mp = (float) monthlyPremium;
		quote.setMonthlyPremium(mp);
		quote.setDwellingCoverage((float) dwellingCoverage);
		quote.setDetatchedStructures((float) detachedStructures);
		quote.setPersonalProperty((float) personalProperty);
		quote.setAddLivingExp((float) livingExpenses);
		quote.setMedicalExpenses(medicalExpenses);
		quote.setDeductible((float) deductible);

		int quoteID = quoteDAO.createQuote(quote);
		System.out.println("Quote ID " + quoteID);
		quote.setQuoteId(quoteID);
		session.setAttribute("currentQuote", quote);

		// response.sendRedirect("CoveragePage");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/CoverageDetails.jsp");
		rd.forward(request, response);

	}

	private void registerProperty(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("registerProperty method.");

		HttpSession session = request.getSession();
		System.out.println("Session Started");
		User user = (User) session.getAttribute("currentUser");
		Location location = (Location) session.getAttribute("currentLocation");
		session.setAttribute("currentUser", user);
//		session.setAttribute("currentLocation", location);

		Integer locationId = location.getLocationId();
		System.out.println("Location ID " + locationId);
		String marketValue = request.getParameter("marketValue");
		System.out.println("Market Value " + marketValue);
		String yearBuilt = request.getParameter("yearBuilt");
		System.out.println("Year Built " + yearBuilt);
		String squareFootage = request.getParameter("squareFootage");
		System.out.println("Square Footage " + squareFootage);
		String dwellingType = request.getParameter("dwellingType");
		System.out.println("Dwelling Type " + dwellingType);
		String roofMaterial = request.getParameter("roofMaterial");
		System.out.println("Roof Material " + roofMaterial);
		String garage = request.getParameter("garage");
		System.out.println("Garage " + garage);
		String fullBath = request.getParameter("fullBath");
		System.out.println("Full Bath " + fullBath);
		String halfBath = request.getParameter("halfBath");
		System.out.println("Half Bath " + halfBath);
		String isPool = request.getParameter("isPool");
		System.out.println("Has Pool " + isPool);

		// Change String values to Float/Integer values
		float value = Float.parseFloat(marketValue);
		Integer year = Integer.parseInt(yearBuilt);
		Integer squareFoot = Integer.parseInt(squareFootage);
		Integer fullBaths = Integer.parseInt(fullBath);
		Integer halfBaths = Integer.parseInt(halfBath);
		Integer pool = Integer.parseInt(isPool);

		PropertyDAO p_dao = new PropertyDAO();
		Property property = new Property();
		property.setLocationId(locationId);
		property.setMarketValue(value);
		property.setYearBuilt(year);
		property.setSquareFootage(squareFoot);
		property.setDwellingType(dwellingType);
		property.setRoofMaterial(roofMaterial);
		property.setGarageType(garage);
		property.setFullBaths(fullBaths);
		property.setHalfBaths(halfBaths);
		property.setPool(pool);

		p_dao.registerProperty(property);

		session.setAttribute("currentProperty", property);
		response.sendRedirect("coverageDetails");
	}

	private void property(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("property method.");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Property.jsp");
		rd.forward(request, response);
	}

	private void homeowner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("homeowner method.");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Homeowner.jsp");
		rd.forward(request, response);
	}

	private void registerHomeowner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException, ParseException {
		// TODO Auto-generated method stub
		System.out.println("registerHomeowner method.");
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/getQuote.jsp");
//		rd.forward(request, response);

		HttpSession session = request.getSession();
		System.out.println("Session Started");
		User user = (User) session.getAttribute("currentUser");
		Location location = (Location) session.getAttribute("currentLocation");

		session.setAttribute("currentUser", user);
		session.setAttribute("currentLocation", location);
		Integer locationId = location.getLocationId();
		System.out.println("Location ID is " + locationId);

		int year = 0;
		int month = 0;
		int day = 0;

		String dob = request.getParameter("dob");
		System.out.println("This is the date input " + dob);
		String[] values = dob.split("-");
		year = Integer.parseInt(values[0]);
		System.out.println(values[0]);
		month = Integer.parseInt(values[1]) - 1;
		System.out.println(values[1]);
		day = Integer.parseInt(values[2]);
		System.out.println(values[2]);

		Date date = new Date(year, month, day);

		Integer userId = user.getUserId();
		System.out.println(userId);
		String firstName = request.getParameter("firstName");
		System.out.println(firstName);
		String lastName = request.getParameter("lastName");
		System.out.println(lastName);
		System.out.println(date);
		String retiredStatus = request.getParameter("isRetired");
		System.out.println(retiredStatus);
		String ssn = request.getParameter("ssn");
		System.out.println(ssn);
		String email = request.getParameter("email");
		System.out.println(email);

		HomeownerDAO h_dao = new HomeownerDAO();
		Homeowner homeowner = new Homeowner();
		homeowner.setUserId(userId);
		homeowner.setFirstName(firstName);
		homeowner.setLastName(lastName);
		homeowner.setDob(date);
		homeowner.setRetiredStatus(retiredStatus);
		homeowner.setSsn(ssn);
		homeowner.setEmail(email);
		h_dao.insertHomeowner(homeowner);

//		if (errorList.isEmpty()) {
//
////			int id = l_dao.insertLocation(location);
//			session.setAttribute("currentHomeOwner",homeowner);
////			System.out.println(id);
//			response.sendRedirect("showWelcomePage");
//
//		} else {
//
//			request.setAttribute("errorList", errorList);
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/HomeownerPage.jsp");
//			rd.forward(request, response);
//		}
		session.setAttribute("currentHomeowner", homeowner);
		response.sendRedirect("property");
	}

	private void retrieveQuote(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void getQuote(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("getQuote method.");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/getQuote.jsp");
		rd.forward(request, response);
	}

	private void registerLocation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("registerLocation method.");

		HttpSession session = request.getSession();
		System.out.println("Session Started");
		User user = (User) session.getAttribute("currentUser");
		session.setAttribute("currentUser", user);

		String residenceType = request.getParameter("residenceType");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String residenceUse = request.getParameter("residenceUse");

		Location location = new Location(user.getUserId(), residenceType, addressLine1, addressLine2, city, state, zip,
				residenceUse);
		LocationDAO l_dao = new LocationDAO();

		int lid = l_dao.insertLocation(location);
		location.setLocationId(lid);
		System.out.println("This ID # is " + lid);
		session.setAttribute("currentLocation", location);
		response.sendRedirect("homeowner");

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		UserDAO u_dao = new UserDAO();
		Boolean removeConfirm = u_dao.removeUser(id);
		System.out.println(removeConfirm);
		response.sendRedirect("showWelcomePage");
	}

	private void editUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ClassNotFoundException {
		int id = Integer.parseInt(request.getParameter("id"));

		/*
		 * The following lines demonstrate an alternative way to retrieve parameters
		 * from the JSP form using the request.getParameterMap method. This method
		 * returns a Map of type <String,String[]> so we must specify index[0] to
		 * retrieve the String inside the value (which is a String array) of each key.
		 */
		Map<String, String[]> paramMap = request.getParameterMap();

		User user = new User(id, paramMap.get("userName")[0], paramMap.get("password")[0],
				paramMap.get("adminRole")[0]);

		UserDAO u_dao = new UserDAO();
		System.out.println("User userName: " + user.getUserName());

		Boolean confirmUpdate = u_dao.updateUser(user);
		System.out.println(confirmUpdate);
		response.sendRedirect("showWelcomePage");
	}

	private void showEditPage(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, SQLException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		UserDAO u_dao = new UserDAO();
		User userToUpdate = u_dao.getUserById(id);
		request.setAttribute("userToUpdate", userToUpdate);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/EditPage.jsp");
		rd.forward(request, response);
	}

	private void showWelcomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		UserDAO u_dao = new UserDAO();
		List<User> users = u_dao.getAllUsers();
		request.setAttribute("users", users);
		System.out.println("showLoginPage method.");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Welcome.jsp");
		rd.forward(request, response);
	}

	private void registerUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ClassNotFoundException, SQLException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String adminRole = request.getParameter("adminRole");

		User user = new User(userName, password, adminRole);
		UserDAO u_dao = new UserDAO();

		int id = u_dao.insertUser(user);
		System.out.println(id);
		response.sendRedirect("showLogin");
	}

	private void showRegistrationPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Registration.jsp");
		rd.forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("showLogin");
	}

	private void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		UserDAO u_dao = new UserDAO();
		User user = u_dao.getUserByName(userName);
		if (user == null) {
			errorList = new ArrayList<>();
			errorList.add("Invalid Login");
			request.setAttribute("errorList", errorList);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp");
			rd.forward(request, response);
		} else {
			if (password.equals(user.getPassword())) {
				session.setAttribute("currentUser", user);
				response.sendRedirect("showWelcomePage");
			} else {
				errorList = new ArrayList<>();
				errorList.add("Invalid Login");
				request.setAttribute("errorList", errorList);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp");
				rd.forward(request, response);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void showLoginPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("showLoginPage method.");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp");
		rd.forward(request, response);
	}

}
