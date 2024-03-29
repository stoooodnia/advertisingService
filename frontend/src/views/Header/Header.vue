<template>
    <header class="flex items-center justify-between w-full py-[24px]">
        <h1 class="font-semibold text-3xl">{{ headerLabel }}</h1>
        <Button class="p-[20px] rounded-lg" :label="buttonData.label" :icon="buttonData.icon" :color="buttonData.color" :size="buttonData.size" :action="buttonData.action"/>
    </header>
</template>


<script lang="ts">
import { defineComponent, PropType } from 'vue'
import Button from '../../components/Button/Button.vue'
export default defineComponent({
    components: {
        Button
    },
    props: {
        headerLabel: {
            /**
             * The label of the header
             */
            type: String,
            required: true
        },
        buttonData : {
            // przekazuje dane przycisku z osobna nie jako obiekt, ponieważ chcę w ten sposób zadbać o storybooka, żeby można było kontrolować oddzielnie te wartości a nie jako obiekt.
            type: Object as PropType<ButtonData>,
            required: true
        }
    }
})
</script>