<template>
    <div class="flex w-screen h-screen overflow-y-hidden">
        <Navbar :route="$route" />
        <div class="w-full flex flex-col items-center px-[60px]">
            <Header class="h-1/6 " :headerLabel="headerLabel" :button-data="buttonData" />
            <section class="rounded-lg border-[1px] border-my-light-gray bg-white h-4/5 w-full"> 
                <header class="h-[47px] w-full px-[16px] flex items-center border-b-[1px] border-my-light-gray">
                    <ul class="flex gap-[65px] text-my-gray text-[12px] ">
                        <li class="w-[140px] ">Imię</li>
                        <li class="w-[140px] ">Nazwisko</li>
                        <li class="w-[140px] ">Specjalizacja</li>
                        <li class="w-[140px]">Treść</li>
                        <li class="w-[140px]">Data dodania</li>
                    </ul>
                </header>
                <Offer v-for="offer in offers" :offerData="offer" :key="offer.id" />
            </section>
        </div>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import Navbar from '../Navbar/Navbar.vue';
import Header from '../Header/Header.vue';
import Offer from '../../components/Offer/Offer.vue';



const OffersMockData = [
    {
        id: 1,
        firstname: "Jan",
        lastname: "Kowalski",
        specialization: "Chirurg",
        content: "Szukam asystenta",
        createdAt: "2021-10-10",
    },
    {
        id: 2,
        firstname: "Anna",
        lastname: "Nowak",
        specialization: "Dermatolog",
        content: "Zatrudnię asystenta na umowę o pracę!",
        createdAt: "2021-10-10",
    },
    {
        id: 3,
        firstname: "Piotr",
        lastname: "Wiśniewski",
        specialization: "Laryngolog",
        content: "Zatrudnię asystenta",
        createdAt: "2021-10-10",
    },
    {
        id: 4,
        firstname: "Katarzyna",
        lastname: "Kowalczyk",
        specialization: "Okulista",
        content: "Szukam asystenta",
        createdAt: "2021-10-10",
    }]



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
            offers: [] as OfferData[]
        }
    },
    created() {
        this.getOffers()
    },
    methods: {
        getOffers() {
            this.offers = OffersMockData;
        }
    },
})
</script>../Header/Header.vue