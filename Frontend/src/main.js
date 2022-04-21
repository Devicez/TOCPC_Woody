import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import FomanticUI from 'vue-fomantic-ui'
import 'fomantic-ui-css/semantic.min.css'

import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

createApp(App).use(router).use(FomanticUI).mount('#app')