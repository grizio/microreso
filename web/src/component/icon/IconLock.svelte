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
    <path fill-rule="evenodd" clip-rule="evenodd" d="M6.4 5.12C6.4 2.2923 10.6981 0 16 0C21.3019 0 25.6 2.2923 25.6 5.12V12.8H32V32H0V12.8H6.4V5.12ZM23.04 5.12C23.04 5.11186 22.9916 4.50941 21.5835 3.75844C20.2855 3.06613 18.3158 2.56 16 2.56C13.6842 2.56 11.7145 3.06613 10.4165 3.75844C9.00841 4.50941 8.96 5.11186 8.96 5.12V12.8H23.04V5.12ZM19.2 20.48C19.2 21.2005 18.9619 21.8654 18.56 22.4003V25.6C18.56 27.0138 17.4138 28.16 16 28.16C14.5862 28.16 13.44 27.0138 13.44 25.6V22.4003C13.0381 21.8654 12.8 21.2005 12.8 20.48C12.8 18.7127 14.2327 17.28 16 17.28C17.7673 17.28 19.2 18.7127 19.2 20.48Z" fill={color}/>
  </svg>
{:else}
  <svg width={sizeInPx} height={sizeInPx} viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
    <path d="M19.2 20.48C19.2 21.2005 18.9619 21.8654 18.56 22.4003V25.6C18.56 27.0138 17.4138 28.16 16 28.16C14.5862 28.16 13.44 27.0138 13.44 25.6V22.4003C13.0381 21.8654 12.8 21.2005 12.8 20.48C12.8 18.7127 14.2327 17.28 16 17.28C17.7673 17.28 19.2 18.7127 19.2 20.48Z" fill={color}/>
    <path fill-rule="evenodd" clip-rule="evenodd" d="M16 0C10.6981 0 6.4 2.2923 6.4 5.12V12.8H0V32H32V12.8H25.6V5.12C25.6 2.2923 21.3019 0 16 0ZM21.5835 3.75844C22.9916 4.50941 23.04 5.11186 23.04 5.12V12.8H8.96V5.12C8.96 5.11186 9.00841 4.50941 10.4165 3.75844C11.7145 3.06613 13.6842 2.56 16 2.56C18.3158 2.56 20.2855 3.06613 21.5835 3.75844ZM29.44 15.36V29.44H2.56V15.36H29.44Z" fill={color}/>
  </svg>
{/if}