// store.js
import { createPinia, defineStore } from "pinia";

export const pinia = createPinia();

export const useAuthStore = defineStore({
  id: "auth",
  state: () => {
    return {
      user: {} as userData,
    };
  },
  actions: {
    setUser(user: userData) {
      this.user = user;
    },
    logout() {
      this.user = {} as userData;
    },
    getUser() {
      return this.user;
    },
  },
  persist: true,
});
