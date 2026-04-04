import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  base: '/dashboard/',
  server: {
    proxy: {
      '/electionSuggestions': {
        target: 'http://localhost:443',
        changeOrigin: true,
        secure: false
      }
    }
  }
})
