<script setup>
import { ref, onMounted } from "vue";
import PageNavigation from "@/components/common/PageNavigation.vue";
import VSelect from "../common/VSelect.vue";

const articleList = [
  {
    articleNo: 100,
    subject: "안녕하세요1",
    userId: "ssafy",
    userName: "김싸피",
    hit: 123,
    registerDate: "25.12.25",
  },
  {
    articleNo: 99,
    subject: "안녕하세요2",
    userId: "admin",
    userName: "관리자",
    hit: 100,
    registerDate: "25.12.24",
  },
  {
    articleNo: 98,
    subject: "안녕하세요3",
    userId: "parkssafy",
    userName: "박싸피",
    hit: 78,
    registerDate: "24.12.31",
  },
  {
    articleNo: 97,
    subject: "안녕하세요4",
    userId: "ssafy",
    userName: "김싸피",
    hit: 33,
    registerDate: "24.12.20",
  },
  {
    articleNo: 97,
    subject: "내 생일이에요!!!",
    userId: "ssafy",
    userName: "김싸피",
    hit: 1004,
    registerDate: "23.12.20",
  },
];

const selectOption = ref([
  {text: "--- 선택 ---", value: ""},
  {text: "글 번호", value: "article_no"},
  {text: "제목", value: "subject"},
  {text: "작성자 아이디", value: "user_id"},
])

const articles = ref(articleList);
const currentPage = ref(7);
const totalPage = ref(40);

onMounted(() => {
  getArticleList()
});

const param = ref({
  pgno: currentPage.value,
  spp: import.meta.env.VITE_ARTICLE_LIST_SIZE,
  key: "", 
  word: ""
})

const changeKey = (val) => {
  console.log("변경된 key : " + val);
  param.value.key = val;
}

const getArticleList = () => {
  console.log("서버로 글목록 얻으러 가자!!!!", param.value);
}

const changePage = (val) => {
  console.log("변경된 페이지 : " + val);
  currentPage.value = val;
}
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
            <button type="button" class="btn btn-outline-primary btn-sm">글쓰기</button>
          </div>
          <div class="col-md-5 offset-5">
            <form class="d-flex">
              <VSelect :select-option="selectOption" @on-key-select="changeKey"/>
              <div class="input-group input-group-sm">
                <input type="text" v-model="param.word" class="form-control" placeholder="검색어..." />
                <button class="btn btn-dark" type="button" @click="getArticleList">검색</button>
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
                  :data-no="article.articleNo"
                  style="text-decoration: none"
                >
                  {{ article.subject }}
                </a>
              </td>
              <td>{{ article.userName }}</td>
              <td>{{ article.hit }}</td>
              <td>{{ article.registerDate }}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <PageNavigation :current-page="currentPage" :total-page="totalPage" @page-change="changePage"></PageNavigation>
    </div>
  </div>
</template>

<style scoped></style>
