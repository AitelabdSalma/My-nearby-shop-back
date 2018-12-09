package united.nearByShop.bo;
// 

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "administrateur")
public class Administrateur implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idAdmin;
	private String nom;
	private String prenom;
	private String email;
	private String motDePasse;

	public Administrateur() {
	}

	public Administrateur(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Administrateur(String nom, String prenom, String email, String motDePasse) {

		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ID_ADMIN", unique = true, nullable = false)
	public Long getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	@Column(name = "NOM", length = 25)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "PRENOM", length = 25)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "EMAIL", length = 25)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "MOT_DE_PASSE", length = 100)
	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "Administrateur [idAdmin=" + idAdmin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", motDePasse=" + motDePasse + "]";
	}

	public boolean validatorNom() {
		Pattern p = Pattern.compile("^[a-zA-Zàâäéèêëçùûüôö]{2,}$");
		Matcher m = p.matcher(nom);
		if (m.find()) return true;
		return false;
	}
	public boolean validatorPrenom() {
		Pattern p = Pattern.compile("^[a-zA-Zàâäéèêëçùûüôö]{2,}$");
		Matcher m = p.matcher(prenom);
		if (m.find()) return true;
		return false;
	}
	public boolean validatorEmail() {
		Pattern p = Pattern.compile("^[a-zA-Z0-9._%+-àâäéèêëçùûüôö]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{1,}$");
		Matcher m = p.matcher(email);
		if (m.find()) return true;
		return false;
	}

}
