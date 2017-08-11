package net.kzm.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzm.shoppingbackend.dao.ProductDAO;
import net.kzm.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzm.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
//	@Test
//	public void testCRUDProduct() {
//		product = new Product();
//		product.setName("Nexus 6P");
//		product.setBrand("Google");
//		product.setDescription("This is latest phone from Google");
//		product.setUnitPrice(43000);
//		product.setCategoryId(3);
//		product.setSupplierId(3);
//		
//		//adding product
//		assertEquals("Something went wrong in adding Product", true, productDAO.add(product));
//		
//		//updating product
//		product = productDAO.get(2);
//		product.setName("Samsung Galaxy s7");
//		assertEquals("Something went wrong in updating Product", true, productDAO.update(product));
//		
//		//deleting product
//		assertEquals("Something went wrong in deleting Product", true, productDAO.delete(product));
//		
//		//list
//		assertEquals("Something went wrong in fetching list of records", 8, productDAO.list().size());
//		
//	}
	
	
	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong in fetch active list of product", 4, productDAO.listActiveProducts().size());
	}
	 
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong in fetching list of product by category", 2, productDAO.listActiveProductsByCategory(3).size());
	}
	
	@Test
	public void testGetLatestActiveProducts() {
		assertEquals("Something went wrong in fetching list by count", 4, productDAO.getLatestActiveProducts(4).size());
	}
	
	
	
	
	
	
	
	

}













