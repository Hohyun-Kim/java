<script setup>
import { useRouter, useRoute } from "vue-router";
import { ref, onMounted } from "vue";

const router = useRouter();
const route = useRoute();

let articleNo = ref(0);

onMounted(() => {
  console.log(router); // router 전체의 정보
  console.log(route); // 현재 호출된 해당 라우트의 정보 (Proxy)
  console.log(route.path); // 현재 호출된 라우트의 경로
  console.log(route.query); // 쿼리 정보
  console.log(route.params); // 파라미터 정보
  articleNo.value = route.params.no;
});
</script>

<template>
  <div class="container text-center mt-3">
    <h1>router02(파라미터를 사용한 동적 경로 매칭)</h1>
    <div class="alert alert-info" role="alert">자유롭게 글쓰는 공간</div>
    <div class="card">
      <div class="card-body">
        <h4 class="card-title">{{ articleNo }}번글 제목</h4>
        <p class="card-text">글 내용이 나와요</p>
        <router-link to="/r02/board">목록</router-link>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
