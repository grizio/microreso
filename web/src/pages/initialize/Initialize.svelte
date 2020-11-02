<script lang="ts">
  import InputText from "../../component/form/InputText.svelte"
  import TextButton from "../../component/button/TextButton.svelte"
  import VerticalLayout from "../../component/layout/VerticalLayout.svelte"
  import {canonicalize} from "../../utils/strings"
  import api from "../../api"
  import InputPassword from "../../component/form/InputPassword.svelte"

  let name: string = ""
  let code: string = ""
  let email: string = ""
  let username: string = ""
  let password: string = ""

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

  async function submit(event) {
    event.preventDefault()
    const result = await api.initialize({
      initialize: {
        code, name,
        admin: {
          email, username, password
        }
      }
    })
    window.location.reload()
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
    box-shadow: 0 0 5px rgba(102, 102, 102, 0.75);
    padding: var(--space-8);
    border-radius: 4px;
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

      <InputText
        id="initialize-email"
        name="email"
        label="Admin’s email"
        placeholder="ex: the@bos.se"
        bind:value={email}
      />

      <InputText
        id="initialize-username"
        name="username"
        label="Admin’s username (letters, numbers and ‘-’ only)"
        placeholder="ex: theboss"
        bind:value={username}
      />

      <InputPassword
        id="initialize-password"
        name="password"
        label="Admin’s password"
        placeholder="Please ensure to use a strong password and/or a password manager"
        bind:value={password}
      />

      <div class="actions">
        <TextButton text="Create my organisation" testId="initialize-submit"/>
      </div>
    </VerticalLayout>
  </form>
</main>