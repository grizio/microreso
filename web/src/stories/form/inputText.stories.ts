import InputTextView from "./inputText.stories.svelte"

export default {
  title: "Form/InputText",
  argTypes: {
    id: {
      control: "text",
      defaultValue: "my-input"
    },
    name: {
      control: "text",
      defaultValue: "my-input"
    },
    label: {
      control: "text",
      defaultValue: "Some label"
    },
    placeholder: {
      control: "text",
      defaultValue: "Some placeholder"
    },
    value: {
      control: "text",
      defaultValue: ""
    },
    errorMessage: {
      control: "text",
      defaultValue: ""
    },
  }
}

export const InputText = (args) => ({
  Component: InputTextView,
  props: args
})