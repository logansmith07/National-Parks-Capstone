package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.park.JdbcParkDao;
import com.techelevator.npgeek.model.park.ParkDao;
import com.techelevator.npgeek.model.weather.JdbcWeatherDao;
import com.techelevator.npgeek.model.weather.Weather;
import com.techelevator.npgeek.model.weather.WeatherDao;

@Controller
@SessionAttributes("celsius")
public class ParkController {
	@Autowired
	private ParkDao parkDao;
	
	@Autowired
	private WeatherDao weatherDao;
	
	@RequestMapping("/homepage")
	public String displayHomePage(HttpServletRequest request) {
		request.setAttribute("parks", parkDao.getAllParks());
		return "homepage";
	}
	
	@RequestMapping("/parkDetail")
	public String displayPark(HttpServletRequest request, ModelMap map) {
		if (! map.containsAttribute("celsius")) {
			map.addAttribute("celsius", "false");
		}
		String parkCode = request.getParameter("parkCode").toUpperCase();
		List<Weather> stuff = weatherDao.getWeatherByParkCode(parkCode);
		request.setAttribute("park", parkDao.getParkByParkCode(parkCode));
		request.setAttribute("weathers", weatherDao.getWeatherByParkCode(parkCode));
		return "parkDetail";
	}
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.POST)
	public String displayParkAndWeathers(HttpServletRequest request, ModelMap map) {
		String parkCode = request.getParameter("parkCode").toUpperCase();
		request.setAttribute("park", parkDao.getParkByParkCode(parkCode));
		List<Weather> stuff = weatherDao.getWeatherByParkCode(parkCode);
		request.setAttribute("weathers", weatherDao.getWeatherByParkCode(parkCode));
		map.addAttribute("celsius", request.getParameter("celsius"));
		return "parkDetail";
	}
	
	
}


//@Controller
//@SessionAttributes({"1", "2", "3", "4"})
//public class HomeController {
//	
//	@Autowired
//	private JdbcForumDao forumDao;
//	
//	@Autowired
//	private JdbcProductDao productDao;
//
//	@RequestMapping("/")
//	public String displayHomePage() {
//		return "homePage";
//	}
//
//	@RequestMapping("/alienAgeInput")
//	public String displayAlienAgeInputPage() {
//		return "alienAgeInput";
//	}
//	
//	@RequestMapping("/alienAgeOutput")
//	public String displayAlienAgeOutputPage(HttpServletRequest request) {
//		double age = Double.parseDouble(request.getParameter("age"));
//		String planet = request.getParameter("planet");
//		BigDecimal ageNew = new BigDecimal(0);
//		
//		switch (planet) {
//		case "mercury": ageNew =  new BigDecimal( age * (365 / 87.96));
//						break;
//		case "venus": ageNew = new BigDecimal(age * (365 / 224.68));
//					break;
//		case "mars": ageNew = new BigDecimal(age * (365 / 686.98));
//					break;
//		case "jupiter": ageNew = new BigDecimal (age / 11.862);
//					break;
//		case "saturn": ageNew = new BigDecimal (age / 29.456);
//					break;
//		case "uranus": ageNew = new BigDecimal(age / 84.07);
//					break;
//		case "neptune": ageNew = new BigDecimal (age / 164.01);
//					break;
//		}
//		
//		ageNew = ageNew.setScale(2, RoundingMode.CEILING);
//		
//		request.setAttribute("ageNew", ageNew);
//		request.setAttribute("ageOld", age);
//		request.setAttribute("planet", planet);
//		
//		return "alienAgeOutput";
//	}
//	
//	@RequestMapping("/alienWeightInput")
//	public String displayAlienWeightInputPage() {
//		return "alienWeightInput";
//	}
//	
//	@RequestMapping("/alienWeightOutput")
//	public String displayAlienWeightOutputPage(HttpServletRequest request) {
//		double weight = Double.parseDouble(request.getParameter("weight"));
//		String planet = request.getParameter("planet");
//		BigDecimal weightNew = new BigDecimal(0);
//		
//		switch (planet) {
//		case "mercury": weightNew =  new BigDecimal( weight * .37);
//					break;
//		case "venus": weightNew = new BigDecimal(weight * .9);
//					break;
//		case "mars": weightNew = new BigDecimal(weight * .38);
//					break;
//		case "jupiter": weightNew = new BigDecimal (weight * 2.65);
//					break;
//		case "saturn": weightNew = new BigDecimal (weight * 1.13);
//					break;
//		case "uranus": weightNew = new BigDecimal(weight * 1.09);
//					break;
//		case "neptune": weightNew = new BigDecimal (weight * 1.43);
//					break;
//		}
//		
//		request.setAttribute("weightNew", weightNew);
//		request.setAttribute("weightOld", weight);
//		request.setAttribute("planet", planet);
//		
//		return "alienWeightOutput";
//	}
//
//	
//	
//	@RequestMapping("/alienTravelInput")
//	public String displayAlienTravelInputPage() {
//		return "alienTravelInput";
//	}
//	
//	
//	
//	@RequestMapping("/alienTravelOutput")
//	public String displayAlienTravelOutputPage(HttpServletRequest request) {
//		double age = Double.parseDouble(request.getParameter("age"));
//		String planet = request.getParameter("planet");
//		String mode = request.getParameter("mode");
//	    long distance = 0;
//	    long speed = 0;
//		BigDecimal ageNew = new BigDecimal(0);
//		BigDecimal travelTime = new BigDecimal(0);
//		
//		switch (planet) {
//		case "mercury": distance = 56974146;
//					break;
//		case "venus": distance = 25724767;
//					break;
//		case "mars": distance = 48678219;
//					break;
//		case "jupiter": distance = 390674710;
//					break;
//		case "saturn": distance = 792248270;
//					break;
//		case "uranus": distance = 1692662530;
//					break;
//		case "neptune": distance = Long.parseLong("2703959960");
//				break;
//		}
//		
//		switch (mode) {
//		case "walking": speed = 3;
//					break;
//		case "car": speed = 100;
//					break;
//		case "bullet train": speed = 200;
//					break;
//		case "boeing 747": speed = 570;
//					break;
//		case "concorde": speed = 1350;
//					break;
//		}
//		
//		
//		travelTime = new BigDecimal((distance / speed) / 24 / 365).setScale(2, RoundingMode.CEILING);
//		ageNew = travelTime.add(new BigDecimal(age));
//		mode = mode.toLowerCase();
//		request.setAttribute("ageOld", age);
//		request.setAttribute("ageNew", ageNew);
//		request.setAttribute("mode", mode);
//		request.setAttribute("travelTime", travelTime);
//		request.setAttribute("planet", planet);
//		return "alienTravelOutput";
//	}
//	
//
//	@RequestMapping(path="/addForumPost")
//	public String addForumPost(HttpServletRequest request) {
//		return "addForumPost";
//	}
//	
//	@RequestMapping(path="/viewPosts", method=RequestMethod.POST)
//	public String addViewPosts(ForumPost post, HttpServletRequest request) {
//
//		post.setDatePosted(LocalDateTime.now());
//		
//		forumDao.save(post);
//		
//		
//		request.setAttribute("postHistory", forumDao.getAllPosts());	
//		return "viewPosts";
//	}	
//	
//	
//	
//	@RequestMapping(path="/productList")
//	public String showProductList(HttpServletRequest request) {
//		request.setAttribute("products", productDao.getAllProducts());
//		return "productList";
//	}	
//	
//	
//	
//	@RequestMapping(path="/productDetail")
//	public String showProductDetail(HttpServletRequest request) {
//		String productId = request.getParameter("productId");
//		request.setAttribute("product", productDao.getProductById(Long.parseLong(productId)));
//		return "productDetail";
//	}
//	
//	
//	
//	
//	@RequestMapping(path="/cart", method=RequestMethod.POST)
//	public String processProductDetail(HttpServletRequest request, ModelMap map) {
//		//grab id or product
//		//throw product into shopping cart
//		//throw shopping cart into modelMap
//		int quantity = Integer.parseInt(request.getParameter("quantity"));
//		String productId = request.getParameter("productId");
//		
//		if (map.containsKey(productId)) {
//			int quant = (int) map.get(productId);
//			quant += quantity;
//			map.put(productId, quant);
//		} else {
//			map.put(productId, quantity);
//		}
//		
//		
//		
//		return "redirect:/cart";
//	}
//	
//	
//	
//	@RequestMapping(path="/cart")
//	public String showProductDetail(HttpServletRequest request, ModelMap map) {
//		ArrayList<Product> products = new ArrayList<Product>();
//		ArrayList<Integer> quants = new ArrayList<Integer>();
//		ArrayList<DollarAmount> totals = new ArrayList<DollarAmount>();
//		Iterator it = map.entrySet().iterator();
//		
//	    while (it.hasNext()) {
//	    	
//	        Map.Entry pair = (Map.Entry)it.next();
//	        Product myProd = productDao.getProductById(Long.parseLong((String) pair.getKey()));
//	       products.add(myProd);
//	       Integer quant = (Integer) map.get(String.valueOf(myProd.getId()));
//	       quants.add(quant);
//	       
//	       DollarAmount cash = myProd.getPrice();
//	       cash = cash.multiply(quant);
//	       totals.add(cash);
//	       
//	        it.remove();
//	    }
//	    
//	    
//	    DollarAmount total = new DollarAmount(0);
//	    for (int j = 0; j < totals.size(); j++) {
//	    	total = total.plus(totals.get(j));
//	    }
//	    
//		request.setAttribute("products", products);
//		request.setAttribute("quants", quants);
//		request.setAttribute("totals", totals);
//		request.setAttribute("total", total);
//		
//		return "cart";
//	}
//	
//
//}
