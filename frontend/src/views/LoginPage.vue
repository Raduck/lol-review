<template>
  <div class="min-h-screen flex items-center justify-center bg-gray-50">
    <div class="max-w-md w-full space-y-8">
      <div>
        <h2 class="mt-6 text-center text-3xl font-extrabold text-gray-900">
          LoL Review 로그인
        </h2>
        <p class="mt-2 text-center text-sm text-gray-600">
          League of Legends 리뷰 플랫폼
        </p>
      </div>
      <form class="mt-8 space-y-6" @submit.prevent="handleLogin">
        <div class="rounded-md shadow-sm -space-y-px">
          <div>
            <label for="username" class="sr-only">아이디</label>
            <input
              id="username"
              v-model="loginForm.username"
              name="username"
              type="text"
              required
              class="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-t-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
              placeholder="아이디"
            />
          </div>
          <div>
            <label for="password" class="sr-only">비밀번호</label>
            <input
              id="password"
              v-model="loginForm.password"
              name="password"
              type="password"
              required
              class="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-b-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
              placeholder="비밀번호"
            />
          </div>
        </div>

        <div>
          <button
            type="submit"
            :disabled="isLoading"
            class="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 disabled:opacity-50"
          >
            {{ isLoading ? '로그인 중...' : '로그인' }}
          </button>
        </div>

        <div class="text-center">
          <router-link
            to="/signup"
            class="font-medium text-indigo-600 hover:text-indigo-500"
          >
            회원가입
          </router-link>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import axios from '../api/axios'

export default {
  name: 'LoginPage',
  data() {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      isLoading: false
    }
  },
  methods: {
    async handleLogin() {
      this.isLoading = true
      try {
        const response = await axios.post('/users/login', this.loginForm)
        if (response.data.success) {
          localStorage.setItem('token', response.data.data.token)
          this.$router.push('/reviews')
        } else {
          alert('로그인 실패: ' + response.data.message)
        }
      } catch (error) {
        alert('로그인 실패: ' + (error.response?.data?.message || error.message))
      } finally {
        this.isLoading = false
      }
    }
  }
}
</script>
