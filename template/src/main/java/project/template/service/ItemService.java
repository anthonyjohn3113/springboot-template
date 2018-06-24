package project.template.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.template.dto.model.Item;
import project.template.repository.ItemRepository;

@Service
public class ItemService implements ItemServiceInterface{
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item getItemById(long itemId) {
		Item obj = itemRepository.findById(itemId).get();
		return obj;
	}
	
	@Override
	public List<Item> getItemsByName(String name) {
		List<Item> list = itemRepository.findByName(name);
		return list;
	}

	@Override
	public List<Item> getAllItems() {
		List<Item> list = new ArrayList<>();
		itemRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public synchronized boolean addArticle(Item item) {
		List<Item> list = itemRepository.findByName(item.getName());
		if (list.size() > 0) {
			return false;
		} else {
			itemRepository.save(item);
			return true;
		}
	}

	@Override
	public void updateItem(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void deleteItem(int itemId) {
		itemRepository.delete(getItemById(itemId));
	}
}
