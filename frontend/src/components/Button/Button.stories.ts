import type { Meta, StoryObj } from "@storybook/vue3";
import Button from "./Button.vue";

const ButtonData = {
  size: "iconAndLabel",
  label: "Button",
  icon: "fa-solid fa-plus",
  color: "black",
  action: () => {},
};

const meta = {
  title: "Components/Button",
  component: Button,
  tags: ["autodocs"],
  argTypes: {
    size: {
      control: "select",
      options: ["iconOnly", "labelOnly", "iconAndLabel"],
      defaultValue: "iconAndLabel",
    },
    color: {
      control: "select",
      options: ["black", "gray", "transparent"],
    },
  },
  args: {
    ...ButtonData,
  },
} satisfies Meta<typeof Button>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Primary: Story = {
  args: {
    ...ButtonData,
  },
};
