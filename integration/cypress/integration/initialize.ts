import * as actions from "../actions"

context("Initialize", () => {
  beforeEach(() => {
    cy.visit(Cypress.config().baseUrl)
  })

  it("fill the form and return", () => {
    actions.form.inputText.write("initialize-name", "My Microreso")
    actions.form.inputText.hasValue("initialize-code", "my-microreso")
    actions.form.inputText.write("initialize-email", "iam@the.boss")
    actions.form.inputText.write("initialize-username", "theboss")
    actions.form.inputPassword.write("initialize-password", "This password is strong enough!")
    actions.form.inputPassword.isStrong("initialize-password")
    actions.button.text.click("initialize-submit")
    cy.get("h1").should("have.text", "Microreso")
  })
})
