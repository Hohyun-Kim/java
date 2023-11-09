<script setup>
import TheHeadingNavbar from "./components/layout/TheHeadingNavbar.vue";
</script>

<template>
  <the-heading-navbar></the-heading-navbar>
  <!-- 현재 라우트에 맞는 Component가 렌더링 -->
  <router-view></router-view>
</template>

<style scoped></style>
