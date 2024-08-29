package day12_files_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {


    @Test
    void test01() {

        //Files.exists(Paths.get(""));

        System.out.println(System.getProperty("user.dir")); // current working directory - bu komut uzerinde calisan dizini verir

        // C:\IntelliJ IDEA\Selenium

        System.out.println(System.getProperty("user.home")); // bu komut home directory'i verir

        // C:\Users\TechPro

        /*
        Bilgisayarimizda bulunan  herhangi bir dosyanin varligini test edebilmemiz icin ;
        öncelikle varligini test etmek istedigimiz dosyanin yolunu almaliyiz
        Sonra ise Files.exists(Paths.get("")); methodu ile test gerceklestireceğiz

        Ortak çalışmalarda her kullanıcının bilgisayarının ana yolu farklıdır,
        ama üzerinde çalışılan projedeki dosya yolu aynıdır.

        Bunun için herkeste farklı olan kısmı System.getProperty("user.home") kodu ile alıp
        herkeste aynı olan kısım ile birleştirerek dynamic path elde edeceğiz
         */

        //"C:\Users\TechPro        \Desktop\Batch001.txt"

        String ortakYol = "\\Desktop\\Batch001.txt";
        String dynamicPath = System.getProperty("user.home") + ortakYol;

        Assertions.assertTrue(Files.exists(Paths.get(dynamicPath)));

        /*
            Files.exists(Paths.get(dynamicPath) methodunu kullanarak belirtmis oldugumuz path'in
            dosya sistemimizde var olup olmadigini kontrol ettik
             */
    }
}
