<template>
    <div>

    </div>
</template>

<script lang="ts">

interface ButtonData {
    label: string;
    icon: string;
    action: () => void;
}
import { defineComponent, PropType } from 'vue'

export default defineComponent({
    props: {
        label: {
            /**
             * The label of the header
             */
            type: String,
            required: true
        },
        buttonData : {
            type: Object as PropType<ButtonData>,
            required: true
        }
    }
})
</script>