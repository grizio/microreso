<script lang="ts">
  import Icon from "../icon/Icon.svelte"
  import type {IconName, Style, Mode} from "../icon/helpers"
  type Type = "primary"

  export let icon: IconName
  export let style: Style
  export let mode: Mode
  export let type: Type = "primary"
</script>

<style>
  .primary {
    --button-color: var(--color-primary);
    --button-box-color: rgba(35, 63, 88, 0.5);
  }

  .light.stroke {
    --button-border-color: var(--button-color);
    --button-background-color: transparent;
    --color-icon: var(--button-color);
  }

  .light.fill {
    --button-border-color: transparent;
    --button-background-color: var(--button-color);
    --color-icon: var(--color-grey-lightest);
  }

  .dark.stroke {
    --button-border-color: var(--color-grey-lightest);
    --button-background-color: transparent;
    --color-icon: var(--color-grey-lightest);
  }

  .dark.fill {
    --button-border-color: transparent;
    --button-background-color: var(--color-grey-lightest);
    --color-icon: var(--button-color);
  }

  button {
    background-color: var(--button-background-color);
    border: 1px solid var(--button-border-color);
    cursor: pointer;
    border-radius: 100%;
    padding: 0 10px;
    /* TODO: several sizes */
    width: 50px;
    height: 50px;
    line-height: 50px;
    display: flex;
    justify-content: center;
    align-items: center;

    transition: box-shadow ease-in-out 250ms;
  }

  button.light:hover {
    box-shadow: 0 2px 4px var(--button-box-color);
  }

  button.dark:hover {
    box-shadow: 0 2px 4px var(--color-grey-lightest);
  }

  button.light:active {
    box-shadow: inset 0 2px 4px var(--button-box-color);
  }

  button.dark:active {
    box-shadow: inset 0 2px 4px var(--color-grey-dark);
  }
</style>

<button
  class:primary={type === "primary"}
  class:light={mode === "light"}
  class:dark={mode === "dark"}
  class:stroke={style === "stroke"}
  class:fill={style === "fill"}
>
  <Icon {icon} {style} size="large" color={"var(--color-icon)"} />
</button>