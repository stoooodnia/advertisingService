
<template>
  <Pagination v-slot="{ page }" :total="100" :sibling-count="1" show-edges :default-page="1">
    <PaginationList v-slot="{ items }" class="flex items-center gap-1">
      <PaginationPrev />

      <template v-for="(item, index) in items">
        <PaginationListItem v-if="item.type === 'page'" :key="index" :value="item.value" as-child>
          <Button class="w-[30px] h-[30px] p-0" :variant="item.value === page ? 'active' : 'outline'">
            {{ item.value }}
          </Button>
        </PaginationListItem>
        <PaginationEllipsis v-else :key="item.type" :index="index" />
      </template>
      <PaginationNext />
    </PaginationList>
  </Pagination>
</template>

<script setup lang="ts">
    import {
      Pagination,
      PaginationEllipsis,
      PaginationList,
      PaginationListItem,
      PaginationNext,
      PaginationPrev,
    } from '../../../@/components/ui/pagination'
    
    import {
      Button,
    } from '../../../@/components/ui/button'
</script>

