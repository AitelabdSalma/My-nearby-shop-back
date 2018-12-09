package united.nearByShop.service.mapping;


public interface Mapping <Dto,Entity>{
	public  Dto convertToDto (Entity entity);
	public Entity convertToEntity(Dto dto);
//	public  List<Dto> convertsToDto (Collection<Entity> entitys);
	//public Entity convertToEntity(Dto dto);
	
}
