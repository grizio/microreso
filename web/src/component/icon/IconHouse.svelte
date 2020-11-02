<script lang="ts">
  import type {Size, Style} from "./helpers"
  import {sizeMap} from "./helpers"

  export let size: Size = "medium"
  export let style: Style = "fill"
  export let color: string = "black"
  $: sizeInPx = sizeMap[size]
</script>

{#if style === "fill"}
  <svg width={sizeInPx} height={sizeInPx} viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
    <path d="M32 12.8L16 0L0 12.8H3.2V32H28.8V12.8H32Z" fill={color}/>
  </svg>
{:else}
  <svg width={sizeInPx} height={sizeInPx} viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
    <path d="M4.2 12.8V11.8H3.2H2.85078L16 1.28062L29.1492 11.8H28.8H27.8V12.8V31H4.2V12.8Z" stroke={color} stroke-width="2"/>
  </svg>
{/if}