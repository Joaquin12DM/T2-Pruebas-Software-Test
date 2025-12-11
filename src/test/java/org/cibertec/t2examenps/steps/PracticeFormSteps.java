package org.cibertec.t2examenps.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import org.cibertec.t2examenps.pages.PracticeFormPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class PracticeFormSteps {

    @Managed
    WebDriver driver;

    PracticeFormPage practiceFormPage;

    @Given("el estudiante navega al formulario de práctica")
    public void elEstudianteNavegaAlFormularioDePractica() {
        practiceFormPage.openPage();
    }

    @When("el estudiante ingresa {string} como nombre")
    public void elEstudianteIngresaComoNombre(String nombre) {
        practiceFormPage.enterFirstName(nombre);
    }

    @And("el estudiante ingresa {string} como apellido")
    public void elEstudianteIngresaComoApellido(String apellido) {
        practiceFormPage.enterLastName(apellido);
    }

    @And("el estudiante ingresa {string} como email")
    public void elEstudianteIngresaComoEmail(String email) {
        practiceFormPage.enterEmail(email);
    }

    @And("el estudiante selecciona {string} como genero")
    public void elEstudianteSeleccionaComoGenero(String genero) {
        practiceFormPage.selectGender(genero);
    }

    @And("el estudiante ingresa {string} como número móvil")
    public void elEstudianteIngresaComoNumeroMovil(String numero) {
        practiceFormPage.enterMobile(numero);
    }

    @And("el estudiante selecciona el hobby {string}")
    public void elEstudianteSeleccionaElHobby(String hobby) {
        practiceFormPage.selectHobby(hobby);
    }

    @And("el estudiante ingresa {string} como dirección")
    public void elEstudianteIngresaComoDireccion(String direccion) {
        practiceFormPage.enterAddress(direccion);
    }

    @And("el estudiante hace clic en Submit")
    public void elEstudianteHaceClicEnSubmit() {
        practiceFormPage.clickSubmit();
    }

    @Then("se debe mostrar el modal de confirmación")
    public void seDebeMostrarElModalDeConfirmacion() {
        assertTrue(practiceFormPage.isModalDisplayed(), "El modal de confirmación no se mostró");
    }

    @And("el título del modal debe ser {string}")
    public void elTituloDelModalDebeSer(String tituloEsperado) {
        assertEquals(tituloEsperado, practiceFormPage.getModalTitle(), "El título del modal no coincide");
    }

    @And("el modal debe contener {string}")
    public void elModalDebeContener(String contenido) {
        assertTrue(practiceFormPage.modalContains(contenido),
                "El modal no contiene el texto esperado: " + contenido);
    }

    @Then("el campo {string} debe tener borde rojo")
    public void elCampoDebeTenerBordeRojo(String fieldId) {
        assertTrue(practiceFormPage.hasRedBorder(fieldId),
                String.format("El campo '%s' debería tener borde rojo", fieldId));
    }

    @And("no se debe mostrar el modal de confirmación")
    public void noSeDebeMostrarElModalDeConfirmacion() {
        assertTrue(practiceFormPage.isModalNotDisplayed(), "El modal no debería estar visible");
    }
}