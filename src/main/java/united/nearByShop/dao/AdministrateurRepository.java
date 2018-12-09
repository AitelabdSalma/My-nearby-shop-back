package united.nearByShop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import united.nearByShop.bo.Administrateur;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
	@Query("SELECT a FROM Administrateur a WHERE a.email LIKE :x")
	public Administrateur checkEmail(@Param("x") String email);

	@Query("SELECT a FROM Administrateur a WHERE a.email LIKE :x AND a.motDePasse=:y")
	public Administrateur checkCompte(@Param("x") String email, @Param("y") String pwd);
	
	
	
	@Query("Select admin from Administrateur admin where email Like :x")
	Administrateur findByUsername(@Param("x")String username);
	
	
}
