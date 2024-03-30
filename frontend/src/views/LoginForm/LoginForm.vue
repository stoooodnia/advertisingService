<template>
  <div class="flex items-center justify-center h-screen w-screen">
    <div class="flex flex-col gap-8 bg-white border border-my-light-gray rounded-lg w-[574px] h-[432px] p-6">
        <h1 class="text-2xl font-semibold">Logowanie</h1>
      <div class="flex flex-col gap-4 relative">
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
        <Button class="rounded-lg px-[16px] hover:font-semibold transition-all" :action="register" size="labelOnly" label="Zarejestruj się"/>
        <Button class="rounded-lg px-[30px]" :action="submit" color="black" size="labelOnly" label="Zaloguj"/>
      </div>
    </div>
  </div>
  </template>
  
  <script lang="ts">
  import { defineComponent } from 'vue'
  import Button from '../../components/Button/Button.vue'
  import authService from '../../services/authService'
  import { useAuthStore } from '../../stores/authStore'
  
  export default defineComponent({
    components: {
      Button
    },
    data() {
      return {
        form: {
          email: "",
          password: "",
        },
        errors: {
          email: false,
          password: false,
        }
      }
    },
    methods: {
      validate() {
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
      register() {
        this.$router.push('/register')
      },
      submit() {
        if(!this.validate()) {
          return
        }
        this.login().then((res) => {
          const user = res.data.user
          const store = useAuthStore();
          store.setUser(user)
          this.$router.push('/')
        }).catch(() => {
          this.errors.email = true
          this.errors.password = true
        })
      },
      login() {
        const data = {
          email: this.form.email,
          password: this.form.password,
        }      
        return authService.login(data)
      },
      }
    })
  </script>