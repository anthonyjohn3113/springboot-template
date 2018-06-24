package project.template;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import project.template.dto.model.Item;
import project.template.dto.request.GetItemRequest;
import project.template.dto.response.GetItemResponse;
import project.template.rest.RestApi;
import project.template.service.ItemServiceInterface;

@RestController
@ComponentScan(basePackages={"project.template.dto.model"})
public class WebController {
	
	private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
	
    @Autowired
    private ItemServiceInterface itemService;
    // GET request
    @RequestMapping("/api/web/getItem")
    public List<Item> item(@RequestParam(value="name", defaultValue="first") String name) {
    	List<Item> items = itemService.getItemsByName(name);   	
        return items;
    }
    
    @Autowired
	private RestApi restApi;
    
    private ObjectMapper mapper = new ObjectMapper();
    
    // POST request
    @RequestMapping(value = "/api/rest/getItem", method = RequestMethod.POST, consumes = "application/json;charset=utf-8", produces = "application/json;charset=utf-8")
    @ResponseBody
	public GetItemResponse getItemByName(HttpServletRequest httprequest, @RequestBody String request){
		try{
			GetItemRequest obj = (GetItemRequest) mapper.readValue(request, GetItemRequest.class);
			return this.restApi.getItemByName(obj.getName());
		} catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

}