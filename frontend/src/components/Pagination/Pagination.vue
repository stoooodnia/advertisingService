
<template>
  <Pagination v-slot="{page}" :total=total*10 :sibling-count="1" show-edges>
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

<script lang="ts">
  import {
    Pagination,
    PaginationList,
    PaginationListItem,
    PaginationNext,
    PaginationPrev,
    PaginationEllipsis,
  } from '../../../@/components/ui/pagination'    
  
  import {
    Button,
  } from '../../../@/components/ui/button'
  import { defineComponent } from 'vue';

  export default defineComponent({
    components:{
      Pagination,
      PaginationList,
      PaginationListItem,
      PaginationNext,
      PaginationPrev,
      PaginationEllipsis,
      Button,
    },
    props: {
      total: {
        /**
         * The total number of pages
         */
        type: Number,
        default: 5,
      },
    },
  })

</script>

