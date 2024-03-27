<template>
    <button @click="action"  class="h-[44px] w-fit rounded-md p-[10px] flex items-center justify-center gap-[10px] transition-colors duration-300" :class="style">
        <font-awesome-icon v-if="iconActive" :icon="icon" class="w-6 h-6" />
        <span v-if="labelActive" class="mr-[10px]"> {{ label }}</span>
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
             * The background color of the button, default is transparent
             */
            type: String,
            validator: (value: string) => ["black", "gray"].includes(value),
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
            else if(this.color === "gray") {
                return `bg-my-light-gray text-my-gray hover:bg-my-gray/50`
            } 
            return `bg-transparent`
        }
    },

})

    
</script>