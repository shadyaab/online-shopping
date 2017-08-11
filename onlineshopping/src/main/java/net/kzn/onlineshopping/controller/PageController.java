package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dao.ProductDAO;
import net.kzm.shoppingbackend.dto.Category;
import net.kzm.shoppingbackend.dto.Product;
import net.kzn.onlineshopping.exception.ProductNotFoundException;

@Controller
public class PageController {
	
	@Autowired 
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/","/home"})
	public ModelAndView index() {
		 ModelAndView mv= new ModelAndView("page");
		 mv.addObject("title","Home");	
		 
		 //passing the list of category
		 mv.addObject("categories", categoryDAO.list());
		 
		 mv.addObject("userClickHome", true);
		 return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		 ModelAndView mv= new ModelAndView("page");
		 mv.addObject("title","About Us");
		 mv.addObject("userClickAbout", true);
		 return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		 ModelAndView mv= new ModelAndView("page");
		 mv.addObject("title","Contact Us");
		 mv.addObject("userClickContact", true);
		 return mv;
	}
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		 ModelAndView mv= new ModelAndView("page");
		 
		 mv.addObject("title", "All Products");
		 
		 //passing all category
		 mv.addObject("categories", categoryDAO.list());
		 
		 mv.addObject("userClickAllProducts", true);
		 return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		 ModelAndView mv= new ModelAndView("page");
		 
		 //CategoryDAO to fetch single category
		 Category category = null;
		 category = categoryDAO.get(id);
		 
		 mv.addObject("title", category.getName());
		 
		//passing all category
		 mv.addObject("categories", categoryDAO.list());
		 
		 //passing single category
		 mv.addObject("category", category);
		 
		 mv.addObject("userClickCategoryProducts", true);
		 return mv;
	}
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id") int productId) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(productId);
		
		if(product == null) {
			throw new ProductNotFoundException();
		}
		
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title",product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}
	
	
	
	
	
	
	
	
}








