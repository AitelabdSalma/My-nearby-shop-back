package united.nearByShop.service.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import united.nearByShop.dto.AdministrateurDto;
import united.nearByShop.service.IAdminService;

@RestController
@RequestMapping("/api")
public class AdministrateurRestService {
	@Autowired
	private IAdminService adminService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	//
	@RequestMapping(value = "/administrateur", method = RequestMethod.GET)
	public AdministrateurDto getAdmin(@RequestParam(name="email") String email)
	{
		return adminService.checkEmail(email);
	}

	@RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
	public AdministrateurDto updateAdmin(@RequestBody AdministrateurDto admin) {
		if(admin.getMotDePasse() ==null)
		{
			admin.setMotDePasse(adminService.find(admin.getIdAdmin()).getMotDePasse());
		}
		else
		{
			admin.setMotDePasse(bCryptPasswordEncoder.encode(admin.getMotDePasse()));
		}
	
		return adminService.update(admin);
	}
}
