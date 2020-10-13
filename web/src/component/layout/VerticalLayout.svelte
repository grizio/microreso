<script lang="ts">
  export let gap: 2 | 4 | 8 | 12 | 16 | 20 | 24 | 28
</script>

<style>
  div {
    display: grid;
    row-gap: var(--vertical-layout-gap);
  }
</style>

<div style="--vertical-layout-gap: {gap}px">
  <slot />
</div>