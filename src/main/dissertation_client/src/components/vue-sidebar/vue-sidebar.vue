<template>
  <v-navigation-drawer theme="dark" v-model="drawer" :rail="rail" permanent>
    <v-list-item nav>
      <template v-slot:append>
        <v-btn
          variant="text"
          :icon="!rail ? 'mdi-chevron-left' : 'mdi-chevron-right'"
          @click.stop="rail = !rail"
        ></v-btn>
      </template>
    </v-list-item>
    <v-divider></v-divider>
    <v-list
      density="compact"
      nav
      v-for="item in menuItems"
      :key="'menu-item_-' + item.id"
    >
      <v-list-item
        router
        :to="item.route"
        :prepend-icon="item.icon"
        :title="item.title"
      >
        <v-tooltip
          :disabled="!rail ? true : false"
          activator="parent"
          location="end"
          >{{ item.title }}</v-tooltip
        >
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
export default {
  name: "vue-sidebar",
  data() {
    return {
      login: true,
      drawer: true,
      rail: false,
      menuItems: [
        {
          id: 1,
          icon: "mdi-login",
          title: "Вход / Регистрация",
          route: "/auth",
        },
        {
          id: 2,
          icon: "mdi-home",
          title: "Главная",
          route: "/home",
        },
        {
          id: 3,
          icon: "mdi-arrow-all",
          title: "Построение диаграмм",
          route: "/build-diagrams",
        },
      ],
    };
  },
};
</script>

<style scoped></style>
