package united.nearByShop.service;

import java.util.Collection;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import united.nearByShop.bo.Shop;
import united.nearByShop.dao.IDAO;
import united.nearByShop.dto.ShopDto;
import united.nearByShop.service.mapping.Mapping;

@Service
public class ShopService implements IService<ShopDto>{
	@Autowired
	private IDAO<Shop> dao;

	@Autowired
	private Mapping<ShopDto, Shop> mshop;
	@Override
	public ShopDto find(Long id) {
		// TODO Auto-generated method stub
		return mshop.convertToDto(dao.find(id));
	}

	@Override
	public ShopDto create(ShopDto object) {
		// TODO Auto-generated method stub
		return mshop.convertToDto(dao.create(mshop.convertToEntity(object)));
	}

	@Override
	public Collection<ShopDto> retreive() {
		Collection<ShopDto> tmp=new Vector<>();
		for(Shop inf:dao.retreive())
		{
			ShopDto dt=mshop.convertToDto(inf);
			tmp.add(dt);
		}
		return tmp;
		
	}

	@Override
	public ShopDto update(ShopDto object) {
		// TODO Auto-generated method stub
		return mshop.convertToDto(dao.update(mshop.convertToEntity(object)));
	}

	@Override
	public void delete(ShopDto object) {
		// TODO Auto-generated method stub
		dao.delete(mshop.convertToEntity(object));
	}

	@Override
	public Page<ShopDto> chercherALL(String mc, Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Shop> shops= dao.chercherALL("%"+mc+"%", pageable);
		return shops.map(resp->mshop.convertToDto(resp));
	}

	

}
