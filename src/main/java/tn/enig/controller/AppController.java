package tn.enig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.enig.dao.IDepartement;
import tn.enig.dao.IMateriel;
import tn.enig.model.Departement;
import tn.enig.model.Materiel;

@Controller
public class AppController {
	
	@Autowired
	private IDepartement daod;
	
	@Autowired
	private IMateriel daom;
	
	public void setDaod(IDepartement daod) {
		this.daod=daod;
	}
	
	public void setDaom(IMateriel daom) {
		this.daom=daom;
	}
	
	@GetMapping("/Departement")
	public String fn1(Model m) {
		List <Departement> liste = daod.findAll();
		System.out.println(liste.size());
		m.addAttribute("liste", liste);
		return "departements";
	}
	
	@GetMapping("/Materiel/{id}")
	public String fn2(Model m, @PathVariable("id") int id) {
		List <Materiel> liste = daom.getAllMaterielByDept(id);
		m.addAttribute("liste", liste);
		return "ListeMaterielsDepartement";
	}
	
	@GetMapping("/AjouterMateriel")
	public String fn3(Model m) {
		Materiel mat = new Materiel();
		List <Departement> dep = daod.findAll();
		m.addAttribute("mat", mat);
		m.addAttribute("dep", dep);
		return "AjouterMateriel";
	}
	
	@PostMapping("/save")
	public String fn4(Model m, @ModelAttribute("mat") Materiel mat) {
		daom.save(mat);
		return "redirect:Departement";
	}
	

}
