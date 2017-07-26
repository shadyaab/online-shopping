package net.kzn.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO ")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// adding first category
		category.setId(1);
		category.setName("Telivison");
		category.setDescription("This is some description for telivision");
		category.setImageURL("CAT_1.png");
		categories.add(category);

		// Adding second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some description for Mobile");
		category.setImageURL("CAT_2.png");
		categories.add(category);

		// Adding THird category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some description for Laptop");
		category.setImageURL("CAT_3.png");
		categories.add(category);

	}

	@Override
	public List<Category> list() {
		return categories;

	}

	@Override
	public Category get(int id) {
		for(Category category : categories ) {
			if(category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
