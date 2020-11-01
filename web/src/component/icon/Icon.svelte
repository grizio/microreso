<script lang="ts">
  import {IconName, Size, Style} from "./helpers"
  import IconCalendar from "./IconCalendar.svelte"
  import IconChat from "./IconChat.svelte"
  import IconCheck from "./IconCheck.svelte"
  import IconCross from "./IconCross.svelte"
  import IconHide from "./IconHide.svelte"
  import IconHouse from "./IconHouse.svelte"
  import IconLock from "./IconLock.svelte"
  import IconPaper from "./IconPaper.svelte"
  import IconPlus from "./IconPlus.svelte"
  import IconSearch from "./IconSearch.svelte"
  import IconSee from "./IconSee.svelte"

  export let icon: IconName
  export let size: Size = "medium"
  export let style: Style = "fill"
  export let color: string = "black"

  console.log("icon = ", icon)
</script>

{#if icon === "calendar"}
  <IconCalendar {size} {style} {color}/>
{:else if icon === "chat"}
  <IconChat {size} {style} {color}/>
{:else if icon === "check"}
  <IconCheck {size} {style} {color}/>
{:else if icon === "cross"}
  <IconCross {size} {style} {color}/>
{:else if icon === "hide"}
  <IconHide {size} {style} {color}/>
{:else if icon === "house"}
  <IconHouse {size} {style} {color}/>
{:else if icon === "lock"}
  <IconLock {size} {style} {color}/>
{:else if icon === "paper"}
  <IconPaper {size} {style} {color}/>
{:else if icon === "plus"}
  <IconPlus {size} {style} {color}/>
{:else if icon === "search"}
  <IconSearch {size} {style} {color}/>
{:else if icon === "see"}
  <IconSee {size} {style} {color}/>
{/if}