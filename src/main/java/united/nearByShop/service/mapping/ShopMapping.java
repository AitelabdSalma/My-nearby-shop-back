package united.nearByShop.service.mapping;


import org.springframework.stereotype.Component;
import united.nearByShop.bo.Shop;
import united.nearByShop.dto.ShopDto;

@Component
public class ShopMapping implements Mapping<ShopDto,Shop>{
	 

	@Override
	public ShopDto convertToDto(Shop shop) {
		ShopDto shopDto= new ShopDto();
		
		shopDto.setIdShop(shop.getIdShop());
		shopDto.setShopName(shop.getShopName());
		shopDto.setDistance(shop.getDistance());
		shopDto.setLiked(shop.getLiked());
		shopDto.setDismissed(shop.getDismissed());
		shopDto.setDismissTime(shop.getDismissTime());
		return shopDto;
	}



	@Override
	public Shop convertToEntity(ShopDto dto) {
		// TODO Auto-generated method stub
		
		
		Shop shop= new Shop();
		if(dto.getIdShop()!=null)
		shop.setIdShop(dto.getIdShop());
		shop.setShopName(dto.getShopName());
		shop.setDistance(dto.getDistance());
		shop.setLiked(dto.isLiked());
		shop.setDismissed(dto.isDismissed());
		shop.setDismissTime(dto.getDismissTime());
		return shop;
	}

}
