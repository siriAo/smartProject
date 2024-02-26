import {createRouter, createWebHistory} from 'vue-router'
import Home from '../components/home/Home.vue'
import User from "@/components/user/User.vue";
import Login from "@/components/login/Login.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            redirect: '/login'
        },
        {
          path: '/login',
          name: 'login',
          component: Login
        },
        {
            path: '/home',
            name: 'home',
            component: Home,
            children: [
                {
                    path: '/user',// 0是普通订单 1是秒杀订单,
                    component: User,
                    name: "user"
                }
            ]
        },
        // {
        // path: '/about',
        // name: 'about',
        // route level code-splitting
        // this generates a separate chunk (About.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        // component: () => import('../views/AboutView.vue')
        // }
    ]
})

export default router
