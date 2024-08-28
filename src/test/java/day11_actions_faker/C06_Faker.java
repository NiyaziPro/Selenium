package day11_actions_faker;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.util.Locale;

public class C06_Faker extends TestBase {
    //faker objesi ile fake bir isim yazdırınız
    //faker objesi ile fake bir soyisim yazdırınız
    //faker objesi ile fake bir adress yazdırınız
    //faker objesi ile fake bir telefon No yazdırınız
    //faker objesi ile fake bir email yazdırınız
    //faker objesi ile fake bir rastgele 15 haneli bir sayi yazdırınız
    //faker objesi ile fake bir isimsoyisim yazdırınız


    @Test
    void test01() {

        Faker faker = new Faker();

        //faker objesi ile fake bir isim yazdırınız
        System.out.println(faker.name().firstName());

        //faker objesi ile fake bir soyisim yazdırınız
        System.out.println(faker.name().lastName());

        //faker objesi ile fake bir adress yazdırınız
        System.out.println(faker.address().fullAddress());

        //faker objesi ile fake bir telefon No yazdırınız
        System.out.println(faker.phoneNumber().phoneNumber());

        //faker objesi ile fake bir email yazdırınız
        System.out.println(faker.internet().emailAddress());

        //faker objesi ile fake bir rastgele 15 haneli bir sayi yazdırınız
        System.out.println(faker.number().digits(15));

        //faker objesi ile fake bir isimsoyisim yazdırınız
        System.out.println(faker.name().fullName());


    }

    @Test
    void test02() {
        Faker faker = new Faker(new Locale("tr"));

        //faker objesi ile fake bir isimsoyisim yazdırınız
        System.out.println(faker.name().fullName());

    }
}
