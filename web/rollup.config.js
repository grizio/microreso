import svelte from "rollup-plugin-svelte"
import resolve from "@rollup/plugin-node-resolve"
import commonjs from "@rollup/plugin-commonjs"
import livereload from "rollup-plugin-livereload"
import {terser} from "rollup-plugin-terser"
import sveltePreprocess from "svelte-preprocess"
import typescript from "@rollup/plugin-typescript"

const production = !process.env.ROLLUP_WATCH

function serve(name) {
  let server

  function toExit() {
    if (server) server.kill(0)
  }

  return {
    writeBundle() {
      if (server) return
      server = require("child_process").spawn("sirv", [`build/${name}`, "--dev"], {
        stdio: ["ignore", "inherit", "inherit"],
        shell: false
      })

      process.on("SIGTERM", toExit)
      process.on("exit", toExit)
    }
  }
}

function buildConfiguration({name, input}) {
  return {
    input: input,
    output: {
      sourcemap: true,
      format: "iife",
      name: "app",
      file: `build/${name}/bundle-${name}.js`
    },
    plugins: [
      svelte({
        // enable run-time checks when not in production
        dev: !production,

        // we'll extract any component CSS out into
        // a separate file - better for performance
        css: css => {
          css.write(`bundle-${name}.css`, !production)
        },
        preprocess: sveltePreprocess(),
      }),

      // If you have external dependencies installed from
      // npm, you'll most likely need these plugins. In
      // some cases you'll need additional configuration -
      // consult the documentation for details:
      // https://github.com/rollup/plugins/tree/master/packages/commonjs
      resolve({
        browser: true,
        dedupe: ["svelte"]
      }),
      commonjs(),
      typescript({
        sourceMap: !production,
        inlineSources: !production
      }),

      // In dev mode, call `npm run start` once
      // the bundle has been generated
      !production && process.argv.includes(name) && serve(name),

      // Watch the `public` directory and refresh the
      // browser on changes when not in production
      !production && livereload(`build/${name}`),

      // If we're building for production (npm run build
      // instead of npm run dev), minify
      production && terser()
    ],
    watch: {
      clearScreen: false
    }
  }
}

export default [
  buildConfiguration({
		name: "main",
    input: "src/main.ts",
  }),
  buildConfiguration({
    name: "initialize",
    input: "src/main-initialize.ts"
  })
]