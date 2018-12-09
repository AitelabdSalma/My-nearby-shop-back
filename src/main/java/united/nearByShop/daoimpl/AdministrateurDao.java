package united.nearByShop.daoimpl;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import united.nearByShop.bo.Administrateur;
import united.nearByShop.dao.AdministrateurRepository;

import united.nearByShop.dao.IDAOAdmin;
@Repository
public class AdministrateurDao implements IDAOAdmin{
	@Autowired
	private AdministrateurRepository administrateurRepository;
	
	
	public Administrateur create(Administrateur object) {
		// TODO Auto-generated method stub
		return administrateurRepository.save(object);	
	}

	
	public Collection<Administrateur> retreive() {
		// TODO Auto-generated method stub
		return administrateurRepository.findAll();
	}

	
	public Administrateur update(Administrateur object) {
		// TODO Auto-generated method stub
		
		return administrateurRepository.save(object);
	}

	
	public void delete(Administrateur object) {
		// TODO Auto-generated method stub
		administrateurRepository.delete(object);
		
	}

	
	public Administrateur find(Long id) {
		// TODO Auto-generated method stub
		return administrateurRepository.findOne(id);
	}

	public AdministrateurRepository getAdministrateurRepository() {
		return administrateurRepository;
	}

	public void setAdministrateurRepository(AdministrateurRepository administrateurRepository) {
		this.administrateurRepository = administrateurRepository;
	}

	

	@Override
	public Administrateur checkEmail(String email) {
		// TODO Auto-generated method stub
		return administrateurRepository.checkEmail(email);
	}

	@Override
	public Page<Administrateur> chercherALL(String mc, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	




	
}
