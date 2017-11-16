package com.app_jour_j.mvc.controllers;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app_jour_j.mvc.entities.Industriel;
import com.app_jour_j.mvc.services.IIndustrielService;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
@RequestMapping(value = "/industriel")
public class IndustrielController {

	@Autowired
	IIndustrielService indusService;

	@RequestMapping(value = "/")
	public String getAll(Model model) {
		List<Industriel> industriels = indusService.selectAll();
		if (industriels == null) {
			industriels = new ArrayList<Industriel>();
		}
		model.addAttribute("industriels", industriels);
		return "main_views/industriel";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addIndustriel(Model model) {
		Industriel industriel = new Industriel();
		model.addAttribute("industriel", industriel);

		return "forms/form_industriel";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveIndustriel(Model model, Industriel industriel) {
		
		if (industriel.getIdIndustriel() != null) {
			indusService.update(industriel);
		} else {			
			indusService.save(industriel);
		}
		generatePdf(industriel);
		return "redirect:/industriel/add";
	}
	
	@RequestMapping(value = "/edit/{idIndustriel}")
	public String editIndustriel(Model model, @PathVariable Long idIndustriel) {
		if (idIndustriel != null) {
			Industriel industriel = indusService.getById(idIndustriel);
			if (industriel != null) {
				model.addAttribute("industriel", industriel);
			}
		}
		return "forms/form_industriel";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteIndustriel(Model model, @PathVariable Long id) {
		
		if (id != null) {
			Industriel industriel = indusService.getById(id);
			if (industriel != null) {
				indusService.remove(id);
			}
		}
		return "redirect:/industriel/";
	}
	
	private void generatePdf(Industriel industriel){
		Document doc = new Document();
		Document docFullInfo = new Document();

		try {
			PdfWriter.getInstance(doc, new FileOutputStream(
					getClass().getResource("/pdf/industriels/").getFile() 
					+ industriel.getIdIndustriel()
					+"_"+industriel.getNom() + ".pdf"));
			PdfWriter.getInstance(docFullInfo, new FileOutputStream(
					getClass().getResource("/pdf/industriels/").getFile() 
					+ industriel.getIdIndustriel()
					+"_full_"+industriel.getNom() + ".pdf"));
			System.out.println(getClass().getResource("/pdf/industriels/").getFile() 
					+ industriel.getIdIndustriel()
					+"_full_"+industriel.getNom() + ".pdf");
			Rectangle size = new Rectangle(228, 150);
			doc.setPageSize(size);
			docFullInfo.setPageSize(size);
			doc.addAuthor(EnseignantController.AUTHOR);
			docFullInfo.addAuthor(EnseignantController.AUTHOR);
			doc.addTitle("Industriel");
			docFullInfo.addTitle("Industriel_full");
			doc.open();
			docFullInfo.open();
			Phrase infos = new Phrase("Nom : " + industriel.getNom() + 
									  "\nPrenom : " + industriel.getPrenom() + 
									  "\nEntreprise : " + industriel.getEntreprise(),
									  FontFactory.getFont(FontFactory.COURIER, 10));
			Phrase fullInfos = new Phrase(industriel.toString(),FontFactory.getFont(FontFactory.COURIER, 10));
			doc.add(infos);
			docFullInfo.add(fullInfos);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		doc.close();
		docFullInfo.close();

	}
}
