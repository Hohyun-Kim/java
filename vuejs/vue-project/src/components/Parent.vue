<!-- Parent.vue -->

<template>
  <div>
    <ParentChild
      @some-event="someCallback"
      @emit-args="getNumbers"
      @update-name="updateName"
      my-msg="안녕하세요 싸피입니다."
      :dynamic-props="name"
    />
  </div>
</template>

<script setup>
import { ref } from "vue";
import ParentChild from "@/components/ParentChild.vue";

const name = ref("Alice");

const someCallback = function () {
  console.log("ParentChild가 발신한 이벤트를 수신했어요.");
};

const getNumbers = function (...args) {
  console.log(args);
  console.log(`ParentChild가 전달한 추가인자 ${args}를 수신했어요.`);
};

const updateName = function () {
  name.value = "Bella";
};
</script>

<style scoped></style>
