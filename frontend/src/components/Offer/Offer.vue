<template>
    <OfferForm :show="showEditOffer" @update:show="showEditOffer = $event" :editOfferData="offerData"/>
    <div class="flex items-center justify-between h-[68px] w-full border-b-[1px] border-my-light-gray px-[16px] hover:bg-my-light-gray transition-colors ">
        <ul @click="toggleDetails" class="flex flex-row gap-[65px] ">
            <li class="w-[140px] truncate">{{ offerData.firstname }}</li>
            <li class="w-[140px] truncate">{{ offerData.lastname }}</li>
            <li class="w-[140px] truncate">{{ offerData.specialization.label }}</li>
            <li class="w-[140px] truncate">{{ offerData.content }}</li>
            <li class="w-[140px] truncate">{{ offerDate }}</li>
        </ul>
        <div class="flex ">
            <Button class="hover:text-black/50 p-[20px] " size="iconOnly" icon="fa-solid fa-pen-to-square" :action=editOffer />
            <Button class="text-red-500 hover:text-red-500/50" size="iconOnly" icon="fa-solid fa-trash-can" :action="deleteOffer" />
        </div>
    </div>
    <div v-if="detailsVisible" class="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-50">
        <div class="offer-card bg-white rounded-lg shadow-lg p-6">
            <div class="flex justify-between items-center mb-4 gap-20">
                <h2 class="text-xl font-bold">{{ offerData.firstname }} {{ offerData.lastname }}</h2>
                <Button class="p-[10px] rounded-xl" size="iconOnly" icon="fa-solid fa-x" color="black" :action="close"/>
            </div>
            <p class="text-gray-600">{{ offerData.specialization.label }}</p>
                <p class="text-lg text-gray-800 mb-4 break-words">{{ offerData.content }}</p>
                <p class="text-sm text-gray-600 mb-4">{{ offerDate }}</p>
                <div class="flex justify-end">
                <Button class="mr-2" size="iconOnly" icon="fa-solid fa-pen-to-square" :action="editOffer" />
                <Button class="text-red-500" size="iconOnly" icon="fa-solid fa-trash-can" :action="deleteOffer" />
            </div>
        </div>
    </div>
</template>

<script lang="ts">
import { PropType, defineComponent } from 'vue'
import Button from '../Button/Button.vue'
import OfferForm from '../OfferForm/OfferForm.vue'
import offersService from '../../services/offersService'

export default defineComponent({
    components: {
        Button,
        OfferForm
    },
    props: {
        offerData: {
            /**
             * The data of the offer 
             */
            type: Object as PropType<OfferResponse>,
            required: true
        }
    },
    data() {
        return {
            showEditOffer: false,
            offerDate: this.offerData.createdAt.replaceAll("-", "/").split("T")[0],
            offerTime: this.offerData.createdAt.split("T")[1].split(".")[0],
            detailsVisible: false
        }
    },
    methods: {
        close() {
            this.detailsVisible = false
        },
        toggleDetails() {
            this.detailsVisible = !this.detailsVisible
        },
        editOffer() {
          this.showEditOffer = true
        },
        deleteOffer() {
            offersService.deleteOffer(this.offerData.id).then(() => {
                console.log('Offer deleted')
                location.reload()
            })
        }
    }
})
</script>
