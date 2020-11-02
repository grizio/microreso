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
    <path d="M10.5595 16L0 26.4892L5.33333 31.787L15.8928 21.2978L26.6667 32L32 26.7022L21.2261 16L32 5.29783L26.6667 0L15.8928 10.7022L5.33333 0.212985L0 5.51082L10.5595 16Z" fill={color}/>
  </svg>
{:else}
  <svg width={sizeInPx} height={sizeInPx} viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
    <path d="M11.2642 16.7095L11.9784 16L11.2642 15.2905L1.41896 5.51082L5.33333 1.6225L15.1881 11.4116L15.8928 12.1117L16.5975 11.4116L26.6667 1.40952L30.581 5.29783L20.5214 15.2905L19.8072 16L20.5214 16.7095L30.581 26.7022L26.6667 30.5905L16.5975 20.5884L15.8928 19.8883L15.1881 20.5884L5.33333 30.3775L1.41896 26.4892L11.2642 16.7095Z" stroke={color} stroke-width="2"/>
  </svg>
{/if}