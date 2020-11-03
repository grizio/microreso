export type Size = "small" | "medium" | "large"
export type Style = "fill" | "stroke"
export type Mode = "dark" | "light"

export const sizeMap: Record<Size, number> = {
  small: 16,
  medium: 24,
  large: 32
}

export type IconName =
  | "calendar"
  | "chat"
  | "check"
  | "cross"
  | "hide"
  | "house"
  | "lock"
  | "paper"
  | "plus"
  | "search"
  | "see"

export const allIconNames: Array<IconName> = [
  "calendar",
  "chat",
  "check",
  "cross",
  "hide",
  "house",
  "lock",
  "paper",
  "plus",
  "search",
  "see"
]