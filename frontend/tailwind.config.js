/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{vue,js,ts,jsx,tsx}"],
  theme: {
    extend: {
      colors: {
        "my-purple": "#636AAF",
        "my-red": "#ff0000",
        "my-black": "#131314",
        "my-gray": "#6b6b6b",
        "my-light-gray": "#DCDCDC",
      },
    },
  },
  plugins: [],
};
