<script>
  import "../../component/styles/Styles.svelte"
  import IconButton from "../../component/button/IconButton.svelte"

  export let icon
  export let mode
  export let backgroundColor
</script>

<style>
  main {
    background-color: var(--background-color);
    display: grid;
    grid-template-columns: 100px 100px;
    padding: var(--space-28)
  }
</style>

<main class="primitives default-theme " style={`--background-color: ${backgroundColor}`}>
  <IconButton type="primary" {icon} {mode} style="fill" />
  <IconButton type="primary" {icon} {mode} style="stroke" />
</main>
