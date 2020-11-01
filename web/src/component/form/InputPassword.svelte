<script lang="ts">
  import {createEventDispatcher} from "svelte"
  import IconSee from "../icon/IconSee.svelte"
  import IconHide from "../icon/IconHide.svelte"

  export let id: string
  export let name: string
  export let label: string
  export let placeholder: string
  export let value: string

  const min = 0
  const low = 30
  const high = 60
  const max = 100

  let visible: boolean = false
  let focus: boolean = false

  $: strength = computeStrength(value)

  function computeStrength(value: string): number {
    let multiplicity = 0
    if (value.match(/[a-z]/g)) {
      multiplicity += 1
    }
    if (value.match(/[A-Z]/g)) {
      multiplicity += 1
    }
    if (value.match(/[0-9]/g)) {
      multiplicity += 1
    }
    if (value.match(/[^a-zA-Z0-9]/g)) {
      multiplicity += 1
    }
    return multiplicity * value.length
  }

  const dispatch = createEventDispatcher()

  function onFocus() {
    focus = true
  }

  function onBlur() {
    focus = false
  }

  function toggleVisible(event) {
    event.preventDefault()
    visible = !visible
  }

  function onValueChanged(event: InputEvent) {
    const input = event.target as HTMLInputElement
    dispatch("change", {
      value: input.value
    })
  }
</script>

<style>
  div {
    display: flex;
    flex-direction: column;
  }

  .empty {
    --input-color-text: var(--color-text);
    --input-color-border: var(--color-grey-light);
    --input-color-context: var(--color-grey-light);
  }

  .focus.empty {
    --input-color-text: var(--color-primary);
    --input-color-border: var(--color-blue-light);
    --input-color-context: var(--color-blue-light);
    --input-color-shadow: var(--color-blue-darker-50);
  }

  .weak {
    --input-color-text: var(--color-red-dark);
    --input-color-border: var(--color-red-dark);
    --input-color-context: var(--color-red-lighter);
    --input-color-shadow: var(--color-red-dark-50);
  }

  .medium {
    --input-color-text: var(--color-yellow-light);
    --input-color-border: var(--color-yellow-light);
    --input-color-context: var(--color-yellow-light);
    --input-color-shadow: var(--color-yellow-light-50);
  }

  .strong {
    --input-color-text: var(--color-green-dark);
    --input-color-border: var(--color-green-dark);
    --input-color-context: var(--color-green-dark);
    --input-color-shadow: var(--color-green-dark-50);
  }

  /* Base */
  div > label {
    color: var(--input-color-text);
    display: block;
    transition: all ease-in-out 250ms;
  }

  .input {
    border: 1px solid var(--input-color-border);
    display: grid;
    grid-template-columns: auto var(--icon-size-16);
    grid-column-gap: var(--space-4);
    padding: var(--space-4);
    align-items: center;
    transition: all ease-in-out 250ms;
  }

  input {
    color: var(--input-color-text);
    border: none;
    outline: none;
  }

  input::placeholder {
    color: var(--input-color-context);
    font-style: italic;
  }

  .context {
    font-style: italic;
    font-size: var(--font-size-context);
    color: var(--input-color-context);
  }

  .focus .input {
    box-shadow: inset 0 0 4px var(--input-color-shadow);
  }

  meter, meter::-webkit-meter-bar {
    background: var(--color-grey-lighter);
  }

  meter:-moz-meter-sub-sub-optimum::-moz-meter-bar, meter::-webkit-meter-even-less-good-value {
    background: var(--color-red-dark);
  }

  meter:-moz-meter-sub-optimum::-moz-meter-bar, meter::-webkit-meter-suboptimum-value {
    background: var(--color-yellow-light);
  }

  meter:-moz-meter-optimum::-moz-meter-bar, meter::-webkit-meter-optimum-value {
    background: var(--color-green-dark);
  }

  button {
    padding: 0;
    margin: 0;
    border: none;
    background: none;
    cursor: pointer;
  }
</style>

<div
  class:focus={focus}
  class:empty={strength === min}
  class:weak={strength > min && strength < low}
  class:medium={strength >= low && strength < high}
  class:strong={strength >= high}
>
  <label for={id}>{label}</label>
  <div class="input">
    {#if visible}
      <input
        type="text"
        {name} {id} {placeholder}
        bind:value={value}
        on:input={onValueChanged}
        on:focus={onFocus}
        on:blur={onBlur}
      />
    {:else}
      <input
        type="password"
        {name} {id} {placeholder}
        bind:value={value}
        on:input={onValueChanged}
        on:focus={onFocus}
        on:blur={onBlur}
      />
    {/if}
    <button on:click={toggleVisible}>
      {#if visible}
        <IconSee size="15"/>
      {:else}
        <IconHide size="15"/>
      {/if}
    </button>
  </div>
  <meter {min} {low} {high} optimum={max} {max} value={Math.min(max, strength)}
         style={`--input-meter-size: ${strength}%`}>
    Strength: {Math.min(max, strength)}%
  </meter>

  <span class="context">
    Use capital letters, numbers, spaces and symbols (%#) to increase the strength
  </span>
</div>