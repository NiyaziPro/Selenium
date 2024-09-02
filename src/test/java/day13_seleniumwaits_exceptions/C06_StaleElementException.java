package day13_seleniumwaits_exceptions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_StaleElementException extends TestBase {

    /*
        StaleElementException nasil alinir?
        ==> Bir sayfadaki bir webelementi locate ettikten ve bunu bir webelement seklinde sakladiktan sonra
        o sayfada yenileme yapan herhangi bir islem(navigate.refresh(), back(), forward()...) yapildiginda
        locateini aldigimiz webelementi tekrar kullanmak istersek bu exceptionu aliriz

        Bu hatayi nasil handle ederiz?
        => Bu exceptionu handle etmek icin webelementi navigate.refresh(), back(), forward() ...
        methodlari kullanildiginda tekrar locate etmeliyiz
         */

    @Test
    void test01() {
        driver.get("https://www.techproeducation.com/");
        WebElement searchBox = driver.findElement(By.id("searchHeaderInput"));

        driver.navigate().refresh();
        // searchBox.sendKeys("Selenium", Keys.ENTER);
        // StaleElementReferenceException: stale element reference: stale element not found

        searchBox = driver.findElement(By.id("searchHeaderInput"));
        searchBox.sendKeys("Selenium", Keys.ENTER);

    }

    /*
        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Selenium Exceptions <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        Selenium ile çalışırken karşılaşabileceğiniz çeşitli özel durumlar (exceptions) vardır.
        Bu özel durumlar, test senaryolarınızın başarısız olmasına veya beklenmedik hatalarla karşılaşmanıza neden olabilir.
        İşte Selenium'da en yaygın kullanılan bazı özel durumlar:

        -   NoSuchElementException: Belirtilen öğe DOM'da bulunamadığında atılır.
        Örneğin, bir öğeyi bulmaya çalıştığınızda ancak öğe mevcut değilse bu hata alınır.

        -   TimeoutException: Bir işlem belirli bir süre içinde tamamlanamadığında atılır.
        Örneğin, bir öğenin görünür olmasını beklerken belirli bir süre aşıldığında bu hata alınır.

        -   ElementNotVisibleException: Bir öğe DOM'da mevcut olabilir, ancak görünür değilse (displayed=False) bu hata alınır.
        Bu hata genellikle görünmeyen bir öğeye tıklamaya çalışırken meydana gelir.

        -   StaleElementReferenceException: Bir öğe, DOM'dan kaldırıldığında veya güncellendiğinde ve
        bu öğeye yeniden erişmeye çalışıldığında atılır. Öğenin referansı artık geçerli değilse bu hata alınır.

        -   NoSuchFrameException: Belirtilen çerçeve (frame) mevcut değilse veya çerçeve bulunamazsa bu hata alınır.
        Örneğin, driver.switchTo().frame() ile var olmayan bir çerçeveye geçmeye çalışırsanız bu hatayı alırsınız.

        -   NoSuchWindowException: Belirtilen pencere bulunamadığında atılır. Örneğin, driver.switchTo().window()
        kullanarak var olmayan bir pencereye geçmeye çalışırsanız bu hatayı alırsınız.

        -   WebDriverException: Genel bir Selenium WebDriver hatasıdır.
        WebDriver ile ilgili çeşitli genel hatalar oluştuğunda bu istisna alınır.

        -   ElementClickInterceptedException: Bir öğe tıklanabilir durumda değilse ve
        başka bir öğe tıklama girişimini engelliyorsa bu hata atılır.
        Örneğin, bir açılır pencere (popup) tıklanmak istenen öğenin önünde duruyorsa bu hata alınır.

        -   InvalidSelectorException: Belirtilen seçici (selector) geçersizse bu hata alınır.
        Örneğin, CSS seçicisi veya XPath'in yanlış yazılması bu hataya neden olabilir.

        -   MoveTargetOutOfBoundsException: Fare hareketi hedefi tarayıcı penceresinin dışındaysa bu hata atılır.
        Örneğin, belirli bir koordinata taşınmaya çalışıldığında, hedef pencerenin görünüm alanının dışındaysa bu hata alınır.

        -   InvalidArgumentException: WebDriver'a geçersiz bir argüman verildiğinde atılır.
        Örneğin, bir WebElement yerine geçersiz bir türde argüman verdiğinizde bu hatayı alabilirsiniz.

        -   InvalidCookieDomainException: Mevcut bir alan adına (domain) uygun olmayan bir çerez (cookie) eklemeye çalıştığınızda atılır.
        Bu, çerezin alan adı (domain) ile mevcut sayfanın alan adının eşleşmemesi durumunda ortaya çıkar.

        -   InvalidElementStateException: Bir öğenin geçerli durumu, gerçekleştirilmeye çalışılan eylem için uygun değilse bu hata alınır.
        Örneğin, bir metin kutusuna yazı yazmaya çalışırken metin kutusu devre dışıysa (disabled) bu hatayı alabilirsiniz.

        -   JavascriptException: WebDriver içinde JavaScript kodu çalıştırılırken bir hata oluştuğunda atılır.
        executeScript() veya executeAsyncScript() kullanarak JavaScript çalıştırırken bu hata ile karşılaşabilirsiniz.

        -   NoAlertPresentException: Geçerli sayfada beklenen bir uyarı (alert) penceresi yokken switchTo().alert() çağrıldığında atılır.

        -   SessionNotFoundException: WebDriver oturumu (session) mevcut değilse veya sona ermişse bu hata alınır.
        Bu genellikle tarayıcı kapandığında veya oturum süresi dolduğunda meydana gelir.

        -   UnhandledAlertException: Bir uyarı (alert) penceresi, bir eylem (örneğin, öğeye tıklama) gerçekleştirilirken ele alınmamışsa (handled),
        bu hata atılır. Uyarı penceresi kapatılmadan bir işlem yapılmaya çalışıldığında bu istisna ile karşılaşılır.

        -   UnexpectedAlertPresentException: Beklenmeyen bir uyarı (alert) penceresi ortaya çıktığında atılır.
        Örneğin, sayfa yüklenmesi sırasında beklenmeyen bir uyarı belirirse bu hata alınır.

        -   TimeoutException: Bir bekleme (wait) işlemi zaman aşımına uğradığında atılır.
        Örneğin, bir öğeyi belirli bir süre boyunca beklediğinizde ve öğe o süre içinde bulunamadığında bu hatayı alabilirsiniz.

        -   NoSuchAttributeException: Belirtilen öğenin talep edilen niteliği (attribute) mevcut değilse bu hata alınır.
        Örneğin, getAttribute() yöntemiyle var olmayan bir niteliği sorguladığınızda bu istisna ile karşılaşabilirsiniz.

        -   InvalidCoordinatesException: Bir öğeye fare hareketi yapılmaya çalışıldığında geçersiz koordinatlar kullanılıyorsa bu hata alınır.
        Örneğin, öğe görünüm alanının dışındaysa bu hatayla karşılaşılabilir.

        -   ElementNotInteractableException: Belirtilen öğe etkileşim için uygun değilse bu hata atılır.
        Örneğin, gizli bir öğeye tıklamaya çalışıldığında bu hata alınabilir.

        -   ImeNotAvailableException: Girdi Yöntemi Düzenleyicisi (Input Method Editor - IME) desteklenmiyorsa bu hata alınır.
        IME, genellikle Asya dillerinde kullanılan özel klavye düzenlerini ifade eder.

        -   ImeActivationFailedException: IME etkinleştirilemediğinde bu hata atılır.

        -   NoSuchSessionException: Geçersiz bir oturum kimliği kullanıldığında atılır.
        Bu hata, oturum zaten kapatıldıysa ve bu oturuma erişilmeye çalışıldığında meydana gelir.

        Bu istisnalar, Selenium ile otomasyon testleri geliştirirken yaygın olarak karşılaşılabilir ve
        bu hataları doğru bir şekilde yönetmek, testlerin kararlılığını ve doğruluğunu artırabilir.

     */
}
