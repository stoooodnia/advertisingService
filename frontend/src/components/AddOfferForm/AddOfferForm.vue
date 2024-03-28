<template>
    <div class="flex flex-col gap-4 bg-white rounded-lg w-[574px] h-[632px] p-6">
        <header class="flex justify-between">
            <h1 class="text-2xl font-bold">Dodaj ogłoszenie</h1>
            <Button size="iconOnly" icon="fa-solid fa-x" color="black" :action="() => {console.log(1)}"/>
        </header>
        <label for="firstname">Imię</label>
        <input required name="firstname" type="text" placeholder="Wpisz swoję imię" class="border border-gray-300 p-2 rounded-md">
        <label for="lastname">Nazwisko</label>
        <input required name="lastname" type="text" placeholder="Wpisz swoję nazwisko" class="border border-gray-300 p-2 rounded-md">
        <label for="options">Specjalizacja</label>
        <select name="options" v-model="specOption" class="border border-gray-300 rounded-md w-full p-2">
            <option class="text-my-gray" disabled value="">
                Wybierz specjalizację
            </option>
            <option v-for="spec in specializations" :key="spec.id" :value="spec.id">{{ spec.label }}</option>
        </select>
        <label for="content">Treść ogłoszenia</label>
        <textarea placeholder="Wpisz treść ogłoszenia" class="border border-gray-300 p-2 rounded-md h-[120px] resize-none"></textarea>
        <button class="bg-blue-500 text-white p-2 rounded-md">Zapisz</button>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import Button from '../Button/Button.vue'
// buttonAdd: {
//                 label: "Zapisz",
//                 color: "black",
//                 size: "labelOnly",
//                 action: () => {
//                 },
//                     console.log("Add new offer")
//             }

export default defineComponent({
    components: {
        Button
    },
    data() {
        return {
            specOption: "",
            specializations: [
                {id: 1, label: "Specjalizacja 1"},
                {id: 2, label: "Specjalizacja 2"},
                {id: 3, label: "Specjalizacja 3"},
                {id: 4, label: "Specjalizacja 4"},
                {id: 5, label: "Specjalizacja 5"},
            ]
        }
    }
})
</script>

<style scoped>

</style>