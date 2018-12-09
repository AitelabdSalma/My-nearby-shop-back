package united.nearByShop.service.mapping;

import org.springframework.stereotype.Component;

import united.nearByShop.bo.Administrateur;
import united.nearByShop.dto.AdministrateurDto;

@Component
public class AdministrateurMapping implements Mapping<AdministrateurDto,Administrateur>{

	@Override
	public AdministrateurDto convertToDto(Administrateur en) {
		// TODO Auto-generated method stub
		AdministrateurDto ad=new AdministrateurDto();
		ad.setIdAdmin(en.getIdAdmin());
		ad.setNom(en.getNom());
		ad.setPrenom(en.getPrenom());
		ad.setEmail(en.getEmail());
		ad.setMotDePasse(en.getMotDePasse());
		
		return ad;
	}

	@Override
	public Administrateur convertToEntity(AdministrateurDto dto) {
		// TODO Auto-generated method stub
		Administrateur ad=new Administrateur();
		if(dto.getIdAdmin()!=null)
		ad.setIdAdmin(dto.getIdAdmin());
		ad.setNom(dto.getNom());
		ad.setPrenom(dto.getPrenom());
		ad.setEmail(dto.getEmail());
		ad.setMotDePasse(dto.getMotDePasse());
		return ad;
	}
	


	
}
