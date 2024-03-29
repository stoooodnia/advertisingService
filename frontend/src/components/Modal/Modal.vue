<template>
  <div v-if="show" class="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-50">
      <slot></slot>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import Button from '../Button/Button.vue';

export default defineComponent({
  components: {
    Button,
  },
  props: {
    show: {
      type: Boolean,
      required: true,
    },
  },
  methods: {
    closeModal() {
      this.$emit('update:show', false);
    },
  },
});
</script>
