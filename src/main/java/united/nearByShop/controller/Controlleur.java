package united.nearByShop.controller;


import java.security.MessageDigest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import united.nearByShop.bo.Administrateur;
import united.nearByShop.bo.Shop;

import united.nearByShop.dao.AdministrateurRepository;
import united.nearByShop.dao.ShopRepository;
import united.nearByShop.daoimpl.AdministrateurDao;

@Controller
public class Controlleur {
	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private AdministrateurRepository administrateurRepository;
	@Autowired
	private AdministrateurDao  administrateurDAO;
	
	
	
	
	@RequestMapping(value="/")
	public String os(Model model)//objet model de spring pour importer un model
	{
		Administrateur ad=administrateurDAO.find(1L);
		System.out.println(ad);
	//	administrateurDAO.delete(ad);
		return "home";//le nom de la vue
	}
	
	@RequestMapping(value="/test")
	public String onglets(Model model)//objet model de spring pour importer un model
	{
		List<Shop> shops=shopRepository.findAll();
		model.addAttribute("listeShops",shops);
		return "test";//le nom de la vue
	}
	
	@RequestMapping(value="/inscriptionForm")
	public String inscription(Model model)//objet model de spring pour importer un model
	{
		return "inscription";//le nom de la vue
	}
	
	@RequestMapping(value="/formAuth")
	public String ghome(Model model)//objet model de spring pour importer un model
	{
		
		return "auth";//le nom de la vue
	}
	
	@RequestMapping(value="/enregistrer",method=RequestMethod.POST)
	public String register(Model model,@ModelAttribute Administrateur administrateur)//@RequestParam(name="nom")String nom,@RequestParam(name="prenom")String prenom,@RequestParam(name="email")String email,@RequestParam(name="motDePasse")String pwd)//@RequestParam(name="nom")String nom,@RequestParam(name="prenom")String prenom,@RequestParam(name="email")String email,@RequestParam(name="pwd")String pwd)//objet model de spring pour importer un model
	{
		model.addAttribute("admin",administrateur);
		if(administrateur.getEmail().isEmpty() || administrateur.getNom().isEmpty() || administrateur.getPrenom().isEmpty() || administrateur.getMotDePasse().isEmpty())
		{
			model.addAttribute("Message","les champs doivent être remplie ");
			return "inscription";
		}
		if(!administrateur.validatorNom())
		{
			model.addAttribute("validatorNom","ce champs (nom) est invalide");
			return "inscription";
		}
		if(!administrateur.validatorPrenom())
		{
			model.addAttribute("validatorPrenom","ce champs (Prenom) est invalide");
			return "inscription";
		}
		if(!administrateur.validatorEmail())
		{
			model.addAttribute("validatorEmail","ce champs (Email) est invalide");
			return "inscription";
		}
		if(administrateurRepository.checkEmail(administrateur.getEmail())==null)
		{
			String n="salma";
			byte[] bytesOfMessage=null,test=null;
			MessageDigest md=null;
			try {
				bytesOfMessage = administrateur.getMotDePasse().getBytes("UTF-8");
				test = n.getBytes("UTF-8");
				md = MessageDigest.getInstance("MD5");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			byte[] thedigest = md.digest(bytesOfMessage);
			md.reset();
			byte[] testdigest = md.digest(test);
			System.out.println(thedigest.toString());
			System.out.println(testdigest.toString());
			administrateurRepository.save(administrateur);
			return "test";
		}
		else
		{
			model.addAttribute("Message","cet email '"+administrateur.getEmail()+"' est déjà utilisé, essayez un autre");
			return "inscription";
		}
	}
	
	@RequestMapping(value="/auth",method=RequestMethod.POST)
	public String auth(Model model,HttpSession session,@ModelAttribute Administrateur administrateur)//@RequestParam(name="email")String email,@RequestParam(name="pwd")String pwd)//@RequestParam(name="nom")String nom,@RequestParam(name="prenom")String prenom,@RequestParam(name="email")String email,@RequestParam(name="pwd")String pwd)//objet model de spring pour importer un model
	{
		Administrateur ad;
		if(administrateur.getEmail().isEmpty() || administrateur.getMotDePasse().isEmpty()) 
		{
			model.addAttribute("admin",administrateur);
			
			model.addAttribute("Message","les champs doivent être remplie");
			return "auth";
		}
		if((ad=administrateurRepository.checkCompte(administrateur.getEmail(), administrateur.getMotDePasse()))!=null)
		{
		//	session.setAttribute("admin", ad);
			return "home";
		}
		else
		{
			model.addAttribute("admin",administrateur);
			model.addAttribute("Message","ce compte n'existe pas ");
			return "auth";
		}
		
	}
	
	
	
	
	
	public ShopRepository getShopRepository() {
		return shopRepository;
	}
	public void setShopRepository(ShopRepository shopRepository) {
		this.shopRepository = shopRepository;
	}
	
	
	public AdministrateurRepository getAdministrateurRepository() {
		return administrateurRepository;
	}
	public void setAdministrateurRepository(AdministrateurRepository administrateurRepository) {
		this.administrateurRepository = administrateurRepository;
	}
	
}
