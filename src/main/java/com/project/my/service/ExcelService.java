package com.project.my.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.project.my.mainDTO.BoardDto;
import com.project.my.mainDTO.UserSessionInfoDto;

public class ExcelService {

	public List<BoardDto> uploadExcelFile(MultipartFile excelFile) throws Exception {
		
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		OPCPackage opcPackage = OPCPackage.open(excelFile.getInputStream());
		XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		for(int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			BoardDto boardDto = new BoardDto();
			UserSessionInfoDto userSessionInfoDto = new UserSessionInfoDto();
			
			XSSFRow row = sheet.getRow(i);
			
			if(row == null) {
				continue;
			}
			
			XSSFCell cell = row.getCell(0);
			if(cell != null) {
				boardDto.setTitle(cell.getStringCellValue());
			}
			cell = row.getCell(1);
			if(cell != null) {
				boardDto.setContents(cell.getStringCellValue());
			}
			cell = row.getCell(2);
			if(cell != null) {
				boardDto.setWriter(userSessionInfoDto.getUserName());
			}
			cell = row.getCell(3);
			if(cell != null) {
				boardDto.setSessionId(userSessionInfoDto.getSessionId());
			}
			
			list.add(boardDto);
		}
		
		return list;
	}

}
