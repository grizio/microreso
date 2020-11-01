import PrimaryTextButtonView from "./text-primary.stories.svelte"

export default {
  title: "Buttons",
  argTypes: {
    text: {
      control: "text",
      defaultValue: "Some text inside"
    },
  }
}

export const PrimaryTextButton = (args) => ({
  Component: PrimaryTextButtonView,
  props: {
    text: args.text
  }
})
