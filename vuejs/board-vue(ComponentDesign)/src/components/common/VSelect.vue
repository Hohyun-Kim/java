<script setup>
import { ref } from "vue"
defineProps({
    selectOption: Array
})

const emit = defineEmits(["onKeySelect"])

const key = ref("")

const onSelect = () => {
    console.log(key.value + "선택!!!")
    emit("onKeySelect", key.value)
}
</script>

<template>
    <select v-model="key" @change="onSelect" class="form-select form-select-sm ms-5 me-1 w-50">
        <option v-for="opt in selectOption" :key="opt.value" :value="opt.value" :disabled="opt.value===''">{{opt.text}}</option>
    </select>
</template>

<style scoped>

</style>