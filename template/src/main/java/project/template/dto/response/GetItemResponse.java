package project.template.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import project.template.dto.model.Item;

public class GetItemResponse {
	
	@JsonProperty("status")
	private String status;
	@JsonProperty("description")
	private String description;
	@JsonProperty("item")
	private List<Item> items;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	

}
