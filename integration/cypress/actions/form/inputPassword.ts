export function write(id: string, value: string) {
  cy.get(`#${id}`).type(value)
}

export function hasValue(id: string, value: string) {
  cy.get(`#${id}`).should("have.value", value)
}

export function isStrong(id: string) {
  cy.get(`[data-test-id=${id}-container]`).should("have.class", "strong")
}