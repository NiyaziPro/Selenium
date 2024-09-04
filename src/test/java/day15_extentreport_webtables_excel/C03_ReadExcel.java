package day15_extentreport_webtables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {


    @Test
    void test01() throws IOException {

        //1) Öncelikle excel dosyasının bulunduğu path ayarlanır
        String path = "src\\test\\java\\resources\\Capitals.xlsx";

        //2) belirtilen path'te bulunan excel dosyasından java classımıza bir data akışı oluşturduk
        FileInputStream fileInputStream = new FileInputStream(path);

        //3) java ortamında bir excel dosyası açtık (fis objesine aldığımız data akışı ile)
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //4)Bir excel dosyasında birden fazla sayfa olabilir, bu nedenle çalılaşacak sayfa seçimini yaptık
        Sheet sheet = workbook.getSheet("Sheet1");

        //5) Bir excel sayfasında belirtilen indexteki satıra erişmek için kullanılır
        Row row = sheet.getRow(0);

        //6)Bir rowda birden fazla cell vardır, belirtilen index ile o cell'e erişmek için kullanılır
        Cell cell = row.getCell(0);


    }
}
