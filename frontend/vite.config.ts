import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// https://vitejs.dev/config/
export default defineConfig({
  build: {
    outDir: "../backend/src/main/resources/static",
    emptyOutDir: true,
  },
  plugins: [vue()],
});
