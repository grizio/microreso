<script lang="ts">
  import {Size, Style, sizeMap} from "./helpers"

  export let size: Size = "medium"
  export let style: Style = "fill"
  export let color: string = "black"
  $: sizeInPx = sizeMap[size]
</script>

{#if style === "fill"}
  <svg width={sizeInPx} height={sizeInPx} viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
    <path fill-rule="evenodd" clip-rule="evenodd" d="M32 0H0V25.6H6.4L3.2 32L12.8 25.6H32V0ZM6.4 16C8.16731 16 9.6 14.5673 9.6 12.8C9.6 11.0327 8.16731 9.6 6.4 9.6C4.63269 9.6 3.2 11.0327 3.2 12.8C3.2 14.5673 4.63269 16 6.4 16ZM19.2 12.8C19.2 14.5673 17.7673 16 16 16C14.2327 16 12.8 14.5673 12.8 12.8C12.8 11.0327 14.2327 9.6 16 9.6C17.7673 9.6 19.2 11.0327 19.2 12.8ZM25.6 16C27.3673 16 28.8 14.5673 28.8 12.8C28.8 11.0327 27.3673 9.6 25.6 9.6C23.8327 9.6 22.4 11.0327 22.4 12.8C22.4 14.5673 23.8327 16 25.6 16Z" fill={color}/>
  </svg>
{:else}
  <svg width={sizeInPx} height={sizeInPx} viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
    <path d="M6.4 16C8.1673 16 9.6 14.5673 9.6 12.8C9.6 11.0327 8.1673 9.6 6.4 9.6C4.6327 9.6 3.2 11.0327 3.2 12.8C3.2 14.5673 4.6327 16 6.4 16Z" fill={color}/>
    <path d="M28.8 12.8C28.8 14.5673 27.3673 16 25.6 16C23.8327 16 22.4 14.5673 22.4 12.8C22.4 11.0327 23.8327 9.6 25.6 9.6C27.3673 9.6 28.8 11.0327 28.8 12.8Z" fill={color}/>
    <path d="M16 16C17.7673 16 19.2 14.5673 19.2 12.8C19.2 11.0327 17.7673 9.6 16 9.6C14.2327 9.6 12.8 11.0327 12.8 12.8C12.8 14.5673 14.2327 16 16 16Z" fill={color}/>
    <path fill-rule="evenodd" clip-rule="evenodd" d="M0 0H32V25.6H12.8L3.2 32L6.4 25.6H0V0ZM2.56 2.56H29.44V23.04H2.56V2.56Z" fill={color}/>
  </svg>
{/if}