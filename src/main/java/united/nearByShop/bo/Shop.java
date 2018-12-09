package united.nearByShop.bo;
// 

import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "shop")
public class Shop implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idShop;
	private String shopName;
	private Long distance;
	private boolean liked;
	private boolean dismissed;
	private Time DismissTime;

	

	public Shop() {
		super();
		this.shopName= "Shop1";
		this.liked= false;
		this.dismissed= false;
		this.distance= (long) 0;	
	}

	public Shop(String shopName, Long distance,boolean liked, boolean dismissed,Time DismissTime) {
		super();
		this.shopName=shopName;
		this.liked= liked;
		this.dismissed= dismissed;
		this.distance= distance;
		this.DismissTime= DismissTime;
	}


	@Id

	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	
	@Column(name = "ID_SHOP	", unique = true, nullable = false)
	public Long getIdShop() {
		return this.idShop;
	}
	public void setIdShop(Long idShop) {
		this.idShop = idShop;
	}
	
	@Column(name = "DISTANCE", unique = true, nullable = false)
	public Long getDistance() {
		return this.distance;
	}
	public void setDistance(Long distance) {
		this.distance = distance;
	}
	
	@Column(name = "SHOPNAME", length = 50)
	public String getShopName() {
		return this.shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	
	@Column(name = "LIKED")
	public boolean getLiked() {
		return this.liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}
	
	@Column(name = "DISMISSED")
	public boolean getDismissed() {
		return this.dismissed;
	}

	public void setDismissed(boolean dismissed) {
		this.dismissed = dismissed;
	}
	@Column(name = "DISMISSTIME")
	public Time getDismissTime() {
		return DismissTime;
	}

	public void setDismissTime(Time dismissTime) {
		DismissTime = dismissTime;
	}
	@Override
	public String toString() {
		return "Shop [idShop=" + idShop + ", shopName=" + shopName + ", distance=" + distance + ", liked=" + liked
				+ ", dismissed=" + dismissed + ", DismissTime=" + DismissTime + "]";
	}

}
