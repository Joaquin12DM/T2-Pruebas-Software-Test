Feature: Registro del estudiante en el formulario
  Como estudiante, quiere completar el formulario
  de inscripcion

  Scenario: Registro exitoso con campos obligatorios
    Given el estudiante navega al formulario de práctica
    When el estudiante ingresa "Joaquin" como nombre
    And el estudiante ingresa "Delgado" como apellido
    And el estudiante selecciona "Male" como genero
    And el estudiante ingresa "9861562673" como número móvil
    And el estudiante hace clic en Submit
    Then se debe mostrar el modal de confirmación
    And el título del modal debe ser "Thanks for submitting the form"
    And el modal debe contener "Joaquin Delgado"

  Scenario: Registro con campos adicionales
    Given el estudiante navega al formulario de práctica
    When el estudiante ingresa "Yorky" como nombre
    And el estudiante ingresa "Rivero" como apellido
    And el estudiante ingresa "yorky_rivero@gmail.com" como email
    And el estudiante selecciona "Male" como genero
    And el estudiante ingresa "9876245210" como número móvil
    And el estudiante selecciona el hobby "Reading"
    And el estudiante ingresa "Jro. Huallaga" como dirección
    And el estudiante hace clic en Submit
    Then se debe mostrar el modal de confirmación
    And el título del modal debe ser "Thanks for submitting the form"
    And el modal debe contener "Yorky Rivero"
    And el modal debe contener "yorky_rivero@gmail.com"
    And el modal debe contener "Reading"

Scenario: Validación de formulario incompleto
    Given el estudiante navega al formulario de práctica
    When el estudiante ingresa "Pilar" como nombre
    And el estudiante hace clic en Submit
    Then el campo "lastName" debe tener borde rojo
    And el campo "userNumber" debe tener borde rojo
    And no se debe mostrar el modal de confirmación