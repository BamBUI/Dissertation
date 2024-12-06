import "./assets/styles/main.css";

import { createApp } from "vue";
import App from "./App.vue";
import router from "@/plugins/router/index.js";
import AxiosPlugin from "@/plugins/axios.plugin.js";
import vuetify from "@/plugins/vuetify/vuetify.js";

const app = createApp(App);

app.use(router);
app.use(AxiosPlugin);
app.use(vuetify);

app.mount("#app");
