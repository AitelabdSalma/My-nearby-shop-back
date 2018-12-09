package united.nearByShop.service.Rest.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import united.nearByShop.bo.Administrateur;
import united.nearByShop.dao.AdministrateurRepository;
/*/api/sign-up 
 * */
@RestController
@RequestMapping("/api")
public class UserController {
private AdministrateurRepository applicationUserRepository;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserController(AdministrateurRepository applicationUserRepository,
	        BCryptPasswordEncoder bCryptPasswordEncoder) {
	this.applicationUserRepository = applicationUserRepository;
	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	    @PostMapping("/sign-up")
	    public Administrateur signUp(@RequestBody Administrateur user) {
	    	System.out.println("user "+user.getEmail()+" Mot de passe "+user.getMotDePasse() );
	    	user.setMotDePasse(bCryptPasswordEncoder.encode(user.getMotDePasse()));
	    	Administrateur admin = applicationUserRepository.checkEmail(user.getEmail());
	       if(admin == null) return  applicationUserRepository.save(user);
	       return null;
	    }

	
}
