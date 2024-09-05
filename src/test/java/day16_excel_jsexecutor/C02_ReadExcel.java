package day16_excel_jsexecutor;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class C02_ReadExcel {

    //Örnek 1: Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
    //Örnek 2: 3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
    //Örnek 3: Kullanılan satır sayısın bulun
    //Örnek 4: Sayfadaki son satırin index ini yazdırınız
    //Örnek 5: Excel sayfasindaki datalari COUNTRY,CAPITALS (Ülke-Başkent) key-value şeklinde console a yazdiriniz
    // {{USA,D.C},{FRANCE,PARIS}....}

    @Test
    void test01() throws IOException {

        String path = "src\\test\\java\\resources\\Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Örnek 1: Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın

        Cell cell1 = workbook.getSheet("Sheet1").getRow(0).getCell(1);
        System.out.println("cell1 = " + cell1);

        //Örnek 2: 3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin

        Cell cell2 = workbook.getSheet("Sheet1").getRow(2).getCell(0);

        System.out.println("cell2 = " + cell2);

        Assertions.assertEquals("France", cell2.toString());

        //Örnek 3: Kullanılan satır sayısın bulun

        System.out.println("Number of Rows : " + workbook.getSheet("Sheet1").getPhysicalNumberOfRows());

        //Örnek 4: Sayfadaki son satırin index ini yazdırınız

        int lastRowIndex = (workbook.getSheet("Sheet1").getPhysicalNumberOfRows()) - 1;
        System.out.println("lastRowIndex = " + lastRowIndex);

        System.out.println("Last Row Index = " + workbook.getSheet("Sheet1").getLastRowNum());


        //Örnek 5: Excel sayfasindaki datalari COUNTRY,CAPITALS (Ülke-Başkent) key-value şeklinde console a yazdiriniz
        // {{USA,D.C},{FRANCE,PARIS}....}

       /* String country = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        String capital = workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();
        System.out.println(country+"  "+capital);*/

        String country2 = workbook.getSheet("Sheet1").getRow(1).getCell(0).toString();
        String capital2 = workbook.getSheet("Sheet1").getRow(1).getCell(1).toString();
        System.out.println(country2 + "  " + capital2);

        String country3 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        String capital3 = workbook.getSheet("Sheet1").getRow(2).getCell(1).toString();
        System.out.println(country3 + "  " + capital3);

        System.out.println("====================================================================");

        Map<String, String> countryCapital = new LinkedHashMap<>();
        for (int i = 0; i <= workbook.getSheet("Sheet1").getLastRowNum(); i++) {
            String country = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String capital = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            countryCapital.put(country, capital);

        }
        System.out.println(countryCapital);

    }
}
