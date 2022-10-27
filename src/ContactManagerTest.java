import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.Assumptions;
 

public class ContactManagerTest {

    private static ContactManager contactManager; 

    public void setup(){
        System.out.println("iniciando contact manager");
        contactManager= new ContactManager();
    }

    @Test
    @DisplayName("Probando crear contacto")
    @RepeatedTest(5)
    @EnabledOnOs(value = OS.WINDOWS, disabledReason="Only available on WINDOWS")
    public void shouldCreateContact() {
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
        contactManager.addContact("John", "Doe", "0123456789");

        assertFalse(contactManager.getAllContacts().isEmpty());

        assertEquals(1, contactManager.getAllContacts().size());

    }

    @Test
    @DisplayName("No es posible crear contacto con nombre igual a nulo")

    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {

        Assertions.assertThrows(RuntimeException.class, () -> {

            contactManager.addContact(null, "Doe", "0123456789");

        });

    }

    @Test
    @DisplayName("No es posible crear contacto con apellido igual a nulo")

    public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {

        Assertions.assertThrows(RuntimeException.class, () -> {

            contactManager.addContact("Jhon", null, "0123456789");

        });

    }    

    @Test
    @DisplayName("No es posible crear contacto con telefono igual a nulo")

    public void shouldThrowRuntimeExceptionWhenTelephoneIsNull() {

        Assertions.assertThrows(RuntimeException.class, () -> {

            contactManager.addContact("Jhon", "Doe", null);

        });

    }


    



}