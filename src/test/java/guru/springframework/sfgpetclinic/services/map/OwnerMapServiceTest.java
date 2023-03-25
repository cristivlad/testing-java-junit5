package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Owner map service test -")
class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);
    }

    @DisplayName("Verify zero owners")
    @Test
    void ownersAreZero() {
        int ownerCount = ownerMapService.findAll().size();

        assertEquals(0, ownerCount);
    }

    @DisplayName("Pet type -")
    @Nested
    class TestCreatePetTypes {
        @BeforeEach
        void setup() {
            PetType petType1 = new PetType(1l, "Dog");
            PetType petType2 = new PetType(2l, "Cat");
            petTypeService.save(petType1);
            petTypeService.save(petType2);
        }

        @Test
        void testPetCount() {
            int petTypeCount = petTypeService.findAll().size();

            assertEquals(2, petTypeCount);
        }
    }

    @DisplayName("Verify still zero owners")
    @Test
    void ownersAreStillZero() {
        int ownerCount = ownerMapService.findAll().size();

        assertEquals(0, ownerCount);
    }
}