<!-- UserView.vue -->

<template>
  <div>
    <h1>UserView</h1>
    <!-- <h2>{{ $route.params.id }}번 User 페이지</h2> -->
    <h2>{{ userId }}번 User 페이지</h2>
    <button @click="goHome">홈으로!</button>
    <button @click="routeUpdate">100번 유저 페이지</button>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { onBeforeRouteLeave, onBeforeRouteUpdate } from 'vue-router'

const route = useRoute()
const userId = ref(route.params.id)

const router = useRouter()

const goHome = function () {
  router.push({ name: 'home' })
  // router.push({ name: 'home', replace: true })
  // router.replace({ name: 'home' })
}

onBeforeRouteLeave((to, from) => {
  const answer = window.confirm('정말 떠나실 건가요?')
  if (answer === false) {
    return false
  }
})

const routeUpdate = function () {
  router.push({ name: 'user', params: { id: 100 } })
}

// onBeforeRouteUpdate((to, from) => {
//   userId.value = to.params.id
// })

</script>

<style scoped>

</style>
