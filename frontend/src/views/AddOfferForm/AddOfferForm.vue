<template>
    <div v-if="show" class="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-50">
        <form @submit.prevent="submit" class="flex flex-col gap-8 bg-white rounded-lg w-[574px] h-[632px] p-6">
            <header class="flex justify-between">
                <h5 class="text-2xl font-semibold">Dodaj ogłoszenie</h5>
                <Button class="p-[10px] rounded-xl" size="iconOnly" icon="fa-solid fa-x" color="black" :action="close"/>
            </header>
            <div class="flex flex-col gap-4">
                <div class="w-full flex flex-col gap-2">
                    <label class="text-[#565656] text-[14px] font-semibold" for="firstname">Imię</label>
                    <input required v-model="form.firstname" id="firstname" type="text" placeholder="Wpisz swoję imię" class="h-[44px] border border-my-light-gray rounded-xl p-3  placeholder-my-gray text-[14px]">
                </div>
                <div class="w-full flex flex-col gap-2">
                    <label class="text-[#565656] text-[14px] font-semibold" for="lastname">Nazwisko</label>
                    <input required v-model="form.lastname" id="lastname" type="text" placeholder="Wpisz swoję nazwisko" class="h-[44px] border border-my-light-gray rounded-xl p-3  placeholder-my-gray text-[14px]">
                </div>
                <div class="w-full flex flex-col gap-2">
                    <label class="text-[#565656] text-[14px] font-semibold " for="specOption">Specjalizacja</label>
                    <Select required v-model="form.specOption" class="w-full" id="specOption" />
                </div>
            </div>
            <div class="flex flex-col gap-4">
                <label class="text-[#565656] text-[14px] font-semibold" for="content">Treść ogłoszenia</label>
                <textarea required v-model="form.content" id="content" placeholder="Wpisz treść ogłoszenia" maxlength="50" class="border border-my-light-gray rounded-xl p-3 h-[120px] resize-none placeholder-my-gray text-[14px]"></textarea>
            </div>
            <div class="flex justify-end items-end gap-2 h-full">
                    <Button class="rounded-lg px-[16px]" :action="close" color="black" size="labelOnly" label="Anuluj"/>
                    <Button type=submit class="rounded-lg px-[30px]" :action="()=>{}" color="gray" size="labelOnly" label="Zapisz"/>
            </div>
        </form>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import Button from '../../components/Button/Button.vue'
import Select from './Select.vue'

export default defineComponent({
    components: {
        Button,
        Select
    },
    props: {
        show: {
            type: Boolean,
            required: true,
        },
    },
    data() {
        return {
            form: {
                firstname: "",
                lastname: "",
                content: "",
                specOption: "",
            },
        }
    },
    methods: {
        close() {
            this.$emit('update:show', false);
        },
        submit() {
          console.log(JSON.stringify(this.form))
          this.form = {
            firstname: "",
            lastname: "",
            content: "",
            specOption: "",
          }
          this.close()
        },
    }
})
</script>