package com.app_jour_j.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app_jour_j.mvc.entities.Media;
import com.app_jour_j.mvc.services.IMediaService;

@Controller
@RequestMapping(value = "/media")
public class MediaController {

	@Autowired
	IMediaService mediaService;

	@RequestMapping(value = "/")
	public String getAll(Model model) {
		List<Media> medias = mediaService.selectAll();
		if (medias == null) {
			medias = new ArrayList<Media>();
		}
		model.addAttribute("medias", medias);
		return "main_views/media";
	}

	@RequestMapping(value = "/add")
	public String add() {

		return "forms/form_media";
	}
}
