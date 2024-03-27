import type { Meta, StoryObj } from "@storybook/vue3";
import RouteLink from "./RouteLink.vue";

const meta = {
  title: "Components/RouteLink",
  component: RouteLink,
  tags: ["autodocs"],
  argTypes: {
    icon: {
      control: "select",
      options: [
        "fa-solid fa-shop",
        "fa-solid fa-briefcase",
        "fa-solid fa-pen-to-square",
        "fa-solid fa-trash-can",
        "fa-solid fa-magnifying-glass",
        "fa-solid fa-x",
      ],
    },
  },
  args: {
    icon: "fa-solid fa-shop",
    to: "/",
    label: "Ogłoszenia",
  },
} satisfies Meta<typeof RouteLink>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Active: Story = {
  args: {
    active: true,
  },
};
