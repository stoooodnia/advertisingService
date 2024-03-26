<template>
    <div class="flex w-screen h-screen overflow-y-hidden">
        <Navbar :route="$route" />
        <div class="w-full">
            <Header class="h-1/6" :headerLabel="headerLabel" :button-data="buttonData"  />
        </div>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import Navbar from '../Navbar/Navbar.vue';
import Header from '../Header/Header.vue';

export default defineComponent({
    components: {
        Navbar,
        Header
    },
    data() {
        return {
            headerLabel: "Ogłoszenia",
            buttonData: {
                label: "Dodaj ogłoszenie",
                icon: "fa-solid fa-plus",
                color: "black",
                size: "iconAndLabel",
                action: () => {
                    console.log("Add new announcement")
                },
            }
        }
    }
    
})
</script>../Header/Header.vue