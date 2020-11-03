<script>
  import "../../component/styles/Styles.svelte"
  import TextButton from "../../component/button/TextButton.svelte"
  import InputText from "../../component/form/InputText.svelte"

  export let id
  export let name
  export let label
  export let placeholder
  export let value
  export let errorMessage
</script>

<main class="primitives default-theme">
  <InputText {id} {name} {label} {placeholder} {value} {errorMessage} />
</main>
