package net.kzm.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzm.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
//	@Test
//	public void testAddCategory() {
//		category = new Category();
//		category.setName("Earphone");
//		category.setDescription("This is some description for Earphone");
//		category.setImageURL("CAT_5.png");
//		
//		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
//	}
	
//	@Test
//	public void testGetCategory() {
//		category = categoryDAO.get(2);
//		assertEquals("Successfully fetched a single category from the table !", "Laptop", category.getName());
//	}

//	@Test
//	public void testUpdateCategory() {
//		category = categoryDAO.get(2);
//		category.setImageURL("CAT_3.png");
//		assertEquals("Successfully updated a single category from the table !", true, categoryDAO.update(category));
//	}
//	
//	@Test
//	public void testDeleteCategory() {
//		category = categoryDAO.get(2);
//		assertEquals("Successfully deleted a single category from the table !", true, categoryDAO.delete(category));
//	}
	
//	@Test
//	public void testListCategory() {
//		category = categoryDAO.get(2);
//		assertEquals("Successfully fetch the list of category from the table!", 3, categoryDAO.list().size());
//	}
	
//	@Test
//	public void testCRUCategory() {
//		
//		
//	}
	
}












