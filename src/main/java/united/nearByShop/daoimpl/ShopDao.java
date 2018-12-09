package united.nearByShop.daoimpl;

	import java.util.Collection;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.domain.Page;
	import org.springframework.data.domain.Pageable;
	import org.springframework.stereotype.Repository;

	import united.nearByShop.bo.Shop;
	import united.nearByShop.dao.IDAO;
	import united.nearByShop.dao.ShopRepository;


	@Repository
	public class ShopDao implements IDAO<Shop>{
		@Autowired
		private ShopRepository shopRepository;

		public ShopRepository getShopRepository() {
			return shopRepository;
		}

		public void setShopRepository(ShopRepository shopRepository) {
			this.shopRepository = shopRepository;
		}
		@Override
		public Shop find(Long id) {
			// TODO Auto-generated method stub
			return shopRepository.findOne(id);
		}
		@Override
		public Shop create(Shop object) {
			// TODO Auto-generated method stub
			return shopRepository.save(object);
		}
		@Override
		public Collection<Shop> retreive() {
			// TODO Auto-generated method stub
			return shopRepository.findAll();
		}
		@Override
		public Shop update(Shop object) {
			// TODO Auto-generated method stub
			return shopRepository.save(object);
		}

		@Override
		public void delete(Shop object) {
			// TODO Auto-generated method stub
			shopRepository.delete(object);
		}
		@Override
		public Page<Shop> chercherALL(String mc , Pageable pageable)
		{
			return shopRepository.chercherALL(mc, pageable);
		}

		

		
		

		
	}

