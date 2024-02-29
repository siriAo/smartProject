import {createRouter, createWebHistory} from 'vue-router'
import Home from '@/components/home/Home.vue'
import User from "@/components/user/User.vue";
import UserManagement from "@/components/user/UserManagement.vue";
import Login from "@/components/login/Login.vue";
import Doc from "@/components/doc/Doc.vue";
import Demo from "@/components/Demo.vue";
import NewDoc from "@/components/doc/NewDoc.vue";


const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            redirect: '/home/newDoc'
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
