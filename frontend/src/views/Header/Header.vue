<template>
    <header class="flex items-center justify-between w-full py-[24px]">
        <h1 class="font-semibold text-3xl">{{ headerLabel }}</h1>
        <div class="flex gap-6">
            <Button class="pl-[10px] pr-[15px] text-[14px] rounded-lg" :label="buttonData.label" :icon="buttonData.icon" :color="buttonData.color" :size="buttonData.size" :action="buttonData.action"/>
            <Button class="p-[14px] w-[44px] rounded-full" :label="label" color="black" :size="'labelOnly'" :action="() => {showLogin = true}"/>
        </div>
    </header>
</template>


<script lang="ts">
import { defineComponent, PropType } from 'vue'
import Button from '../../components/Button/Button.vue'
import LoginForm from '../LoginForm/LoginForm.vue'
import RegisterForm from '../RegisterForm/RegisterForm.vue'

export default defineComponent({
    components: {
        LoginForm,
        RegisterForm,
        Button
    },
    props: {
        headerLabel: {
            /**
             * The label of the header
             */
            type: String,
            required: true
        },
        buttonData : {
            // przekazuje dane przycisku z osobna nie jako obiekt, ponieważ chcę w ten sposób zadbać o storybooka, żeby można było kontrolować oddzielnie te wartości a nie jako obiekt.
            type: Object as PropType<ButtonData>,
            required: true
        }
    },
    data() {
        return {
            loggedStatus: localStorage.getItem('logged') ? true : false,
            label: this.getLabel(),
            showLogin: false,
            showRegister: false
        }
    },
    methods: {
        getLabel() {
            if (this.loggedStatus) {
                const user = JSON.parse(localStorage.getItem('user') as string)
                console.log(user)
                return `${user.firstname[0]} ${user.lastname[0]}`
            } else {
                return ''
            }
        }
    }
})
</script>