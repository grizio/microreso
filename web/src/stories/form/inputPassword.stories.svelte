<script>
  import "../../component/styles/Styles.svelte"
  import InputPassword from "../../component/form/InputPassword.svelte"

  export let id
  export let name
  export let label
  export let placeholder
  export let value
</script>

<main class="primitives default-theme">
  <InputPassword {id} {name} {label} {placeholder} {value} />
</main>
