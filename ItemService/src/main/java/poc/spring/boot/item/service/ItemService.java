package poc.spring.boot.item.service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Base64;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import poc.spring.boot.item.dao.ItemDao;
import poc.spring.boot.item.model.Item;
import poc.spring.boot.item.model.Product;

/**
 * @author 188152
 *
 */
@Service
public class ItemService {

	private static final Logger LOGGER = Logger.getLogger(ItemService.class);
	
	@Value("${productServiceUserName}")
	private String productServiceUserName;
	
	@Value("${productServicePassword}")
	private String productServicePassword;
	
	@Value("${encodedProductUsernamePassword}")
	private String encodedProductUsernamePassword;
	
	@Value("${productByIdURI}")
	private String productByIdURI;
	
	@Autowired
	private ItemDao itemDao;

	@Autowired
	RestTemplate restTemplate;

	public Item findById(int id) {
		LOGGER.debug("findById...");
		
		Item item = itemDao.findById(id);
		
		Product product = getProductById(item.getProductId());
		
		item.setProduct(product);
		
		LOGGER.debug("findById:Item:"+item);
		
		return item; 
		
	}
	
	public List<Item> findByInvoiceId(int invoiceId) {
		List<Item> items = itemDao.findByInvoiceId(invoiceId);
		
		for(Item item: items) {
			Product product = getProductById(item.getProductId());
			item.setProduct(product);
		}
		
		return items;
	}
	
	private Product getProductById(int productId) {
		String url = MessageFormat.format(productByIdURI, productId);
		HttpEntity<String> request = new HttpEntity<String>(createHeaders(encodedProductUsernamePassword));
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
		String productJSONString = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		Product product = new Product();
		try {
			TypeReference<Product> mapType = new TypeReference<Product>() {};
			product = mapper.readValue(productJSONString, mapType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGGER.debug("findById:Product:"+product);
		return product;
	}
	
	HttpHeaders createHeaders(String username, String password) {
		LOGGER.debug("createHeaders:using plain username and password...");
		HttpHeaders httpHeaders =  new HttpHeaders();
		String auth = username + ":" + password;
		LOGGER.debug("createHeaders:auth:"+auth);
		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
		LOGGER.debug("findById:Encoded String:"+new String(encodedAuth));
		String authHeader = "Basic " + new String(encodedAuth);
		httpHeaders.set("Authorization", authHeader);
		return httpHeaders;
	}
	
	HttpHeaders createHeaders(String encodedString) {
		LOGGER.debug("createHeaders:using encoded username and password...");
		HttpHeaders httpHeaders =  new HttpHeaders();
		String authHeader = "Basic " + new String(encodedString);
		httpHeaders.set("Authorization", authHeader);
		return httpHeaders;
	}

	public List<Item> findAll() {
		return itemDao.findAll();
	}
}
