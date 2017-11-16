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

import com.app_jour_j.mvc.entities.Enseignant;
import com.app_jour_j.mvc.services.IEnseignantService;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
@RequestMapping(value = "/enseignant")
public class EnseignantController {

	public static final String AUTHOR = "Eniso Google Club";

	@Autowired
	IEnseignantService enseignantService;

	@RequestMapping(value = "/")
	public String getAll(Model model) {
		List<Enseignant> enseignants = enseignantService.selectAll();
		if (enseignants == null) {
			enseignants = new ArrayList<Enseignant>();
		}
		model.addAttribute("enseignants", enseignants);
		return "main_views/enseignant";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addEnseignant(Model model) {
		Enseignant enseignant = new Enseignant();
		model.addAttribute("enseignant", enseignant);
		return "forms/form_enseignant";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveEnseignant(Model model, Enseignant enseignant) {

		if (enseignant.getIdProfessor() != null) {
			enseignantService.update(enseignant);
		} else {
			enseignantService.save(enseignant);
		}
		generatePdf(enseignant);
		return "redirect:/enseignant/add";
	}

	@RequestMapping(value = "/edit/{idEnseignant}")
	public String editEnseignant(Model model, @PathVariable Long idEnseignant) {
		if (idEnseignant != null) {
			Enseignant enseignant = enseignantService.getById(idEnseignant);
			if (enseignant != null) {
				model.addAttribute("enseignant", enseignant);
			}
		}
		return "forms/form_enseignant";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteEnseignant(Model model, @PathVariable Long id) {

		if (id != null) {
			Enseignant enseignant = enseignantService.getById(id);
			if (enseignant != null) {
				enseignantService.remove(id);
			}
		}
		return "redirect:/enseignant/";
	}

	private void generatePdf(Enseignant enseignant) {
		Document doc = new Document();
		Document docFullInfo = new Document();

		try {
			PdfWriter.getInstance(doc, new FileOutputStream(
					getClass().getResource("/pdf/enseignants/").getFile() 
					+ enseignant.getIdProfessor()
					+"_"+enseignant.getNom() + ".pdf"));
			PdfWriter.getInstance(docFullInfo, new FileOutputStream(
					getClass().getResource("/pdf/enseignants/").getFile() 
					+ enseignant.getIdProfessor()
					+"_full_"+enseignant.getNom() + ".pdf"));
			System.out.println(getClass().getResource("/pdf/enseignants/").getFile() 
					+ enseignant.getIdProfessor()
					+"_full_"+enseignant.getNom() + ".pdf");
			Rectangle size = new Rectangle(228, 150);
			doc.setPageSize(size);
			docFullInfo.setPageSize(size);
			doc.addAuthor(AUTHOR);
			docFullInfo.addAuthor(AUTHOR);
			doc.addTitle("Enseignant");
			docFullInfo.addTitle("Enseignant_full");
			doc.open();
			docFullInfo.open();
			Phrase infos = new Phrase("Nom : " + enseignant.getNom() + 
									  "\nPr�nom : " + enseignant.getPrenom() + 
									  "\nGrade : " + enseignant.getGrade(),
									  FontFactory.getFont(FontFactory.COURIER, 10));
			Phrase fullInfos = new Phrase(enseignant.toString(),FontFactory.getFont(FontFactory.COURIER, 10));
			doc.add(infos);
			docFullInfo.add(fullInfos);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		doc.close();
		docFullInfo.close();

	}

}
