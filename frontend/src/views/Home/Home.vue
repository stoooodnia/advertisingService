<template>
    <OfferForm :show="showAddOffer" @update:show="showAddOffer = $event"/>
    <div class="flex w-screen h-screen overflow-y-hidden">
        <Navbar :route="$route" />
        <div class="w-full flex flex-col items-center px-[60px]">
            <Header class="h-1/6 " :headerLabel="headerLabel" :button-data="buttonData" />
            <section class="rounded-lg border-[1px] border-my-light-gray bg-white w-full"> 
                <SearchBar @search="searchQuery = $event"/>
                <div class="h-[47px] w-full px-[16px] flex items-center border-b-[1px] border-my-light-gray">
                    <ul class="flex gap-[65px] text-my-gray text-[12px] ">
                        <li class="w-[140px]">Imię</li>
                        <li class="w-[140px]">Nazwisko</li>
                        <li class="w-[140px]">Specjalizacja</li>
                        <li class="w-[140px]">Treść</li>
                        <li class="w-[140px]">Data dodania</li>
                    </ul>
                </div>
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
import OfferForm from '../../components/OfferForm/OfferForm.vue';
import SearchBar from '../../components/SearchBar/SearchBar.vue';


export default defineComponent({
    components: {
        Navbar,
        Header,
        Offer,
        Pagination,
        OfferForm,
        SearchBar
    },
    data() {
        return {
            showAddOffer: false,
            headerLabel: "Ogłoszenia",
            buttonData: {
                label: "Dodaj ogłoszenie",
                icon: "fa-solid fa-plus",
                color: "black",
                size: "iconAndLabel",
                action: () => {
                    // @ts-ignore
                    this.showAddOffer = true;
                },
            },
            offers: [] as OfferResponse[],
            page: 1,
            totalPages: 0,
            searchQuery: "",
        }
    },
    watch: {
        searchQuery: {
            handler: function() {
                this.search(this.page, 8);
            },
            immediate: true,
        }
    },
    created() {
        this.getOffers()

    },
    methods: {
        search(page: number, size: number) {
            console.log(this.searchQuery, this.offers) 
            if (this.searchQuery === "") {
                return;
            }
            offersService.searchOffers(page-1, size, this.searchQuery,).then((response) => {
                const { content, totalPages } = response.data;
                this.offers = content;
                this.totalPages = totalPages;
            })
        },
        handlePageChange(page: number) {
            const PAGE_SIZE = 8;
            this.page = page;
            if(this.searchQuery !== "") {
                this.search(page, PAGE_SIZE);
                return;
            }
            this.getPage(page, PAGE_SIZE);
            
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