module.exports = ({ config, mode }) => {
  // remove original storybook webpack rules for svelte
  config.module.rules = config.module.rules.filter(r => {
    return !r.test.toString().includes('svelte')
  })

  config.module.rules.push({
    test: /\.svelte$/,
    exclude: /node_modules/,
    use: {
      loader: 'svelte-loader',
      options: {
        preprocess: require('svelte-preprocess')({}),
        emitCss: true,
        hotReload: false, // https://github.com/sveltejs/svelte/issues/2377 || https://github.com/sveltejs/svelte/pull/3148
        hotOptions: {
          // will display compile error in the client, avoiding page reload on error
          optimistic: true
        },
        dev: true
      }
    }
  })

  config.resolve.extensions.push('.ts')

  return config
};