<template>
    <div class="h-screen w-[240px] bg-my-black">
    <nav>
        <RouteLink icon="fa-solid fa-shop" label="Home" to="/home" :active=true />
        <RouteLink icon="user" label="Profile" to="/profile" />
        <RouteLink icon="cog" label="Settings" to="/settings" />
    </nav>    
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import RouteLink from '../../components/RouteLink/RouteLink.vue'

export default defineComponent({
    components: {
        RouteLink
    },
})
</script>
