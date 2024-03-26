<template>
    <div>
        <ul>
            <li>
                <span>{{ offerData.firstname }}</span>
                <span>{{ offerData.lastname }}</span>
                <span>{{ offerData.specialization }}</span>
                <span>{{ offerData.content }}</span>
                <span>{{ offerData.createdAt }}</span>
            </li>
        </ul>
        <div>
            <Button :size="iconAndLabel" :icon="fa-solid fa-penToSquare" :action="() => {console.log('Edit offer')}" />
            <Button :size="iconOnly" :icon="fa-solid fa-trashCan" :action="() => {console.log('Delete offer')}" />
        </div>
    </div>
</template>

<script lang="ts">
import { PropType, defineComponent } from 'vue'
import Button from '../Button/Button.vue'

export default defineComponent({
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
