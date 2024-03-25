import type { Meta, StoryObj } from "@storybook/vue3";
import Navbar from "./Navbar.vue";

const meta = {
  title: "Components/Navbar",
  component: Navbar,
  tags: ["autodocs"],
} satisfies Meta<typeof Navbar>;

export default meta;
type Story = StoryObj<typeof meta>;
export const Default: Story = {};
