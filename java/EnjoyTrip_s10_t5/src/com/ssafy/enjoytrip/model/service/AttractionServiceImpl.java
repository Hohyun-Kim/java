package com.ssafy.enjoytrip.model.service;

import java.util.List;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.enjoytrip.model.dao.AttractionDaoImpl;

public class AttractionServiceImpl implements AttractionService{
	
	private static AttractionService attractionService = new AttractionServiceImpl();
	
	private AttractionServiceImpl() {
		
	}
	
	public static AttractionService getAttractionService() {
		return attractionService;
	}

	@Override
	public List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto) {
		return AttractionDaoImpl.getAttractionDao().attractionList(attractionInfoDto); 
	}

	@Override
	public List<AttractionInfoDto> searchByTitle(String title, int sidoCode) {
		return AttractionDaoImpl.getAttractionDao().searchByTitle(title, sidoCode);
	}

}
