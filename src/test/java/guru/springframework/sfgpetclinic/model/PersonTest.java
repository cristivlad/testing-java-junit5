package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTest {

    @Test
    void groupedAssertions() {
        Person person = new Person(1l, "Joe", "Buck");

        assertAll("Test props set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Buck", person.getLastName()));
    }

    @RepeatedTest(10)
    void myRepeatedTest() {
        // toDo
    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    @DisplayName("My repeated test")
    @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition}")
    void myRepeatedTestWithCustomizeName() {
        //toDo
    }
}