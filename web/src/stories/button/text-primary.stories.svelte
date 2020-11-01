<script>
  import "../../component/styles/Styles.svelte"
  import PrimaryButton from "../../component/button/PrimaryButton.svelte"

  export let text
</script>

<main class="primitives default-theme">
  <PrimaryButton {text} />
</main>
