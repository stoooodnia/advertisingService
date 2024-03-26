<template>
    <div class="flex items-center justify-between h-[68px] w-full border-b-[1px]  border-my-light-gray  px-[16px]">
        <ul class="flex flex-row justify-between w-5/6">
            <li>{{ offerData.firstname }}</li>
            <li>{{ offerData.lastname }}</li>
            <li>{{ offerData.specialization }}</li>
            <li>{{ offerData.content }}</li>
            <li>{{ offerData.createdAt }}</li>
        </ul>
        <div class="flex">
            <Button size="iconOnly" icon="fa-solid fa-pen-to-square" :action="() => {console.log('Edit offer')}" />
            <Button class="text-red-500" size="iconOnly" icon="fa-solid fa-trash-can" :action="() => {console.log('Delete offer')}" />
        </div>
    </div>
</template>

<script lang="ts">
import { PropType, defineComponent } from 'vue'
import Button from '../Button/Button.vue'

export default defineComponent({
    components: {
        Button
    },
    props: {
        offerData: {
            /**
             * The data of the offer 
             */
            type: Object as PropType<OfferData>,
            required: true
        }
    }
})
</script>
