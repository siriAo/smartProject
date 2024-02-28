import {createRouter, createWebHistory} from 'vue-router'
import Home from '@/components/home/Home.vue'
import User from "@/components/user/User.vue";
import Login from "@/components/login/Login.vue";
import Doc from "@/components/doc/Doc.vue";
import Demo from "@/components/Demo.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            redirect: '/demo'
        },
        {
            path: '/demo',
            name: 'demo',
            component: Demo
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
                    path: 'user',
                    component: User,
                    name: "user"
                },
                {
                    path: 'doc',
                    component: Doc,
                    name: "doc"
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
