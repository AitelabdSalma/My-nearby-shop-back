package united.nearByShop.service.Rest;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import united.nearByShop.dto.ShopDto;
import united.nearByShop.service.IService;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ShopService {
	@Autowired
	private IService<ShopDto> shopService;
	

	
	@RequestMapping(value = "/allShop", method = RequestMethod.GET)
	public Collection<ShopDto> getAllShops() {
		return shopService.retreive();
	}
	
	
	@RequestMapping(value = "/updateShop", method = RequestMethod.POST)
	public ShopDto updateShop(@RequestBody ShopDto args)
	{	System.out.println(args);
	 
		/***********Save Shop ***************/
		args=shopService.update(args);
		
	
	 return args;

	}
	
	
	
}
