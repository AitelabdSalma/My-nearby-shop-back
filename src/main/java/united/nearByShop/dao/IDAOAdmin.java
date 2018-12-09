package united.nearByShop.dao;


import united.nearByShop.bo.Administrateur;

public interface IDAOAdmin  extends IDAO<Administrateur>{
	public Administrateur checkEmail(String email);
}
