<template>
    <div class="flex w-screen h-screen overflow-y-hidden">
        <Navbar :route="$route" />
        <div class="w-full">
            <Header class="h-1/6" :headerLabel="headerLabel" :button-data="buttonData"  />
            <Offer :offerData="offer" />
        </div>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import Navbar from '../Navbar/Navbar.vue';
import Header from '../Header/Header.vue';
import Offer from '../../components/Offer/Offer.vue';

export default defineComponent({
    components: {
        Navbar,
        Header,
        Offer
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
            },
            offer: {
                id: 1,
                firstname: "Jan",
                lastname: "Kowalski",
                specialization: "Chirurg",
                content: "Szukam asystenta",
                createdAt: "2021-10-10",
            }
        }
    }
    
})
</script>../Header/Header.vue