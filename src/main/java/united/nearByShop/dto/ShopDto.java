package united.nearByShop.dto;

import java.sql.Time;

import org.springframework.stereotype.Component;


@Component
public class ShopDto{
	
	private Long idShop;
	private String shopName;
	private Long distance;
	private boolean liked;
	private boolean dismissed;
	private Time DismissTime;
	
	public ShopDto() {
		super();
		this.shopName= "Shop1";
		this.liked= false;
		this.dismissed= false;
		this.distance= (long) 0;	
	}
	
	public ShopDto(String shopName, Long distance,boolean liked, boolean dismissed,Time DismissTime) {
		super();
		this.shopName=shopName;
		this.liked= liked;
		this.dismissed= dismissed;
		this.distance= distance;
		this.DismissTime= DismissTime;
	}

	public Long getIdShop() {
		return idShop;
	}

	public void setIdShop(Long idShop) {
		this.idShop = idShop;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public boolean isDismissed() {
		return dismissed;
	}

	public void setDismissed(boolean dismissed) {
		this.dismissed = dismissed;
	}

	public Time getDismissTime() {
		return DismissTime;
	}

	public void setDismissTime(Time dismissTime) {
		DismissTime = dismissTime;
	}

	@Override
	public String toString() {
		return "ShopDto [idShop=" + idShop + ", shopName=" + shopName + ", distance=" + distance + ", liked=" + liked
				+ ", dismissed=" + dismissed + ", DismissTime=" + DismissTime + "]";
	}

	
	


}
