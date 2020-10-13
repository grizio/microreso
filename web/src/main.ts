import AppMain from "./AppMain.svelte"

const app = new AppMain({
  target: document.body,
  props: {
    name: "world",
  },
})

export default app