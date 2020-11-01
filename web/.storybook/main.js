const path = require("path");

module.exports = {
  stories: ["../src/stories/**/*.stories.ts"],
  logLevel: "debug",
  addons: [
    "@storybook/addon-storysource",
    "@storybook/addon-actions",
    "@storybook/addon-docs",
    "@storybook/addon-controls",
    "@storybook/addon-links",
    "@storybook/addon-knobs",
    "@storybook/addon-backgrounds",
    "@storybook/addon-viewport",
    "@storybook/addon-a11y",
  ],
  webpackFinal: async (config) => {
    config.module.rules.push({
      test: [/\.stories\.ts$/],
      loaders: [require.resolve("@storybook/source-loader")],
      include: [path.resolve(__dirname, "../src")],
      enforce: "pre",
    });
    return config;
  },
};