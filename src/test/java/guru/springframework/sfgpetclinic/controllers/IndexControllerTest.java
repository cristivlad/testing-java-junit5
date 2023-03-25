package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTests {

    private IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    @DisplayName("Test proper view name for index page")
    void index() {
        assertEquals("index", indexController.index());
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {indexController.oupsHandler();});
    }

    @Test
    @Disabled
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {Thread.sleep(2000);
            System.out.println("I got here!");});
    }
    @Test
    @Disabled
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {Thread.sleep(2000);
            System.out.println("I got here again!");});
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("Cristi".equalsIgnoreCase(System.getenv("Cristi")));
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testOnMacOs() {

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testOnWindows() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testOnJava11() {

    }

    @Test
    @EnabledOnJre(JRE.OTHER)
    void testOnJava17() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "cristi")
    void testIfUser() {

    }
}