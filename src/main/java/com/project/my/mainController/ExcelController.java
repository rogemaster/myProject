package com.project.my.mainController;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.project.my.mainDTO.BoardDto;

@Controller
public class ExcelController {
	
	@Autowired
	private SqlSession sqlsession;

	@RequestMapping(value = "/excelDown")
	public void boardExcelDownController(Model model, HttpServletResponse response) throws Exception {
		System.out.println("EXCEL DOWN CONTROLLER!");
		
		// 엑셀파일 확장자가 .xls를 원할 경우 HSSF로 처리 .xlsx를 원할 경우 XSSF로 처리
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = null;
		HSSFRow row = null;
		HSSFCell cell = null;
		
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short)10);
		font.setBoldweight((short) font.BOLDWEIGHT_NORMAL);
		font.setFontName("맑은고딕");
		
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
		sheet = workbook.createSheet("boardContents");
		
		List<BoardDto> boardDtos = sqlsession.selectList("boardInfoMapper.getBoardList");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		row = sheet.createRow(0);
		row.setHeight((short) 0x150);
		
		cell = row.createCell(0);
		cell.setCellValue("No");
		cell.setCellStyle(style);
		
		cell = row.createCell(1);
		cell.setCellValue("제목");
		cell.setCellStyle(style);
		
		cell = row.createCell(2);
		cell.setCellValue("내용");
		cell.setCellStyle(style);
		
		cell = row.createCell(3);
		cell.setCellValue("작성자");
		cell.setCellStyle(style);
		
		cell = row.createCell(4);
		cell.setCellValue("등록일");
		cell.setCellStyle(style);
		
		System.out.println("boardDtos.size::" + boardDtos.size());
		for(int i = 0; i < boardDtos.size(); i++) {
			int num = i + 1;
			
			row = sheet.createRow(num);
			row.setHeight((short) 0x150);
			
			cell = row.createCell(0);
			cell.setCellValue(Integer.toString(boardDtos.get(i).getNo()));
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue(boardDtos.get(i).getTitle());
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue(boardDtos.get(i).getContents());
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue(boardDtos.get(i).getWriter());
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue(format.format(boardDtos.get(i).getReg_date()));
			cell.setCellStyle(style);
		}
		
		for(int i = 0; i <= boardDtos.size(); i++) {
			sheet.autoSizeColumn(i);
		}
		
		response.setContentType("Application/Msexcel");
		response.setHeader("Content-Disposition", "ATTachment; Filename=" + URLEncoder.encode("EXCEL_TEST", "UTF-8") + ".xls");
		
		OutputStream fileOut = response.getOutputStream();
	    workbook.write(fileOut);
	    fileOut.close();
		
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
		
	}
	
	@RequestMapping(value = "/excelUpload", method = RequestMethod.POST)
	@ResponseBody
	public void excelUploadController(HttpServletResponse response, MultipartHttpServletRequest request) throws Exception {
		System.out.println("excelUploadController CALL!!");
		
		MultipartFile excelFile = request.getFile("excelFile");
		
		if(excelFile == null || excelFile.isEmpty()){
	        throw new RuntimeException("엑셀파일을 선택 해 주세요.");
	    }
		
		File destFile = new File("C:\\"+excelFile.getOriginalFilename());
		excelFile.transferTo(destFile);
//		excelService.excelUpload(destFile);
		destFile.delete();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
