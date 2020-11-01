import ColorsView from './colors.stories.svelte'
import TypographyView from './typography.stories.svelte'
import SpacesView from './spaces.stories.svelte'

export default {
  title: 'Primitives'
}

export const Colors = () => ({
  Component: ColorsView
})

export const Typography = () => ({
  Component: TypographyView
})

export const Spaces = () => ({
  Component: SpacesView
})