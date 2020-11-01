<script>
  import "../../component/styles/Styles.svelte"
  import IconHouse from "../../component/icon/IconHouse.svelte"
  import IconHide from "../../component/icon/IconHide.svelte"
  import IconSee from "../../component/icon/IconSee.svelte"
  import IconPaper from "../../component/icon/IconPaper.svelte"
  import IconCalendar from "../../component/icon/IconCalendar.svelte"
  import IconPlus from "../../component/icon/IconPlus.svelte"
  import IconLock from "../../component/icon/IconLock.svelte"
  import IconChat from "../../component/icon/IconChat.svelte"
  import IconCross from "../../component/icon/IconCross.svelte"
  import IconCheck from "../../component/icon/IconCheck.svelte"
  import IconSearch from "../../component/icon/IconSearch.svelte"

  export let color
  export let backgroundColor
</script>

<style>
  main {
    display: grid;
    grid-template-columns: 100px repeat(6, 50px);
    grid-template-rows: repeat(11, 50px);
    background-color: var(--background-color);
    justify-items: center;
    align-items: center;
    color: var(--color)
  }
</style>

<main class="primitives default-theme" style={`--color: ${color}; --background-color: ${backgroundColor}`}>
  <div>House</div>
  <IconHouse style="fill" size="small" color={color}/>
  <IconHouse style="stroke" size="small" color={color}/>
  <IconHouse style="fill" size="medium" color={color}/>
  <IconHouse style="stroke" size="medium" color={color}/>
  <IconHouse style="fill" size="large" color={color}/>
  <IconHouse style="stroke" size="large" color={color}/>

  <div>Paper</div>
  <IconPaper style="fill" size="small" color={color}/>
  <IconPaper style="stroke" size="small" color={color}/>
  <IconPaper style="fill" size="medium" color={color}/>
  <IconPaper style="stroke" size="medium" color={color}/>
  <IconPaper style="fill" size="large" color={color}/>
  <IconPaper style="stroke" size="large" color={color}/>

  <div>Calendar</div>
  <IconCalendar style="fill" size="small" color={color}/>
  <IconCalendar style="stroke" size="small" color={color}/>
  <IconCalendar style="fill" size="medium" color={color}/>
  <IconCalendar style="stroke" size="medium" color={color}/>
  <IconCalendar style="fill" size="large" color={color}/>
  <IconCalendar style="stroke" size="large" color={color}/>

  <div>Plus</div>
  <IconPlus style="fill" size="small" color={color}/>
  <IconPlus style="stroke" size="small" color={color}/>
  <IconPlus style="fill" size="medium" color={color}/>
  <IconPlus style="stroke" size="medium" color={color}/>
  <IconPlus style="fill" size="large" color={color}/>
  <IconPlus style="stroke" size="large" color={color}/>

  <div>Lock</div>
  <IconLock style="fill" size="small" color={color}/>
  <IconLock style="stroke" size="small" color={color}/>
  <IconLock style="fill" size="medium" color={color}/>
  <IconLock style="stroke" size="medium" color={color}/>
  <IconLock style="fill" size="large" color={color}/>
  <IconLock style="stroke" size="large" color={color}/>

  <div>Chat</div>
  <IconChat style="fill" size="small" color={color}/>
  <IconChat style="stroke" size="small" color={color}/>
  <IconChat style="fill" size="medium" color={color}/>
  <IconChat style="stroke" size="medium" color={color}/>
  <IconChat style="fill" size="large" color={color}/>
  <IconChat style="stroke" size="large" color={color}/>

  <div>Cross</div>
  <IconCross style="fill" size="small" color={color}/>
  <IconCross style="stroke" size="small" color={color}/>
  <IconCross style="fill" size="medium" color={color}/>
  <IconCross style="stroke" size="medium" color={color}/>
  <IconCross style="fill" size="large" color={color}/>
  <IconCross style="stroke" size="large" color={color}/>

  <div>Check</div>
  <IconCheck style="fill" size="small" color={color}/>
  <IconCheck style="stroke" size="small" color={color}/>
  <IconCheck style="fill" size="medium" color={color}/>
  <IconCheck style="stroke" size="medium" color={color}/>
  <IconCheck style="fill" size="large" color={color}/>
  <IconCheck style="stroke" size="large" color={color}/>

  <div>See</div>
  <IconSee style="fill" size="small" color={color}/>
  <IconSee style="stroke" size="small" color={color}/>
  <IconSee style="fill" size="medium" color={color}/>
  <IconSee style="stroke" size="medium" color={color}/>
  <IconSee style="fill" size="large" color={color}/>
  <IconSee style="stroke" size="large" color={color}/>

  <div>Hide</div>
  <IconHide style="fill" size="small" color={color}/>
  <IconHide style="stroke" size="small" color={color}/>
  <IconHide style="fill" size="medium" color={color}/>
  <IconHide style="stroke" size="medium" color={color}/>
  <IconHide style="fill" size="large" color={color}/>
  <IconHide style="stroke" size="large" color={color}/>

  <div>Search</div>
  <IconSearch style="fill" size="small" color={color}/>
  <IconSearch style="stroke" size="small" color={color}/>
  <IconSearch style="fill" size="medium" color={color}/>
  <IconSearch style="stroke" size="medium" color={color}/>
  <IconSearch style="fill" size="large" color={color}/>
  <IconSearch style="stroke" size="large" color={color}/>
</main>
