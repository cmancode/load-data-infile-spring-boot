package com.cmancode.load.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class DatoTemporalImpl implements IDatoTemporalDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void cargaMasiva(String nameFile) {
		String PathFile = "/home/carlos/Documentos/proyectos-sp/load-data-infile/uploads/"+nameFile;
		em.createNativeQuery("LOAD DATA INFILE :filename INTO TABLE datos_temporales"+
							" FIELDS TERMINATED BY ';'"+
							" LINES TERMINATED BY '\\n'"+
							" (nombres, apellidos, direccion)").setParameter("filename", PathFile)
							.executeUpdate();
	}

}
