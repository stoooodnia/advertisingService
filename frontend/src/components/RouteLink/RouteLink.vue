<template>
    <RouterLink :to="to" class="flex gap-[10px] w-full h-[58px] " :class="{ 'bg-my-purple text-white': !active, 'bg-white text-my-black': active }">
        <font-awesome-icon :icon=icon class="w-6 h-6" />
        <span>{{ label }}</span>
    </RouterLink>
</template>

<script lang="ts">
import { defineComponent } from 'vue'

export default defineComponent({
    props: {
        icon: {
            /**
             * The icon name for FontAwesomeIcon component (String Syntax)
             */
            type: String,
            required: true
        },
        label: {
            /**
             * The label of the routelink
             */
            type: String,
            required: true
        },
        to: {
            /**
             * The route of the routelink
             */
            type: String,
            required: true
        },
        active: {
            /**
             * The active state of the routelink 
             */
            type: Boolean,
            default: false
        }
    },

})
</script>

<style scoped>

</style>