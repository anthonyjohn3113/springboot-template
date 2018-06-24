package project.template.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetItemRequest {
    @JsonProperty("name")
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
