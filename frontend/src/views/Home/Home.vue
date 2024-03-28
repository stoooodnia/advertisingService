<template>
    <div class="flex w-screen h-screen overflow-y-hidden">
        <Navbar :route="$route" />
        <div class="w-full flex flex-col items-center px-[60px]">
            <Header class="h-1/6 " :headerLabel="headerLabel" :button-data="buttonData" />
            <section class="rounded-lg border-[1px] border-my-light-gray bg-white h-4/5 w-full"> 
                <header class="h-[47px] w-full px-[16px] flex items-center border-b-[1px] border-my-light-gray">
                    <ul class="flex gap-[65px] text-my-gray text-[12px] ">
                        <li class="w-[140px]">Imię</li>
                        <li class="w-[140px]">Nazwisko</li>
                        <li class="w-[140px]">Specjalizacja</li>
                        <li class="w-[140px]">Treść</li>
                        <li class="w-[140px]">Data dodania</li>
                    </ul>
                </header>
                <Offer v-for="offer in offers" :offerData="offer" :key="offer.id" />
            </section>
            <footer class="flex items-center h-1/6 w-full justify-end">
                <Pagination :total=totalPages @update:page="handlePageChange"/>
            </footer>
        </div>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import Navbar from '../Navbar/Navbar.vue';
import Header from '../Header/Header.vue';
import Offer from '../../components/Offer/Offer.vue';
import Pagination from '../../components/Pagination/Pagination.vue';
// import generateOffers from '../../components/Offer/OffersGenerator';
import offersService from '../../services/offersService';



export default defineComponent({
    components: {
        Navbar,
        Header,
        Offer,
        Pagination
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
            offers: [] as OfferData[],
            page: 1,
            totalPages: 0,
        }
    },
    created() {
        this.getOffers()

    },
    methods: {
        handlePageChange(page: number) {
            const SIZE = 8;
            this.page = page;
            this.getPage(page, SIZE);
            
        },
        getOffers() {
            offersService.getOffersDefault().then((response) => {
                  const { content, totalPages } = response.data;
                    this.offers = content;
                    this.totalPages = totalPages;

                })
        },
        getPage(page: number, size: number) {
            offersService.getOffers(page-1, size).then((response) => {
                console.log(response.data);
                const { content, totalPages } = response.data;
                this.offers = content;
                this.totalPages = totalPages;
            })
        },
    },
})
</script>