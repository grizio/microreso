<script lang="ts">
  import {Size, Style, sizeMap} from "./helpers"

  export let size: Size = "medium"
  export let style: Style = "fill"
  export let color: string = "black"
  $: sizeInPx = sizeMap[size]
</script>

{#if style === "fill"}
  <svg width={sizeInPx} height={sizeInPx} viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
    <path d="M20.3678 24.9875L20.495 25.0639L16.6498 32L0 21.9886L3.84512 15.0525L13.7079 20.9829L25.3401 0L32 4.00456L20.3678 24.9875Z" fill={color}/>
  </svg>
{:else}
  <svg width={sizeInPx} height={sizeInPx} viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
    <path d="M19.9305 24.745L19.6965 25.1672L19.8236 25.2437L16.4637 31.3046L0.671342 21.8089L4.03131 15.7479L13.4502 21.4114L13.8941 21.6783L14.1452 21.2253L25.5263 0.695384L31.3287 4.18431L19.9305 24.745Z" stroke={color}/>
  </svg>
{/if}