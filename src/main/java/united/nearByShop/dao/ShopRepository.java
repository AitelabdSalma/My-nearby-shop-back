package united.nearByShop.dao;

	import org.springframework.data.domain.Page;
	import org.springframework.data.domain.Pageable;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;



import united.nearByShop.bo.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long>{

		@Query("SELECT n from Shop n WHERE n.shopname LIKE :x")
		public Page<Shop> chercherALL(@Param("x")String mc , Pageable pageable);
		
}
