import { useAuthStore } from "../stores/authStore";
import { RouteLocationNormalized, NavigationGuardNext } from "vue-router";

export const authGuard = (
  // @ts-ignore
  to: RouteLocationNormalized,
  // @ts-ignore
  from: RouteLocationNormalized,
  next: NavigationGuardNext
) => {
  const store = useAuthStore();
  const user = store.getUser();

  if (user.id === undefined) {
    next({ name: "login" });
  } else {
    next();
  }
};
