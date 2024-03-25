import type { Meta, StoryObj } from "@storybook/vue3";
import Navbar from "./Navbar.vue";

const meta = {
  title: "Views/Navbar",
  component: Navbar,
  tags: ["autodocs"],
  argTypes: {
    route: {
      control: "object",
    },
  },
  args: {
    route: {
      name: "home",
    },
  },
} satisfies Meta<typeof Navbar>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Home: Story = {
  args: {
    route: {
      name: "home",
      path: "/",
    },
  },
};

export const Specializations: Story = {
  args: {
    route: {
      name: "specializations",
      path: "/specjalizacje",
    },
  },
};
