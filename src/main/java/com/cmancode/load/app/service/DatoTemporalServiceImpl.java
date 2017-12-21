package com.cmancode.load.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmancode.load.app.dao.IDatoTemporalDao;

@Service
@Transactional
public class DatoTemporalServiceImpl implements IDatoTempotalService {

	@Autowired
	private IDatoTemporalDao datoTemporalDao;
	
	@Override
	@Transactional
	public void cargaMasiva(String nameFile) {
		datoTemporalDao.cargaMasiva(nameFile);
	}

}
