package united.nearByShop.service;

import java.util.Collection;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import united.nearByShop.bo.Administrateur;
import united.nearByShop.dao.IDAOAdmin;
import united.nearByShop.dto.AdministrateurDto;

import united.nearByShop.service.mapping.Mapping;

@Service
public class AdministrateurService implements IAdminService{
	@Autowired
	private IDAOAdmin dao;
	@Autowired
	private Mapping<AdministrateurDto,Administrateur> map;
	@Override
	public AdministrateurDto find(Long id) {
		// TODO Auto-generated method stub
		return  map.convertToDto(dao.find(id));
	}

	@Override
	public AdministrateurDto create(AdministrateurDto object) {
		// TODO Auto-generated method stub
		return  map.convertToDto(dao.create(map.convertToEntity(object)));
	}

	@Override
	public Collection<AdministrateurDto> retreive() {
		// TODO Auto-generated method stub
		Collection<AdministrateurDto> tmp=new Vector<>();
		for(Administrateur inf:dao.retreive())
		{
			AdministrateurDto dt=map.convertToDto(inf);
			tmp.add(dt);
		}
		return tmp;
	}

	@Override
	public AdministrateurDto update(AdministrateurDto object) {
		// TODO Auto-generated method stub
		return  map.convertToDto(dao.update(map.convertToEntity(object)));
	}

	@Override
	public void delete(AdministrateurDto object) {
		// TODO Auto-generated method stub
		dao.delete(map.convertToEntity(object));
	}


	@Override
	public Page<AdministrateurDto> chercherALL(String mc, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdministrateurDto checkEmail(String email) {
		// TODO Auto-generated method stub
		return map.convertToDto(dao.checkEmail(email));
	}

}
