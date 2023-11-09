<!-- ParentChild.vue -->

<template>
  <div>
    <p>ParentChild : {{ myMsg }}</p>
    <ParentGrandChild :my-msg="myMsg" @update-name="updateName" />
    <p>ParentChild : {{ dynamicProps }}</p>
    <button @click="$emit('someEvent')">클릭</button>
    <button @click="buttonClick">클릭</button>
    <button @click="emitArgs">추가 인자 전달</button>
  </div>
</template>

<script setup>
import ParentGrandChild from "@/components/ParentGrandChild.vue";

defineProps({
  myMsg: String,
  dynamicProps: String,
});

const emit = defineEmits(["someEvent", "emitArgs", "updateName"]);

const buttonClick = function () {
  emit("someEvent");
};

const emitArgs = function () {
  emit("emitArgs", 1, 2, 3);
};

const updateName = function () {
  emit("updateName");
};
</script>

<style scoped></style>
