<template>
    <div v-if="show" class="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-50">
      <div class="flex flex-col gap-8 bg-white rounded-lg w-[574px] h-[632px] p-6 relative">
        <header class="flex justify-between">
          <h5 class="text-2xl font-semibold">Profil użytkownika</h5>
          <Button class="p-[10px] rounded-xl" size="iconOnly" icon="fa-solid fa-x" color="black" :action="close"/>
        </header>
        <div class="flex flex-col gap-4 relative">
          <div>
            <p class="text-[#565656] text-[14px] font-semibold">Imię: {{ userData.firstname }}</p>
          </div>
          <div>
            <p class="text-[#565656] text-[14px] font-semibold">Nazwisko: {{ userData.lastname }}</p>
          </div>
          <div>
            <p class="text-[#565656] text-[14px] font-semibold">Email: {{ userData.email }}</p>
          </div>
        </div>
        <div class="flex justify-end items-end gap-2 h-full">
          <Button class="rounded-lg px-[16px]" :action="logout" color="gray" size="labelOnly" label="Wyloguj"/>
        </div>
      </div>
    </div>
  </template>
  
  <script lang="ts">
  import { defineComponent } from 'vue'
  import { useAuthStore } from '../../stores/authStore'
  import Button from '../../components/Button/Button.vue'
  import authService from '../../services/authService'

  
  export default defineComponent({
    components: {
      Button
    },
    props: {
      show: {
        type: Boolean,
        required: true,
      },
    },
    data() {
        return {
        userData: this.getUserData(),
        }
    },
    methods: {       
        getUserData() {
            const store = useAuthStore();
            return store.getUser();
        },
      close() {
        this.$emit('update:show', false);
      },
      logout() {
        const store = useAuthStore();
        authService.logout()
        store.logout();
        this.$router.push('/login')
      }
    }
  })
  </script>
  