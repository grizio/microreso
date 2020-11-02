<script lang="ts">
  type Type = "primary"
  export let type: Type = "primary"
  export let text: string
  export let testId: string | undefined = undefined
</script>

<style>
  .primary {
    --button-background-color: var(--color-primary);
    --button-color: var(--color-grey-lightest);
    --button-box-shadow-color: rgba(35, 63, 88, 0.5);
  }

  button {
    background-color: var(--button-background-color);
    color: var(--button-color);
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
    box-shadow: 0 2px 4px var(--button-box-shadow-color);
  }

  button:active {
    box-shadow: inset 0 2px 4px var(--button-box-shadow-color);
  }
</style>

<button class:primary={type === "primary"} data-test-id={testId}>
  {text}
</button>