package homework;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class HomeWork_10 {
    /* HOMEWORK!!
    Bir "Name" sütunu oluşturup isimlerini excel doyasına yazınız:
    ("ayhan","beyhan","ceyhan","ali","veli","ahmet","can","sam","kate","raj","pam")
        */
    @Test
    void test01() throws IOException {

        FileInputStream fis = new FileInputStream("src/test/java/resources/homework_selenium.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.getSheet("list");

        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);

        cell.setCellValue("Name");

        sheet.createRow(1).createCell(0).setCellValue("ayhan");
        sheet.createRow(2).createCell(0).setCellValue("beyhan");
        sheet.createRow(3).createCell(0).setCellValue("ceyhan");
        sheet.createRow(4).createCell(0).setCellValue("ali");
        sheet.createRow(5).createCell(0).setCellValue("veli");
        sheet.createRow(6).createCell(0).setCellValue("ahmet");
        sheet.createRow(7).createCell(0).setCellValue("can");
        sheet.createRow(8).createCell(0).setCellValue("sam");
        sheet.createRow(9).createCell(0).setCellValue("kate");
        sheet.createRow(10).createCell(0).setCellValue("raj");
        sheet.createRow(11).createCell(0).setCellValue("pam");


        FileOutputStream fos = new FileOutputStream("src/test/java/resources/homework_selenium.xlsx");

        workbook.write(fos);

        fis.close();
        fos.close();


    }

    @Test
    void test02() throws IOException {

        Faker faker = new Faker(Locale.of("tr"));

        FileInputStream fis = new FileInputStream("src/test/java/resources/homework_selenium.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.createSheet("list2");

        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);


        cell.setCellValue("Full Name");

        for (int i = 1; i < 12; i++) {
            sheet.createRow(i).createCell(0).setCellValue(faker.name().fullName());
        }


        cell = row.createCell(1);
        cell.setCellValue("E-mail Address");

        for (int i = 1; i < 12; i++) {
            sheet.getRow(i).createCell(1).setCellValue(faker.internet().emailAddress());
        }



        cell = row.createCell(2);
        cell.setCellValue("Phone Number");

        for (int i = 1; i < 12; i++) {
            sheet.getRow(i).createCell(2).setCellValue(faker.phoneNumber().phoneNumber());
        }


        FileOutputStream fos = new FileOutputStream("src/test/java/resources/homework_selenium.xlsx");

        workbook.write(fos);

        fis.close();
        fos.close();
    }
}
