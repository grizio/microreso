<script>
  import "../../component/styles/Styles.svelte"
  import TextButton from "../../component/button/TextButton.svelte"

  export let text
</script>

<main class="primitives default-theme">
  <TextButton type="primary" {text} />
</main>
