<script setup>
import { RouterLink, useRouter } from "vue-router";
import IconHome from "@/components/icons/IconHome.vue";
import IconBoard from "@/components/icons/IconBoard.vue";
import IconPicture from "@/components/icons/IconPicture.vue";
import IconFile from "@/components/icons/IconFile.vue";
import DropDownIconMenuSlot from "@/components/common/DropDownIconMenuSlot.vue";

const router = useRouter();

function moveMain() {
  // router.replace({ path: "/" }); // 현재 라우트를 대체
  // router.push({ path: "/", replace: true }); // 위와 같음
  router.push({ name: "main" }); // 새 히스토리 항목을 푸시
}

function moveBoard() {
  router.push("/r04/board");
}
</script>

<template>
  <nav class="navbar navbar-expand-md bg-body-tertiary">
    <div class="container">
      <router-link to="/">
        <img src="@/assets/ssafy_logo.png" class="rounded mx-auto d-block w-75" alt="..." />
      </router-link>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarScroll"
        aria-controls="navbarScroll"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarScroll">
        <ul
          class="navbar-nav me-auto my-2 my-md-0 navbar-nav-scroll"
          style="--bs-scroll-height: 100px"
        >
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              Router 기본
            </a>
            <ul class="dropdown-menu">
              <li>
                <router-link to="/" class="dropdown-item">
                  <drop-down-icon-menu-slot>
                    <template v-slot:icon>
                      <icon-home></icon-home>
                    </template>
                    <template v-slot:label> Home </template>
                  </drop-down-icon-menu-slot>
                </router-link>
              </li>
              <li>
                <router-link to="/r01/board" class="dropdown-item">
                  <drop-down-icon-menu-slot>
                    <template v-slot:icon>
                      <icon-board></icon-board>
                    </template>
                    <template v-slot:label> 자유글 </template>
                  </drop-down-icon-menu-slot>
                </router-link>
              </li>
              <li>
                <router-link to="/r01/picture" class="dropdown-item">
                  <drop-down-icon-menu-slot>
                    <template v-slot:icon>
                      <icon-picture></icon-picture>
                    </template>
                    <template v-slot:label> 사진자랑 </template>
                  </drop-down-icon-menu-slot>
                </router-link>
              </li>
              <li>
                <router-link to="/r01/file" class="dropdown-item">
                  <drop-down-icon-menu-slot>
                    <template v-slot:icon>
                      <icon-file></icon-file>
                    </template>
                    <template v-slot:label> 파일공유 </template>
                  </drop-down-icon-menu-slot>
                </router-link>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      <div class="collapse navbar-collapse" id="navbarScroll">
        <ul
          class="navbar-nav me-auto my-2 my-md-0 navbar-nav-scroll"
          style="--bs-scroll-height: 100px"
        >
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              동적경로매칭
            </a>
            <ul class="dropdown-menu">
              <li>
                <router-link to="/r02/board" class="dropdown-item">
                  <drop-down-icon-menu-slot>
                    <template v-slot:icon>
                      <icon-board></icon-board>
                    </template>
                    <template v-slot:label> 자유글 </template>
                  </drop-down-icon-menu-slot>
                </router-link>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      <div class="collapse navbar-collapse" id="navbarScroll">
        <ul
          class="navbar-nav me-auto my-2 my-md-0 navbar-nav-scroll"
          style="--bs-scroll-height: 100px"
        >
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              이름이있는라우트
            </a>
            <ul class="dropdown-menu">
              <li>
                <router-link :to="{ name: 'main' }" class="dropdown-item">
                  <drop-down-icon-menu-slot>
                    <template v-slot:icon>
                      <icon-home></icon-home>
                    </template>
                    <template v-slot:label> Home </template>
                  </drop-down-icon-menu-slot>
                </router-link>
              </li>
              <li>
                <router-link :to="{ name: 'board3' }" class="dropdown-item">
                  <drop-down-icon-menu-slot>
                    <template v-slot:icon>
                      <icon-board></icon-board>
                    </template>
                    <template v-slot:label> 자유글 </template>
                  </drop-down-icon-menu-slot>
                </router-link>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      <div class="collapse navbar-collapse" id="navbarScroll">
        <ul
          class="navbar-nav me-auto my-2 my-md-0 navbar-nav-scroll"
          style="--bs-scroll-height: 100px"
        >
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              프로그래밍방식라우트
            </a>
            <ul class="dropdown-menu">
              <li>
                <a @click="moveMain()" class="dropdown-item">
                  <drop-down-icon-menu-slot>
                    <template v-slot:icon>
                      <icon-home></icon-home>
                    </template>
                    <template v-slot:label> Home </template>
                  </drop-down-icon-menu-slot>
                </a>
              </li>
              <li>
                <a @click="moveBoard()" class="dropdown-item">
                  <drop-down-icon-menu-slot>
                    <template v-slot:icon>
                      <icon-board></icon-board>
                    </template>
                    <template v-slot:label> 자유글 </template>
                  </drop-down-icon-menu-slot>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      <div class="collapse navbar-collapse" id="navbarScroll">
        <ul
          class="navbar-nav me-auto my-2 my-md-0 navbar-nav-scroll"
          style="--bs-scroll-height: 100px"
        >
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              중첩된라우트
            </a>
            <ul class="dropdown-menu">
              <li>
                <router-link :to="{ name: 'main' }" class="dropdown-item">
                  <drop-down-icon-menu-slot>
                    <template v-slot:icon>
                      <icon-home></icon-home>
                    </template>
                    <template v-slot:label> Home </template>
                  </drop-down-icon-menu-slot>
                </router-link>
              </li>
              <li>
                <router-link :to="{ name: 'board5' }" class="dropdown-item">
                  <drop-down-icon-menu-slot>
                    <template v-slot:icon>
                      <icon-board></icon-board>
                    </template>
                    <template v-slot:label> 자유글 </template>
                  </drop-down-icon-menu-slot>
                </router-link>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      <div class="collapse navbar-collapse" id="navbarScroll">
        <ul
          class="navbar-nav me-auto my-2 my-md-0 navbar-nav-scroll"
          style="--bs-scroll-height: 100px"
        >
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              props로 데이터전달
            </a>
            <ul class="dropdown-menu">
              <li>
                <router-link :to="{ name: 'main' }" class="dropdown-item">
                  <drop-down-icon-menu-slot>
                    <template v-slot:icon>
                      <icon-home></icon-home>
                    </template>
                    <template v-slot:label> Home </template>
                  </drop-down-icon-menu-slot>
                </router-link>
              </li>
              <li>
                <router-link :to="{ name: 'board6' }" class="dropdown-item">
                  <drop-down-icon-menu-slot>
                    <template v-slot:icon>
                      <icon-board></icon-board>
                    </template>
                    <template v-slot:label> 자유글 </template>
                  </drop-down-icon-menu-slot>
                </router-link>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<style scoped></style>
