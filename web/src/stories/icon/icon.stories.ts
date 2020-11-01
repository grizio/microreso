import IconsView from "./icon.stories.svelte"

export default {
  title: "Icons",
  argTypes: {
    backgroundColor: {
      control: "color",
      defaultValue: "#ffffff"
    },
    color: {
      control: "color",
      defaultValue: "#000000"
    },
  }
}

export const View = (args) => ({
  Component: IconsView,
  props: args
})
