
<template>
  <Select >
    <SelectTrigger class="h-[44px] rounded-xl focus:animate-none outline-my-black" :class="error ? 'border-red-500 border-2 animate-pulse ' : 'border-my-light-gray '">
      <SelectValue class="text-my-gray" placeholder="Wybierz specjalizację" />
    </SelectTrigger>
    <SelectContent>
      <div v-for="spec in specializations">
        <SelectItem :value="spec.id.toString()" >
          {{ spec.label }}
        </SelectItem>
      </div>
    </SelectContent>
  </Select>
</template>

<script lang="ts">
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from '../../../@/components/ui/select'
import { defineComponent } from 'vue';
import specializationsService from '../../services/specializationsService';

export default defineComponent({
  components: {
    Select,
    SelectContent,
    SelectItem,
    SelectTrigger,
    SelectValue,
  },
  props: {
    error: {
      type: Boolean,
    }
  },
  data() {
    return {
      specializations: [] as SpecializationData[],
    }
  },
  created() {
    this.getSpecializations();
  },
  methods: {
    getSpecializations() {
      specializationsService.getSpecializations().then((response) => {
        const { content } = response.data;
        this.specializations = content;
      });
    }
  }
});



</script>