package united.nearByShop.service;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService <T>{
	public T find(Long id);
	public T create(T object);
	public Collection<T> retreive();
	public T update (T object);
	public void delete (T object);
	public Page<T> chercherALL(String mc , Pageable pageable);

}
