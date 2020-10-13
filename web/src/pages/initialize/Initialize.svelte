<script lang="ts">
  import InputText from "../../component/form/InputText.svelte"
  import PrimaryButton from "../../component/button/PrimaryButton.svelte"
  import VerticalLayout from "../../component/layout/VerticalLayout.svelte"
  import {canonicalize} from "../../utils/strings"
  import api from "../../api"

  let name: string = ""
  let code: string = ""

  function onNameChanged(event) {
    const newValue = event.detail.value
    if (code === canonicalize(name)) {
      code = canonicalize(newValue)
    }
    name = newValue
  }

  function onCodeChanged(event) {
    code = event.detail.value
  }

  function submit(event) {
    event.preventDefault()
    api.createOrganisation({
      initialize: {
        code, name
      }
    })
    console.log(event, name, code)
  }
</script>

<style>
  main {
    display: flex;
    justify-items: center;
    align-items: center;
    height: 100%;
  }

  form {
    width: 500px;
    margin: auto;
    box-shadow: 0 0 5px #555555;
    padding: var(--space-8);
  }
</style>

<main>
  <form id="initialize" on:submit={submit}>
    <h1>Initial configuration</h1>

    <VerticalLayout gap={8}>
      <InputText
        id="initialize-name"
        name="name"
        label="Name of your organisation"
        placeholder="ex: My Microreso"
        value={name}
        on:change={onNameChanged}
      />

      <InputText
        id="initialize-code"
        name="code"
        label="Code of your organisation (letters, numbers and '-' only)"
        placeholder="ex: my-microreso"
        value={code}
        on:change={onCodeChanged}
      />

      <div class="actions">
        <PrimaryButton text="Create my organisation"/>
      </div>
    </VerticalLayout>
  </form>
</main>