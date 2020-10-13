<script lang="ts">
  import {createEventDispatcher, onMount} from "svelte"

  export let id: string
  export let name: string
  export let label: string
  export let placeholder: string
  export let value: string
  export let errorMessage: string | undefined

  let initialValue: string
  let updated: boolean
  let className: string = ""

  $: {
    if (errorMessage !== undefined) {
      className = "error"
    } else if (updated) {
      className = "success"
    } else {
      className = ""
    }
  }

  const dispatch = createEventDispatcher()

  onMount(() => {
    initialValue = value
    updated = false
  })

  function onValueChanged(event: InputEvent) {
    const input = event.target as HTMLInputElement
    dispatch("change", {
      value: input.value
    })
  }

  function onBlur() {
    if (value !== initialValue) {
      updated = true
    }
  }
</script>

<style>
  div {
    display: flex;
    flex-direction: column-reverse;
  }

  /* Base */
  input {
    color: var(--color-text);
    border: 1px solid var(--color-grey-light);
    padding: var(--space-4);
    transition: all ease-in-out 250ms;
    outline: none;
  }

  input::placeholder {
    color: var(--color-grey-light);
    font-style: italic;
  }

  label {
    color: var(--color-text);
    display: block;
    transition: all ease-in-out 250ms;
  }

  /* Focus */
  input:focus {
    color: var(--color-primary);
    border: 1px solid var(--color-blue-light);
    box-shadow: inset 0 0 4px rgba(107, 154, 196, 0.5);
  }

  input:focus::placeholder {
    color: var(--color-blue-light);
  }

  input:focus + label {
    color: var(--color-primary);
  }

  /* Success */
  div.success input {
    color: var(--color-green-dark);
    border: 1px solid var(--color-green-dark);
  }

  div.success input::placeholder {
    color: var(--color-green-dark);
  }

  div.success label {
    color: var(--color-green-dark);
  }

  /* Success / Focus */
  div.success input:focus {
    box-shadow: inset 0 0 4px rgba(81, 152, 114, 0.5);
  }

  /* Error */
  div.error input {
    color: var(--color-red-dark);
    border: 1px solid var(--color-red-dark);
  }

  div.error input::placeholder {
    color: var(--color-red-light);
  }

  div.error label {
    color: var(--color-red-dark);
  }

  div.error .context {
    color: var(--color-red-lighter);
    font-style: italic;
  }

  /* Error / Focus */
  div.error input:focus {
    box-shadow: inset 0 0 4px rgba(219, 22, 47, 0.5);
  }
</style>

<div class={className}>
  {#if errorMessage !== undefined}
    <span class="context">{errorMessage}</span>
  {/if}
  <input
    type="text"
    {name} {id} {placeholder}
    bind:value={value}
    on:input={onValueChanged}
    on:blur={onBlur}
  />
  <label for={id}>{label}</label>
</div>