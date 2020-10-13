export function canonicalize(value: string): string {
  return value
    .toLowerCase()
    .replace(/[ _'",;.()=/*+-]+/gi, "-")
    .replace(/[^a-z0-9-]/gi, "")
    .replace(/^-/gi, "")
    .replace(/-$/gi, "")
}