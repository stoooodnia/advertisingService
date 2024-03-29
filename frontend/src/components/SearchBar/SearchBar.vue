<template>
    <div class="h-[76px] px-[12px] py-[10px] w-full flex justify-end items-center border-b border-my-light-gray">
        <div class="bg-[#f7f7f7] w-[221px] h-[44px] rounded-lg flex items-center px-[12px] gap-2">
            <font-awesome-icon icon="fa-solid fa-search" class="text-[#2A66F5] h-[15px] w-[15px]"/>
            <input
            v-model="searchQuery"
            type="text"
            placeholder="Szukaj"
            class="bg-transparent placeholder-my-gray text-[14px] outline-none"
        >
        </div>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default  defineComponent({
  data() {
      return {
          searchQuery: "",
      };
  },
  watch: {
      searchQuery: {
          handler: "search",
          immediate: true,
      }
  },
  methods: {
      search() {
        this.$emit("search", this.searchQuery);
      },
  }
});
</script>
