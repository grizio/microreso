export function write(id: string, value: string) {
  cy.get(`#${id}`).type(value)
}

export function hasValue(id: string, value: string) {
  cy.get(`#${id}`).should("have.value", value)
}