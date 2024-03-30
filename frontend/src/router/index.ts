import { authGuard } from "../guards/authGuard";
import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: () => import("../views/Home/Home.vue"),
      beforeEnter: authGuard,
    },
    {
      path: "/specializacje",
      name: "specializations",
      component: () => import("../views/Specializations/Specializations.vue"),
      beforeEnter: authGuard,
    },
    {
      path: "/login",
      name: "login",
      component: () => import("../views/LoginForm/LoginForm.vue"),
    },
    {
      path: "/register",
      name: "register",
      component: () => import("../views/RegisterForm/RegisterForm.vue"),
    },
  ],
});

export default router;
