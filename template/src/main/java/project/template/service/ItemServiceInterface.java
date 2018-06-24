package project.template.service;

import java.util.List;

import project.template.dto.model.Item;

public interface ItemServiceInterface {

	Item getItemById(long itemId);
	List<Item> getItemsByName(String name);
	List<Item> getAllItems();
	boolean addArticle(Item item);
	void updateItem(Item item);
	void deleteItem(int itemId);
	
}
