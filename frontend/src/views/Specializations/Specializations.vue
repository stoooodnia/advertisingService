<template>
    <Navbar :route="$route" />
    <div>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import Navbar from '../Navbar/Navbar.vue';

export default defineComponent({
    components: {
        Navbar
    },
    
})
</script>