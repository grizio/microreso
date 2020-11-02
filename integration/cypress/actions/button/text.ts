export function click(testId: string) {
  cy.get(`[data-test-id=${testId}]`).click()
}