<script lang="ts">
  export let text: string
</script>

<style>
  button {
    background-color: var(--color-primary);
    color: var(--color-grey-lightest);
    font-size: var(--font-size-base);
    cursor: pointer;
    border: none;
    border-radius: 4px;
    padding: 0 10px;
    height: 30px;
    line-height: 30px;
    transition: box-shadow ease-in-out 250ms;
  }

  button:hover {
    box-shadow: 0 2px 4px rgba(35, 63, 88, 0.5);
  }

  button:active {
    box-shadow: inset 0 2px 4px rgba(35, 63, 88, 0.5);
  }
</style>

<button>
  {text}
</button>