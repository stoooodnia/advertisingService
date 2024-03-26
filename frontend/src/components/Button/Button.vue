<template>
    <button @click="action"  class="h-[44px] w-fit rounded-md px-[20px] py-[10px] flex items-center justify-center gap-[10px] " :class="style">
        <font-awesome-icon v-if="iconActive" :icon="icon" class="w-6 h-6" />
        <span v-if="labelActive"> {{ label }}</span>
    </button>
</template>

<script lang="ts">
import { PropType, defineComponent } from 'vue'

export default defineComponent({
    props:{
        size: {
            type: String,
            required: true,
            validator: (value: string) => ["iconOnly", "iconAndLabel","labelOnly",].includes(value)
        },
        label: {
            /**
             * The label of the button
             */
            type: String,
            required: true
        },
        icon: {
            /**
             * The icon name for FontAwesomeIcon component (String Syntax)
             */
            type: String,
            required: true
        },
        color: {
            /**
             * The background color of the button
             */
            type: String,
            validator: (value: string) => ["black", "gray"].includes(value),
            required: true
        },
        action: {
            /**
             * The action of the button
             */
            type: Function as PropType<() => void>,
            required: true
        },
    },
    computed: {
        iconActive(): boolean {
            return this.size === "iconOnly" || this.size === "iconAndLabel"
        },
        labelActive(): boolean {
            return this.size === "labelOnly" || this.size === "iconAndLabel"
        },
        style(): string {
            if(this.color === "black"){    
                return `bg-my-black text-white hover:bg-my-black/80`
            }
            else {
                return `bg-my-light-gray text-my-gray hover:bg-my-gray/50`
            }
        }
    },

})

    
</script>