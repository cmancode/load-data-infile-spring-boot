package com.cmancode.load.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cmancode.load.app.service.IDatoTempotalService;

@Controller
public class IndexControler {
	
	private final static String UPLOADS_FOLDER = "uploads";
	
	@Autowired
	private IDatoTempotalService datoTemporalService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "file";
	}
	
	@RequestMapping(value = "cargar", method = RequestMethod.POST)
	public String cargaDatos(@RequestParam("file") MultipartFile file) {
		
		String fileName = file.getOriginalFilename();
		Path ruta = Paths.get(UPLOADS_FOLDER).resolve(fileName).toAbsolutePath();
		
		try {
			Files.copy(file.getInputStream(), ruta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datoTemporalService.cargaMasiva(fileName);
		
		return "redirect: file";
	}
}
