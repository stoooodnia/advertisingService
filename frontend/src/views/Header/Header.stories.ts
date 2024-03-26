import type { Meta, StoryObj } from "@storybook/vue3";
import Header from "./Header.vue";

const ButtonData = {
  size: "iconAndLabel",
  label: "Button",
  icon: "fa-solid fa-plus",
  color: "black",
  action: () => {},
};

const meta = {
  title: "Views/Header",
  component: Header,
  tags: ["autodocs"],
  argTypes: {
    buttonData: {
      control: "object",
      defaultValue: { ...ButtonData },
    },
  },
  args: {
    headerLabel: "Header",
    buttonData: ButtonData,
  },
} satisfies Meta<typeof Header>;

export default meta;

type Story = StoryObj<typeof meta>;
export const Home: Story = {
  args: {
    headerLabel: "Home",
    buttonData: {
      size: "iconAndLabel",
      label: "Add home",
      icon: "fa-solid fa-plus",
      color: "black",
      action: () => {},
    },
  },
};
