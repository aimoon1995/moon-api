//package com.moon.moon_export_poi.controller;
//package com.poi.excel.water;
//
//import com.moon.moon_export_poi.util.FontImage;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFRelation;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.FileOutputStream;
//
///**
// * @ClassName MoonController
// * @Description: TODO
// * @Author zyl
// * @Date 2020/12/1
// * @Version V1.0
// **/
//@RestController
//public class MoonController {
//
//
//    @GetMapping("/bb")
//    public void export() {
//        try {
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            FileOutputStream out = new FileOutputStream("/Users/chen/Downloads/测试xlsx.xlsx");
//
//            XSSFSheet sheet = workbook.createSheet("Sheet1");
//            workbook.getSheet("Sheet1");
//
//            //add picture data to this workbook.
////                FileInputStream is = new FileInputStream("/Users/Tony/Downloads/data_image.png");
////            byte[] bytes = IOUtils.toByteArray(is);
//
//
//            BufferedImage image = FontImage.createWatermarkImage("测试水印","yyyy-MM-dd","#C5CBCF");
//            // 导出到字节流B
//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//            ImageIO.write(image, "png", os);
//
//            int pictureIdx = workbook.addPicture(os.toByteArray(), Workbook.PICTURE_TYPE_PNG);
////            is.close();
//
//            //add relation from sheet to the picture data
//             String rID = sheet.addRelation( XSSFRelation.IMAGES, workbook.getAllPictures().get(pictureIdx)).getRelationship().getId();
//            // String rid = sheet.addRelation(null,XSSFRelation.IMAGES,workbook.getAllPictures().get(pictureIdx))
//            //set background picture to sheet
//            sheet.getCTWorksheet().addNewPicture().setId(rID);
//
//            workbook.write(out);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
