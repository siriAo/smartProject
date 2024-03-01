import {createRouter, createWebHistory} from 'vue-router'
import Login from "@/components/login/Login.vue";
import Register from "@/components/login/Register.vue";
import Home from '@/components/home/Home.vue'
import User from "@/components/user/User.vue";
import UserManagement from "@/components/user/UserManagement.vue";
import Doc from "@/components/doc/Doc.vue";
import NewDoc from "@/components/doc/NewDoc.vue";
import Demo from "@/components/Demo.vue";



const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            redirect: '/home/login'
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
            path: '/register',
            name: 'register',
            component: Register
        },
        {
            path: '/home',
            name: 'home',
            component: Home,
            children: [
                {
                    path: 'newDoc',
                    component: NewDoc,
                    name: "newDoc"
                },
                {
                    path: 'user',
                    component: User,
                    name: "user"
                },
                {
                    path: 'userManagement',
                    component: UserManagement,
                    name: "userManagement"
                },
                {
                    path: 'doc',
                    component: Doc,
                    name: "doc"
                }
            ]
        }
    ]
})

export default router
