package org.cibertec.t2examenps.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PracticeFormPage extends PageObject {

    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By mobileField = By.id("userNumber");
    private By currentAddressField = By.id("currentAddress");
    private By submitButton = By.id("submit");
    private By modalContent = By.className("modal-content");
    private By modalTitle = By.id("example-modal-sizes-title-lg");
    private By modalBody = By.className("modal-body");

    public void openPage() {
        openUrl("https://demoqa.com/automation-practice-form");
        scrollToTop();
    }

    public void enterFirstName(String nombre) {
        scrollToElement(firstNameField);
        $(firstNameField).type(nombre);
    }

    public void enterLastName(String apellido) {
        scrollToElement(lastNameField);
        $(lastNameField).type(apellido);
    }

    public void enterEmail(String email) {
        scrollToElement(emailField);
        $(emailField).type(email);
    }

    public void selectGender(String genero) {
        WebElement genderLabel = $("//label[contains(text(),'" + genero + "')]");
        scrollToElement(genderLabel);
        clickWithJS(genderLabel);
    }

    public void enterMobile(String numero) {
        scrollToElement(mobileField);
        $(mobileField).type(numero);
    }

    public void selectHobby(String hobby) {
        WebElement hobbyLabel = $("//label[contains(text(),'" + hobby + "')]");
        scrollToElement(hobbyLabel);
        clickWithJS(hobbyLabel);
    }

    public void enterAddress(String direccion) {
        scrollToElement(currentAddressField);
        $(currentAddressField).type(direccion);
    }

    public void clickSubmit() {
        WebElement button = $(submitButton);
        scrollToElement(button);
        clickWithJS(button);
    }

    public boolean isModalDisplayed() {
        return $(modalContent).isVisible();
    }

    public String getModalTitle() {
        return $(modalTitle).getText();
    }

    public boolean modalContains(String contenido) {
        return $(modalBody).getText().contains(contenido);
    }

    public boolean hasRedBorder(String fieldId) {
        waitABit(200);
        String borderColor = $(By.id(fieldId)).getCssValue("border-color");
        return borderColor.contains("220, 53, 69") ||
                borderColor.contains("rgb(220, 53, 69)");
    }

    public boolean isModalNotDisplayed() {
        waitABit(600);
        return !$(modalContent).isCurrentlyVisible();
    }

    private void scrollToElement(By locator) {
        WebElement element = $(locator);
        scrollToElement(element);
    }

    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    private void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, 0);");
    }

    private void clickWithJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }
}
