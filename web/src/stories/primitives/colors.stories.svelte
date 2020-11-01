<script>
  import "../../component/styles/Styles.svelte"
</script>

<style>
  .main {
    display: grid;
    grid-template-columns: 100px repeat(6, 50px);
    grid-template-rows: repeat(10, 50px);
    grid-gap: 25px 25px;
  }

  .border {
    border: 1px solid black;
  }

  .group-title {
    align-self: center;
  }
</style>

<h1>Colors</h1>

<div class="main primitives">
  <div class="group-title">Black</div>
  <div style="background-color: var(--color-grey-darkest)" title="--color-grey-darkest"></div>
  <div style="background-color: var(--color-grey-darker)" title="--color-grey-darker"></div>
  <div style="background-color: var(--color-grey-dark)" title="--color-grey-dark"></div>
  <div style="background-color: var(--color-grey-light)" title="--color-grey-light"></div>
  <div style="background-color: var(--color-grey-lighter)" title="--color-grey-lighter"></div>
  <div class="border" style="background-color: var(--color-grey-lightest)"></div>

  <div class="group-title">Blue</div>
  <div style="background-color: var(--color-blue-darkest)" title="--color-blue-darkest"></div>
  <div style="background-color: var(--color-blue-darker)" title="--color-blue-darker"></div>
  <div style="background-color: var(--color-blue-dark)" title="--color-blue-dark"></div>
  <div style="background-color: var(--color-blue-light)" title="--color-blue-light"></div>
  <div style="background-color: var(--color-blue-lighter)" title="--color-blue-lighter"></div>
  <div style="background-color: var(--color-blue-lightest)" title="--color-blue-lightest"></div>

  <div class="group-title">Green</div>
  <div style="background-color: var(--color-green-darkest)" title="--color-green-darkest"></div>
  <div style="background-color: var(--color-green-darker)" title="--color-green-darker"></div>
  <div style="background-color: var(--color-green-dark)" title="--color-green-dark"></div>
  <div style="background-color: var(--color-green-light)" title="--color-green-light"></div>
  <div style="background-color: var(--color-green-lighter)" title="--color-green-lighter"></div>
  <div style="background-color: var(--color-green-lightest)" title="--color-green-lightest"></div>

  <div class="group-title">Yellow</div>
  <div style="background-color: var(--color-yellow-darkest)" title="--color-yellow-darkest"></div>
  <div style="background-color: var(--color-yellow-darker)" title="--color-yellow-darker"></div>
  <div style="background-color: var(--color-yellow-dark)" title="--color-yellow-dark"></div>
  <div style="background-color: var(--color-yellow-light)" title="--color-yellow-light"></div>
  <div style="background-color: var(--color-yellow-lighter)" title="--color-yellow-lighter"></div>
  <div style="background-color: var(--color-yellow-lightest)" title="--color-yellow-lightest"></div>

  <div class="group-title">Red</div>
  <div style="background-color: var(--color-red-darkest)" title="--color-red-darkest"></div>
  <div style="background-color: var(--color-red-darker)" title="--color-red-darker"></div>
  <div style="background-color: var(--color-red-dark)" title="--color-red-dark"></div>
  <div style="background-color: var(--color-red-light)" title="--color-red-light"></div>
  <div style="background-color: var(--color-red-lighter)" title="--color-red-lighter"></div>
  <div style="background-color: var(--color-red-lightest)" title="--color-red-lightest"></div>

  <div class="group-title">Background</div>
  <div class="border" style="background-color: var(--color-background)" title="--color-background"></div>
</div>