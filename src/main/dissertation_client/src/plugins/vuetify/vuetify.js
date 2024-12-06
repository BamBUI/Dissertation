import { createVuetify } from "vuetify";
import * as components from "vuetify/components";
import * as directives from "vuetify/directives";
import "@mdi/font/css/materialdesignicons.css";
import "vuetify/styles";
import ru from "vuetify/lib/locale/ru";

const vuetify = createVuetify({
  components,
  directives,
  icons: {
    defaultSet: "mdi",
    iconfont: "mdi",
    sets: {},
  },
  theme: {
    defaultTheme: "light",
  },
  lang: {
    locales: { ru },
    current: "ru",
  },
});

export default vuetify;
