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
    <path d="M19.2 0H12.8V12.8H0V19.2H12.8V32H19.2V19.2H32V12.8H19.2V0Z" fill={color}/>
  </svg>
{:else}
  <svg width={sizeInPx} height={sizeInPx} viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
    <path d="M12.8 13.8H13.8V12.8V1H18.2V12.8V13.8H19.2H31V18.2H19.2H18.2V19.2V31H13.8V19.2V18.2H12.8H1V13.8H12.8Z" stroke={color} stroke-width="2"/>
  </svg>
{/if}