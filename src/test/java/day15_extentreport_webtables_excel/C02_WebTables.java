package day15_extentreport_webtables_excel;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    //https://the-internet.herokuapp.com/tables sayfasına gidelim
    //Task 1 : Table1’i print edin
    //Task 2 : 3. Row’(satır) datalarını print edin
    //Task 3 : Son row daki dataları print edin
    //Task 4 : 5. Column(sütun) datalarini print edin
    //Task 5 : Iki parametreli bir Java metot oluşturalım:
    // printData  Parameter 1 = row numarası
    // Parameter 2 = column numarası
    // printData(2,3); = 2nd satır, 3rd sütundaki datayı print etsin

    @Test
    void test01() {

        //https://the-internet.herokuapp.com/tables sayfasına gidelim
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1 : Table1’i print edin
        String tableOne = driver.findElement(By.xpath("//table[1]")).getText();
        System.out.println("Table 1 : "+ tableOne);

        System.out.println("====================================================================================");
        //Task 2 : 3. Row’(satır) datalarını print edin
        String thirthRowData = driver.findElement(By.xpath("//table[1]//tbody//tr[3]")).getText();
        System.out.println("Table thirth row data : "+ thirthRowData);
        System.out.println("====================================================================================");

        //Task 3 : Son row daki dataları print edin
        String lastRowData = driver.findElement(By.xpath("//table[1]//tbody//tr[last()]")).getText();
        System.out.println("Table last row data : "+ lastRowData);

        System.out.println("====================================================================================");

        //Task 4 : 5. Column(sütun) datalarini print edin
        List<WebElement> fifthColumnData = driver.findElements(By.xpath("//table[1]//tbody//tr/td[5]"));

        for (WebElement w : fifthColumnData){
            System.out.println(w.getText()+" ");
        }
        System.out.println("====================================================================================");
        fifthColumnData.forEach(t-> System.out.println(t.getText()+" "));
        System.out.println("====================================================================================");

        //Task 5 : Iki parametreli bir Java metot oluşturalım:

        // printData  Parameter 1 = row numarası
        // Parameter 2 = column numarası
        // printData(2,3); = 2nd satır, 3rd sütundaki datayı print etsin
        printData(2,2);


    }
    public void printData(int rowNumber ,int columnNumber){

        WebElement webElement = driver.findElement(By.xpath("//table[1]//tbody//tr["+rowNumber+"]//td["+columnNumber+"]"));
        System.out.println("Table data : "+ webElement.getText());

        System.out.println("Table data : "+driver.findElement(By.xpath("//table[1]//tbody//tr["+rowNumber+"]//td["+columnNumber+"]")).getText());

    }
}
