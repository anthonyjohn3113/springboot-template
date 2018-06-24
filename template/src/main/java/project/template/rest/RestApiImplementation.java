package project.template.rest;

import project.template.rest.RestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.template.dto.model.Item;
import project.template.dto.response.*;
import project.template.repository.ItemRepository;

@Service
public class RestApiImplementation implements RestApi{
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public GetItemResponse getItemByName(String name){
		GetItemResponse response = new GetItemResponse();
		List<Item> items = itemRepository.findByName(name);
		response.setItems(items);
		response.setStatus("OK");
		response.setDescription("Success");
		return response;
	};
}
