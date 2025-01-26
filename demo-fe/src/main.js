import {createApp} from 'vue'
import {initRouter} from './router'
import App from './App.vue'
import {vueKeycloak} from "@josempgon/vue-keycloak";

const app = createApp(App);

await vueKeycloak.install(app, {
    config: {
        url: 'http://localhost:8081',
        realm: 'my-realm',
        clientId: 'my-app',
    },
})

app.use(initRouter())
app.mount('#app')