<template>
    <div class="flex flex-col gap-4 bg-white rounded-lg w-[574px] h-[632px] p-6">
        <header class="flex justify-between">
            <h1 class="text-2xl font-bold">Dodaj ogłoszenie</h1>
            <Button size="iconOnly" icon="fa-solid fa-x" color="black" :action="() => {console.log(1)}"/>
        </header>
        <label for="firstname">Imię</label>
        <input v-model="form.firstname" name="firstname" type="text" placeholder="Wpisz swoję imię" class="border border-gray-300 p-2 rounded-md">
        <div>
            <span v-if="v$.form.firstname.$dirty && !v$.form.firstname.required" class="text-red-500">Pole wymagane</span>
            <span v-if="v$.form.firstname.$dirty && !v$.form.firstname.minLength" class="text-red-500">Imię musi mieć co najmniej 2 znaki</span>
        </div>
        <label for="lastname">Nazwisko</label>
        <input v-model="form.lastname" name="lastname" type="text" placeholder="Wpisz swoję nazwisko" class="border border-gray-300 p-2 rounded-md">
        <div>
            <span v-if="v$.form.lastname.$dirty && !v$.form.lastname.required" class="text-red-500">Pole wymagane</span>
            <span v-if="v$.form.lastname.$dirty && !v$.form.lastname.minLength" class="text-red-500">Nazwisko musi mieć co najmniej 2 znaki</span>
        </div>
        <label for="options">Specjalizacja</label>
        <select name="options" v-model="form.specOption" class="border border-gray-300 rounded-md w-full p-2">
            <option class="text-my-gray" disabled value="">
                Wybierz specjalizację
            </option>
            <option v-for="spec in specializations" :key="spec.id" :value="spec.id">{{ spec.label }}</option>
        </select>
        <div>
            <span v-if="v$.form.specOption.$dirty && !v$.form.specOption.required" class="text-red-500">Pole wymagane</span>
        </div>
        <label for="content">Treść ogłoszenia</label>
        <textarea v-model="form.content" placeholder="Wpisz treść ogłoszenia" maxlength="50" class="border border-gray-300 p-2 rounded-md h-[120px] resize-none"></textarea>
        <div>
            <span v-if="v$.form.content.$dirty && !v$.form.content.required" class="text-red-500">Pole wymagane</span>
            <span v-if="v$.form.content.$dirty && !v$.form.content.minLength" class="text-red-500">Treść musi mieć co najmniej 5 znaków</span>
        </div>
        <button @click="submit" class="bg-blue-500 text-white p-2 rounded-md hover:bg-blue-600">Zapisz</button>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import Button from '../Button/Button.vue'
import { useVuelidate } from '@vuelidate/core'
import { required, minLength } from '@vuelidate/validators'

export default defineComponent({
    components: {
        Button
    },
    setup() {
        return {
            v$: useVuelidate()
        }
    },
    data() {
        return {
            form: {
                firstname: "",
                lastname: "",
                content: "",
                specOption: "",
            },
            specializations: [
                {id: 1, label: "Specjalizacja 1"},
                {id: 2, label: "Specjalizacja 2"},
                {id: 3, label: "Specjalizacja 3"},
                {id: 4, label: "Specjalizacja 4"},
                {id: 5, label: "Specjalizacja 5"},
            ]
        }
    },
    validations: {
        form: {
            firstname: {
                required,
                minLength: minLength(2)
            },
            lastname: {
                required,
                minLength: minLength(2)
            },
            content: {
                required,
                minLength: minLength(5)
            },
            specOption: {
                required
            }
        }
    },
    methods: {
        submit() {
            this.v$.$validate()
            if(this.v$.invalid) {
                return
            }
            console.log(this.form)
        }
    }
})
</script>