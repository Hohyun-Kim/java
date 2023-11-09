<script setup>
import TheHeading from "./components/TheHeading.vue";
import Boardview from "@/components/BoardView.vue";
import IconHippo from "./components/icons/IconHippo.vue";
import IconPlane from "./components/icons/IconPlane.vue";
</script>

<template>
  <div>
  <h1>App.vue</h1>
    <TheHeading />
    <Boardview />
    <IconPlane />
    <IconHippo />
  </div>
</template>

<style scoped></style>