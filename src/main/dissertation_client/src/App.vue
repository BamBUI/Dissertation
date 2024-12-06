<template>
  <v-app class="app">
    <VueSidebar />
    <v-main class="component-container">
      <RouterView />
    </v-main>
  </v-app>
</template>

<script>
import { RouterView } from "vue-router";
import VueSidebar from "@/components/vue-sidebar/vue-sidebar.vue";

export default {
  name: "App",
  components: { RouterView, VueSidebar },
};
</script>

<style>
.app {
  width: 100%;
  height: 100%;
}
.component-container {
  margin: 15px 15px 15px 15px;
}
</style>
