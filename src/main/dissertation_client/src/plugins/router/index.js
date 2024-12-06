import { createRouter, createWebHistory } from "vue-router";
import Auth from "@/components/pages/auth-page.vue";
import Home from "@/components/pages/home-page.vue";
import BuildDiagrams from "@/components/pages/build-diagrams-page.vue";

const routes = [
  {
    path: "/auth",
    name: "auth",
    component: Auth,
    alias: "/",
  },
  {
    path: "/home",
    name: "home",
    component: Home,
  },
  {
    path: "/build-diagrams",
    name: "build-diagrams",
    component: BuildDiagrams,
    //meta: { requiresAuth: true },
  },
];

/*
// Глобальный охранник маршрутов  
router.beforeEach((to, from, next) => {  
  const isAuthenticated = !!localStorage.getItem('user'); // Проверяем, вошел ли пользователь  

  if (to.matched.some(record => record.meta.requiresAuth) && !isAuthenticated) {  
    // Если маршрут требует аутентификации и пользователь не вошел  
    next({ name: 'auth' }); // Перенаправляем на страницу входа  
  } else {  
    next(); // Продолжаем навигацию  
  }  
}); */ 

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
