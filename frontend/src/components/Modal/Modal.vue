<template>
  <div v-if="show" class="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-50">
    <div class="">
      <slot></slot>
      <button @click="closeModal" class="mt-4 px-4 py-2 bg-blue-500 text-white rounded-md">Close</button>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
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
