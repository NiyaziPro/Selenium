package day16_excel_jsexecutor;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {

    //classwork
    //mysmoketestdata.xlsx dosyasina STATUS adinda ucuncu bir sutun olusturunuz,
    //Bu sutun altinda satirlara sirasiyla valid valid ve invalid degerlerini yaziniz


    @Test
    void test01() throws IOException {
        //mysmoketestdata.xlsx dosyasina STATUS adinda ucuncu bir sutun olusturunuz,

        FileInputStream fis = new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.getSheet("customer_info");

        Row row = sheet.getRow(0);

        Cell cell3 = row.createCell(2);

        cell3.setCellValue("STATUS");

        //Bu sutun altinda satirlara sirasiyla valid valid ve invalid degerlerini yaziniz

        sheet.getRow(1).createCell(2).setCellValue("valid");
        sheet.getRow(2).createCell(2).setCellValue("valid");
        sheet.getRow(3).createCell(2).setCellValue("invalid");

        FileOutputStream fos = new FileOutputStream("src/test/java/resources/mysmoketestdata.xlsx");

        workbook.write(fos);

        fis.close();
        fos.close();






    }
}
