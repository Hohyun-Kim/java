<script setup>
import { ref } from "vue";

const props = defineProps({ type: String });

const article = ref({
  articleNo: 0,
  subject: "",
  content: "",
  userId: "",
  userName: "",
  hit: 0,
  registerDate: "",
});

if (props.type === "modify") {
  article.value = {
    articleNo: 100,
    subject: "안녕하세요 뷰테스트 중입니다.",
    content:
      "뷰테스트 중입니다. 컴포넌트 연습하고 있으며, 앞으로 props와 custom event를 처리 할 예정입니다.",
    userId: "ssafy",
    userName: "김싸피",
    hit: 123,
    registerDate: "25.01.01",
  };
}

const button_class = (val) => {
  return button_common + val;
};

const button_common = "btn mb-3 btn-outline-";

const button_detail = {
  write: "primary",
  modify: "success",
  "go-to-list": "danger ms-1",
};
</script>

<template>
  <form>
    <div class="mb-3">
      <label for="userid" class="form-label">작성자 ID : </label>
      <input
        type="text"
        class="form-control"
        v-model="article.userId"
        placeholder="작성자ID..."
      />
    </div>
    <div class="mb-3">
      <label for="subject" class="form-label">제목 : </label>
      <input
        type="text"
        class="form-control"
        v-model="article.subject"
        placeholder="제목..."
      />
    </div>
    <div class="mb-3">
      <label for="content" class="form-label">내용 : </label>
      <textarea class="form-control" v-model="article.content" rows="7"></textarea>
    </div>
    <div class="col-auto text-center">
      <button type="button" :class="button_class(button_detail[props.type])">
        {{ props.type === "modify" ? "글수정" : "글쓰기" }}
      </button>
      <button type="button" :class="button_class(button_detail['go-to-list'])">
        목록으로이동...
      </button>
    </div>
  </form>
</template>

<style scoped></style>
