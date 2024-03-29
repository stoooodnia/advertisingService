<template>
    <div v-if="show" class="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-50">
        <div class="flex flex-col gap-8 bg-white rounded-lg w-[574px] h-[632px] p-6 relative">
            <header class="flex justify-between">
                <h5 class="text-2xl font-semibold">Dodaj ogłoszenie</h5>
                <Button class="p-[10px] rounded-xl" size="iconOnly" icon="fa-solid fa-x" color="black" :action="close"/>
            </header>
            <div class="flex flex-col gap-4 relative">
                <div class="w-full flex flex-col gap-2 relative">
                    <label class="text-[#565656] text-[14px] font-semibold" for="firstname">Imię</label>
                    <input v-model="form.firstname" id="firstname" type="text" placeholder="Wpisz swoję imię" :class="errors.firstname ? 'border-red-500 border-2 animate-pulse ' : 'border-my-light-gray'"  class="h-[44px] border rounded-xl p-3  placeholder-my-gray text-[14px] focus:animate-none outline-my-black">
                </div>
                <div class="w-full flex flex-col gap-2 relative">
                    <label class="text-[#565656] text-[14px] font-semibold" for="lastname">Nazwisko</label>
                    <input v-model="form.lastname" id="lastname" type="text" placeholder="Wpisz swoję nazwisko" :class="errors.lastname ? 'border-red-500 border-2 animate-pulse ' : 'border-my-light-gray'" class="h-[44px] border border-my-light-gray rounded-xl p-3  placeholder-my-gray text-[14px] focus:animate-none outline-my-black">
                </div>
                <div class="w-full flex flex-col gap-2 relative">
                    <label class="text-[#565656] text-[14px] font-semibold " for="specOption">Specjalizacja</label>
                    <Select v-model="form.specOption" class="w-full" id="specOption" :error="errors.specOption" />
                </div>
            </div>
            <div class="flex flex-col gap-2 relative">
                <label class="text-[#565656] text-[14px] font-semibold" for="content">Treść ogłoszenia</label>
                <textarea  v-model="form.content" id="content" placeholder="Wpisz treść ogłoszenia" maxlength="50" :class="errors.content ? 'border-red-500 border-2 animate-pulse ' : 'border-my-light-gray'"class="border border-my-light-gray rounded-xl p-3 h-[120px] resize-none placeholder-my-gray text-[14px] focus:animate-none outline-my-black"></textarea>
            </div>
            <div class="flex justify-end items-end gap-2 h-full">
                    <Button class="rounded-lg px-[16px]" :action="cancel" color="black" size="labelOnly" label="Anuluj"/>
                    <Button class="rounded-lg px-[30px]" :action="submit" color="gray" size="labelOnly" label="Zapisz"/>
            </div>
        </div>
    </div>
</template>


<script lang="ts">
import { defineComponent, PropType } from 'vue'
import Button from '../../components/Button/Button.vue'
import Select from './Select.vue'

export default defineComponent({
    components: {
        Button,
        Select
    },
    props: {
        editOfferData: {
            type: Object as PropType<OfferData>,
            required: false,
        },
        show: {
            type: Boolean,
            required: true,
        },
    },
    data() {
        return {
            form: {
                firstname: this.editOfferData?.firstname || "",
                lastname: this.editOfferData?.lastname || "",
                content: this.editOfferData?.content || "",
                specOption: this.editOfferData?.specialization.id.toString() || "",
            },
            errors: {
                firstname: false,
                lastname: false,
                content: false,
                specOption: false,
            }
        }
    },
    methods: {
        validate() {
            if(this.form.firstname === "") {
                this.errors.firstname = true
            }
            if(this.form.lastname === "") {
                this.errors.lastname = true
            }
            if(this.form.content === "") {
                this.errors.content = true
            }
            if(this.form.specOption === "") {
                this.errors.specOption = true
            }
            if (Object.values(this.errors).some(error => error === true)){
                return false
            } 
            return true
        },
        cancel() {
            this.clearErrors()
            this.clearForm()
            this.close()
        },           
        close() {
            this.$emit('update:show', false);
        },
        submit() {
            this.clearErrors()
            if(!this.validate()) {
                return
            }
            if(this.editOfferData) {
                console.log("edit")
                console.log(JSON.stringify(this.form))
                this.close()
                return
            }
            console.log(JSON.stringify(this.form))
            this.clearForm()
            this.close()
        },
        clearForm() {
            this.form = {
                firstname: "",
                lastname: "",
                content: "",
                specOption: "",
            }
        },
        clearErrors() {
            this.errors = {
                firstname: false,
                lastname: false,
                content: false,
                specOption: false,
            }
        }
    }
})
</script>