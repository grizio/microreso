import InputPasswordView from "./inputPassword.stories.svelte"

export default {
  title: "Form/InputPassword",
  argTypes: {
    id: {
      control: "text",
      defaultValue: "my-password"
    },
    name: {
      control: "text",
      defaultValue: "my-password"
    },
    label: {
      control: "text",
      defaultValue: "Your password"
    },
    placeholder: {
      control: "text",
      defaultValue: "Help for strong password"
    },
    value: {
      control: "text",
      defaultValue: ""
    }
  }
}

export const InputPassword = (args) => ({
  Component: InputPasswordView,
  props: args
})