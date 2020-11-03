import PrimaryIconButtonView from "./icon-primary.stories.svelte"
import {allIconNames} from "../../component/icon/helpers"

export default {
  title: "Button/Icon",
  argTypes: {
    icon: {
      control: {
        type: "inline-radio",
        options: allIconNames
      },
      defaultValue: allIconNames[0]
    },
    mode: {
      control: {
        type: "inline-radio",
        options: ["light", "dark"]
      },
      defaultValue: "light"
    },
    backgroundColor: {
      control: "color",
      defaultValue: "#ffffff"
    }
  }
}

export const PrimaryIconButton = (args) => ({
  Component: PrimaryIconButtonView,
  props: args
})