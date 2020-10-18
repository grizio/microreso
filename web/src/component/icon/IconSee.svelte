<script lang="ts">
  export let size: 15 | 25 = 25
</script>

<style>
  .icon {
    width: var(--size);
    height: var(--size);
    font-size: var(--size);
  }
</style>

<span class="icon" style={`--size: icon-size-${size}`}>
  &#x1F440;
</span>