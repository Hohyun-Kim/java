<script setup>
import PageNavigation from "../common/PageNavigation.vue";
import { ref } from "vue";
const articles = ref([
    { articleNo: 100, subject: "제목", content: "내용이야", userId: "ssafy", hit: 100, registerDate: "23.11.07"},
    { articleNo: 99, subject: "제목", content: "내용이야", userId: "ssafy", hit: 100, registerDate: "23.11.07"},
    { articleNo: 98, subject: "제목", content: "내용이야", userId: "ssafy", hit: 100, registerDate: "23.11.07"},
    { articleNo: 97, subject: "제목", content: "내용이야", userId: "ssafy", hit: 100, registerDate: "23.11.07"},
    { articleNo: 96, subject: "제목", content: "내용이야", userId: "ssafy", hit: 100, registerDate: "23.11.07"},
])
</script>

<template>
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-10">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">글목록</mark>
          </h2>
        </div>
        <div class="col-lg-10">
          <div class="row align-self-center mb-2">
            <div class="col-md-2 text-start">
              <button type="button" id="btn-mv-register" class="btn btn-outline-primary btn-sm">
                글쓰기
              </button>
            </div>
            <div class="col-md-5 offset-5">
              <form class="d-flex">
                <select
                  id="key"
                  class="form-select form-select-sm ms-5 me-1 w-50"
                  aria-label="검색조건"
                >
                  <option selected>검색조건</option>
                  <option value="article_no">글번호</option>
                  <option value="subject">제목</option>
                  <option value="user_id">작성자</option>
                </select>
                <div class="input-group input-group-sm">
                  <input type="text" class="form-control" placeholder="검색어..." />
                  <button class="btn btn-dark" type="button">검색</button>
                </div>
              </form>
            </div>
          </div>
          <table class="table table-hover">
            <thead>
              <tr class="text-center">
                <th scope="col">글번호</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">조회수</th>
                <th scope="col">작성일</th>
              </tr>
            </thead>
            <tbody>
              <tr class="text-center" v-for="article in articles" :key="article.articleNo">
                <th scope="row">{{ article.articleNo }}</th>
                <td class="text-start">
                  <a
                    href="#"
                    class="article-title link-dark"
                    data-no="93"
                    style="text-decoration: none"
                  >
                    {{ article.subject }}
                  </a>
                </td>
                <td>{{ article.userId }}</td>
                <td>{{ article.hit }}</td>
                <td>{{ article.registerDate }}</td>
              </tr>
            </tbody>
          </table>
        </div>
        <PageNavigation />
      </div>
    </div>
</template>

<style scoped>
    
</style>