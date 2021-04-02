package com.project.my.mainController;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("excelService")
public class ExcelServiceImpl implements ExcelService {

//	@Resource(name = "excelMapper")
//	private ExcelMapper excelMapper;
	
	@Autowired
	private SqlSession sqlsession;
	
//	public List<Map> selectRow() throws Exception {
//		return sqlsession.selectRow();
//	}
	
	public void excelUpload(File destFile) throws Exception {
		ExcelReadOption excelReadOption = new ExcelReadOption();
		excelReadOption.setFilePath(destFile.getAbsolutePath());
		excelReadOption.setOutputColumns("A","B","C","D");
		excelReadOption.setStartRow(2);
		
		List<Map<String, String>>excelContent = ExcelRead.read(excelReadOption);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("excelContent", excelContent);
		
		sqlsession.insert("boardInfoMapper.insertExcel", paramMap);
	}
}
