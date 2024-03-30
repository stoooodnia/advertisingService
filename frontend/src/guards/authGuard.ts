import { useAuthStore } from "../stores/authStore";
import { RouteLocationNormalized, NavigationGuardNext } from "vue-router";

export const authGuard = (
  to: RouteLocationNormalized,
  from: RouteLocationNormalized,
  next: NavigationGuardNext
) => {
  const store = useAuthStore();
  const user = store.getUser();
  if (!user) {
    next({ name: "login" });
  } else {
    next();
  }
};
