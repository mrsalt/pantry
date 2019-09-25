package com.pantry;

import com.pantry.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller    // This means that this class is a Controller
@RequestMapping(path="") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductLocationRepository productLocationRepository;

	@PostMapping(path="/add-user") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/users")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@PostMapping(path="/add-location") // Map ONLY POST Requests
	public @ResponseBody String addNewLocation (@RequestParam String name
			, @RequestParam Integer parentId) {
		Location l = new Location();
		l.setName(name);
		l.setParentId(parentId);
		locationRepository.save(l);
		return "Saved";
	}

	@GetMapping(path="/locations")
	public @ResponseBody Iterable<Location> getAllLocations() {
		// This returns a JSON or XML with the users
		return locationRepository.findAll();
	}

	@PostMapping(path="/add-product") // Map ONLY POST Requests
	public @ResponseBody String addNewProduct (@RequestParam String name
			, @RequestParam String upcCode) {
		Product p = new Product();
		p.setName(name);
		p.setUpcCode(upcCode);
		productRepository.save(p);
		return "Saved";
	}

	@GetMapping(path="/products")
	public @ResponseBody Iterable<Product> getAllProducts() {
		// This returns a JSON or XML with the users
		return productRepository.findAll();
	}

	@PostMapping(path="/add-inventory") // Map ONLY POST Requests
	public @ResponseBody String addNewProduct (@RequestParam Integer locationId
		, @RequestParam Integer productId, @RequestParam Integer quantity
		, @RequestParam Integer size, @RequestParam SizeUnit su)
	{
		ProductLocation inventory = new ProductLocation();
		inventory.setLocationId(locationId);
		inventory.setProductId(productId);
		inventory.setAddedDate(new Date(System.currentTimeMillis()));
		inventory.setQuantity(quantity);
		inventory.setSize(size);
		inventory.setSizeUnit(su);
		productLocationRepository.save(inventory);
		return "Saved";
	}

	@GetMapping(path="/inventory")
	public @ResponseBody Iterable<ProductLocation> getInventory() {
		// This returns a JSON or XML with the users
		return productLocationRepository.findAll();
	}


}