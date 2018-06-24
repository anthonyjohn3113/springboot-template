package project.template.rest;

import org.springframework.stereotype.Indexed;

import project.template.dto.response.*;

@Indexed
public interface RestApi {
	public GetItemResponse getItemByName(String name);
}
