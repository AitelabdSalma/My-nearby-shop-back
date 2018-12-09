package united.nearByShop.service;


import united.nearByShop.dto.AdministrateurDto;

public interface IAdminService extends IService<AdministrateurDto>{
	public AdministrateurDto checkEmail(String email);
}
