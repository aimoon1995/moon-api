package com.moon.moon_export_poi.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.ImageUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *
 * @author lyt
 * 2017年7月19日
 */
public class poiexe {

	public static void main(String[] args) throws IOException {
        SXSSFWorkbook wb = new SXSSFWorkbook();
        Sheet sheet = wb.createSheet("成绩表");
		//为文件添加密码，设置文件只读
		sheet.protectSheet("12321");
		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        Row row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		Cell cell = row1.createCell(0);
		CellStyle style = cell.getCellStyle();
		style.setLocked(true);
        //设置到新单元格上
		cell.setCellStyle(style);
		// 设置单元格内容
		cell.setCellValue("学员考试成绩一览表");
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		// 在sheet里创建第二行
		Row row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		row2.createCell(0).setCellValue("姓名");
		row2.createCell(1).setCellValue("班级");
		row2.createCell(2).setCellValue("笔试成绩");
		row2.createCell(3).setCellValue("机试成绩");
		// 在sheet里创建第三行
		for(int i=0;i<3000;i++){
			Row row3 = sheet.createRow(2+i);
			row3.createCell(0).setCellValue("李明");
			row3.createCell(1).setCellValue("As178");
			row3.createCell(2).setCellValue(87);
			row3.createCell(3).setCellValue(87);
			row3.createCell(4).setCellValue(87);
			row3.createCell(5).setCellValue(87);
		}

		String imgPath="水印.png";
		ExportUtil.createWaterMark("水印效果一二三四五六七八", imgPath);
		ExportUtil.putWaterRemarkToExcel(wb, sheet, imgPath, 0, 10, 9, 52, 3, 50, 0, 0);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}byte[] content = os.toByteArray();

		File file1 = new File("D:/成绩表.xls");// Excel文件生成后存储的位置。
		OutputStream fos = null;

		try {
			fos = new FileOutputStream(file1);
			fos.write(content);
			os.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
