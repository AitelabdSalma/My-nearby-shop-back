package united.nearByShop.service.Rest.user;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import united.nearByShop.bo.Administrateur;
import united.nearByShop.dao.AdministrateurRepository;

import static java.util.Collections.emptyList;
@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
    private AdministrateurRepository applicationUserRepository;

    public UserDetailsServiceImpl(AdministrateurRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	    Administrateur applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getEmail(), applicationUser.getMotDePasse(), emptyList());
    }
	

}
