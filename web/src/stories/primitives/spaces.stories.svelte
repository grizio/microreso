<script>
  import "../../component/styles/Styles.svelte"
</script>

<style>
  .main {
    display: grid;
    grid-template-columns: 100px 100px;
    grid-template-rows: repeat(10, 30px);
    grid-gap: 25px 25px;
    align-items: center;
  }

  .space {
    background-color: var(--color-grey-darkest);
    width: var(--size);
    height: var(--size);
  }
</style>

<h1>Colors</h1>

<div class="main primitives">
  <div class="group-title">--space-2</div>
  <div><div class="space" style="--size: var(--space-2)"></div></div>

  <div class="group-title">--space-4</div>
  <div><div class="space" style="--size: var(--space-4)"></div></div>

  <div class="group-title">--space-8</div>
  <div><div class="space" style="--size: var(--space-8)"></div></div>

  <div class="group-title">--space-12</div>
  <div><div class="space" style="--size: var(--space-12)"></div></div>

  <div class="group-title">--space-16</div>
  <div><div class="space" style="--size: var(--space-16)"></div></div>

  <div class="group-title">--space-20</div>
  <div><div class="space" style="--size: var(--space-20)"></div></div>

  <div class="group-title">--space-24</div>
  <div><div class="space" style="--size: var(--space-24)"></div></div>

  <div class="group-title">--space-28</div>
  <div><div class="space" style="--size: var(--space-28)"></div></div>
</div>