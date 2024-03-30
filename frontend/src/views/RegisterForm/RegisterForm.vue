<template>
  <div class="flex items-center justify-center h-screen w-screen">
      <div class="flex flex-col gap-8 bg-white rounded-lg w-[574px] h-[632px] p-6">
        <header class="flex justify-between">
          <h1 class="text-2xl font-semibold">Rejestracja</h1>
        </header>
        <div class="flex flex-col gap-4 relative">
          <div class="w-full flex flex-col gap-2 relative">
            <label class="text-[#565656] text-[14px] font-semibold" for="firstname">Imię</label>
            <input v-model="form.firstname" id="firstname" type="text" placeholder="Wpisz imię" :class="errors.firstname ? 'border-red-500 border-2 animate-pulse ' : 'border-my-light-gray'" class="h-[44px] border rounded-xl p-3  placeholder-my-gray text-[14px] focus:animate-none outline-my-black">
          </div>
          <div class="w-full flex flex-col gap-2 relative">
            <label class="text-[#565656] text-[14px] font-semibold" for="lastname">Nazwisko</label>
            <input v-model="form.lastname" id="lastname" type="text" placeholder="Wpisz nazwisko" :class="errors.lastname ? 'border-red-500 border-2 animate-pulse ' : 'border-my-light-gray'" class="h-[44px] border border-my-light-gray rounded-xl p-3  placeholder-my-gray text-[14px] focus:animate-none outline-my-black">
          </div>
          <div class="w-full flex flex-col gap-2 relative">
            <label class="text-[#565656] text-[14px] font-semibold" for="email">Adres e-mail</label>
            <input v-model="form.email" id="email" type="email" placeholder="Wpisz adres e-mail" :class="errors.email ? 'border-red-500 border-2 animate-pulse ' : 'border-my-light-gray'" class="h-[44px] border rounded-xl p-3  placeholder-my-gray text-[14px] focus:animate-none outline-my-black">
          </div>
          <div class="w-full flex flex-col gap-2 relative">
            <label class="text-[#565656] text-[14px] font-semibold" for="password">Hasło</label>
            <input v-model="form.password" id="password" type="password" placeholder="Wpisz hasło" :class="errors.password ? 'border-red-500 border-2 animate-pulse ' : 'border-my-light-gray'" class="h-[44px] border border-my-light-gray rounded-xl p-3  placeholder-my-gray text-[14px] focus:animate-none outline-my-black">
          </div>
        </div>
        <div class="flex justify-between items-end gap-2 h-full">
          <Button class="rounded-lg px-[16px]" :action="login" size="labelOnly" label="zaloguj się"/>
          <Button class="rounded-lg px-[30px]" :action="submit" color="black" size="labelOnly" label="Zarejestruj"/>
        </div>
      </div>
    </div>
  </template>
  
  <script lang="ts">
  import { defineComponent } from 'vue'
  import Button from '../../components/Button/Button.vue'
  import userService from '../../services/authService'
  import { useAuthStore } from '../../stores/authStore'
  
  export default defineComponent({
    components: {
      Button
    },
    data() {
      return {
        form: {
          firstname: "",
          lastname: "",
          email: "",
          password: "",
        },
        errors: {
          firstname: false,
          lastname: false,
          email: false,
          password: false,
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
        if(this.form.email === "") {
          this.errors.email = true
        }
        if(this.form.password === "") {
          this.errors.password = true
        }
        if (Object.values(this.errors).some(error => error === true)){
          return false
        } 
        return true
      },         
      login() {
        this.$router.push('/login')
      },
      submit() {
        if(!this.validate()) {
          return
        }
        this.register().then((res) => {
          const user = res.data.user
          const store = useAuthStore();
          store.setUser(user)
          this.$router.push('/')
        }).catch(() => {
          this.errors.email = true
        })
      },
      register() {
        const data = {
          firstname: this.form.firstname,
          lastname: this.form.lastname,
          email: this.form.email,
          password: this.form.password,
        }   
        return userService.register(data)
      },
    }
  })
  </script>
  