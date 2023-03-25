package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("model")
public interface ModelTest {

    @BeforeEach
    default void beforeEachConsoleOutput(TestInfo testInfo) {
        System.out.println("Running test - " + testInfo.getDisplayName());
    }
}
