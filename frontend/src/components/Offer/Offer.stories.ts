import type { Meta, StoryObj } from "@storybook/vue3";
import Offer from "./Offer.vue";

const meta = {
  title: "Components/Offer",
  component: Offer,
  tags: ["autodocs"],
  argTypes: {
    offerData: {
      control: "object",
      defaultValue: {
        id: 1,
        firstname: "John",
        lastname: "Doe",
        specialization: "Software Developer",
        content: "Lorem ipsum dolor sit amet",
        createdAt: "2021-01-01",
      },
    },
  },
} satisfies Meta<typeof Offer>;

export default meta;

type Story = StoryObj<typeof meta>;

export const Example: Story = {
  args: {
    offerData: {
      id: 1,
      firstname: "John",
      lastname: "Doe",
      specialization: {
        id: 1,
        label: "Software Developer",
      },
      content: "Lorem ipsum dolor sit amet",
      createdAt: "2021-01-01",
    },
  },
};
