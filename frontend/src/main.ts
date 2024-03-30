import { createApp } from "vue";
import "./style.css";

import App from "./App.vue";
import router from "./router";

import { createPinia } from "pinia";
import piniaPluginPersistedstate from "pinia-plugin-persistedstate";

import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import {
  faShop,
  faBriefcase,
  faPenToSquare,
  faTrashCan,
  faMagnifyingGlass,
  faX,
  faPlus,
  faChevronDown,
  faUser,
} from "@fortawesome/free-solid-svg-icons";

library.add(
  faShop,
  faBriefcase,
  faPenToSquare,
  faTrashCan,
  faMagnifyingGlass,
  faX,
  faPlus,
  faChevronDown,
  faUser
);

const app = createApp(App);

const pinia = createPinia();
pinia.use(piniaPluginPersistedstate);
app.use(pinia);

app.component("font-awesome-icon", FontAwesomeIcon);
app.use(router);

app.mount("#app");
