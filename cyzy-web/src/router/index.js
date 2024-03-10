import { createRouter, createWebHistory } from "vue-router";
import { useUserStore } from "@/stores/useUserStore.js";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      name: "welcome",
      component: () => import("@/views/welcome/Welcome.vue"),
      children: [
        {
          path: "login",
          name: "login-view",
          component: () => import("@/views/welcome/LoginView.vue"),
        },
      ],
    },
    {
      path: "/index",
      name: "index",
      component: () => import("@/views/Index.vue"),
      children: [
        {
          path: '/upload',
          name: 'upload',
          component: () => import("@/views/Upload.vue")
        }
      ]
    },
  ],
});


router.beforeEach((to, _from, next) => {
  const userStore = useUserStore();
  if (to.path !== "/login" && !userStore.getToken()) {
    next({ name: "login-view" });
  }
  next();
});

export default router;
