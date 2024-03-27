<script setup lang="ts">
import { type HTMLAttributes, computed } from 'vue'
import { PaginationPrev, type PaginationPrevProps } from 'radix-vue'
import { ChevronLeft } from 'lucide-vue-next'
import {
  Button,
} from '../../../components/ui/button'
import { cn } from '../../../lib/utils'

const props = withDefaults(defineProps<PaginationPrevProps & { class?: HTMLAttributes['class'] }>(), {
  asChild: true,
})

const delegatedProps = computed(() => {
  const { class: _, ...delegated } = props

  return delegated
})
</script>

<template>
  <PaginationPrev v-bind="delegatedProps">
    <Button :class="cn('w-[30px] h-[30px] p-0', props.class)" variant="outline">
      <slot>
        <ChevronLeft class="h-6 w-6" />
      </slot>
    </Button>
  </PaginationPrev>
</template>
