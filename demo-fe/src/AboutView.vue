<script setup>
import {onMounted, ref} from "vue";
import {getToken} from "@josempgon/vue-keycloak";

const roles = ref('still fetching...');

async function fetchData() {
  try {
    const token = await getToken()
    const res = await fetch(
        'http://localhost:8080/roles', {
          headers: {
            'Authorization': 'Bearer ' + token,
          }
        }
    );
    if (!res.ok) {
      roles.value = 'error while fetching data';
      return;
    }
    const data = await res.json();
    roles.value = data.roles;
  } catch (err) {
    alert('Something went wrong performing the API call')
  }
}

onMounted(() => fetchData());
</script>

<template>
  <h2>AboutView</h2>
  <p>The roles of your user are: {{ roles }}</p>
</template>