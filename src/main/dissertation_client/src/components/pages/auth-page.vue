<template>  
  <v-container fluid>  
    <h1>Sign in / Sign up</h1>
    <v-row justify="center" align="center" style="height: 100vh;">  
      <v-col v-if="!isLogged" cols="12" sm="6" md="4">  
        <v-card class="mb-4">  
          <v-card-title class="headline">Авторизация</v-card-title>  
          <v-card-text>  
            <v-form ref="loginForm" v-model="loginValid">  
              <v-text-field  
                v-model="loginEmail"  
                :rules="emailRules"  
                label="Электронная почта"  
                required  
              ></v-text-field>  
              <v-text-field  
                v-model="loginPassword"  
                :rules="passwordRules"  
                label="Пароль"  
                type="password"  
                required  
              ></v-text-field>  
              <v-btn  
                :disabled="!loginValid"  
                color="primary"  
                @click="submitLogin"  
                block  
              >  
                Войти  
              </v-btn>  
            </v-form>  
          </v-card-text>  
        </v-card>  
      </v-col> 

      <v-col v-if="isLogged" cols="12" sm="6" md="4">
        <v-card class="mb-4">
          <v-btn    
            color="primary"  
            @click="logout"  
            block  
          >  
            Выйти  
          </v-btn> 
        </v-card>
      </v-col>

      <v-col cols="12" sm="6" md="4">  
        <v-card class="mb-4">  
          <v-card-title class="headline">Регистрация</v-card-title>  
          <v-card-text>  
            <v-form ref="registerForm" v-model="registrationValid">  
              <v-text-field  
                v-model="registerFirstname"  
                :rules="firstnameRules"  
                label="Имя"  
                required  
              ></v-text-field>  
              <v-text-field  
                v-model="registerLastname"  
                :rules="lastnameRules"  
                label="Фамилия"  
                required  
              ></v-text-field>  
              <v-text-field  
                v-model="registerEmail"  
                :rules="emailRules"  
                label="Электронная почта"  
                required  
              ></v-text-field>  
              <v-text-field  
                v-model="registerPassword"  
                :rules="passwordRules"  
                label="Пароль"  
                type="password"  
                required  
              ></v-text-field>  
              <v-text-field  
                v-model="confirmPassword"  
                :rules="confirmPasswordRules"  
                label="Подтверждение пароля"  
                type="password"  
                required  
              ></v-text-field>  
              <v-btn  
                :disabled="!registrationValid"  
                color="primary"  
                @click="submitRegistration"  
                block  
              >  
                Зарегистрироваться  
              </v-btn>
              <v-text-field
                v-model="token"  
                label="Подтверждение токена"  
                required  
              ></v-text-field>
              <v-btn
                color="primary"  
                @click="submitToken"  
                block  
              >  
                Подтвердить токен 
              </v-btn>
              <div v-if="correctToken">Токен подтвержден</div>
            </v-form>  
          </v-card-text>  
        </v-card>  
      </v-col>
    </v-row>  
  </v-container>  
</template>  

<script>
import { axiosInstance } from '@/plugins/axios.plugin';

export default { 
  name: 'auth-page', 
  data() {  
    return {  
      isLogged: localStorage.getItem('token') ? true : false,
      correctToken: false,
      token: localStorage.getItem('token') || '',
      
      // Данные для авторизации  
      loginEmail: '',  
      loginPassword: '',  
      loginValid: false,  
      
      // Данные для регистрации  
      registerEmail: '',  
      registerPassword: '',  
      confirmPassword: '',  
      registerFirstname: '',  
      registerLastname: '',  
      registrationValid: false,  
      emailRules: [  
        v => !!v || 'Электронная почта обязательна',  
        v => /.+@.+\..+/.test(v) || 'Электронная почта должна быть действительной',  
      ],  
      passwordRules: [  
        v => !!v || 'Пароль обязателен',  
        v => v.length >= 6 || 'Пароль должен содержать минимум 6 символов',  
      ],  
      confirmPasswordRules: [  
        v => !!v || 'Подтверждение пароля обязательно',  
        v => v === this.registerPassword || 'Пароли не совпадают',  
      ],  
      firstnameRules: [  
        v => !!v || 'Имя обязательно',  
        v => v.length <= 30 || 'Имя не должно превышать 30 символов',  
      ],  
      lastnameRules: [  
        v => !!v || 'Фамилия обязательна',  
        v => v.length <= 30 || 'Фамилия не должна превышать 30 символов',  
      ],

    };  
  },
  computed: {
    paramsForLogin() {
      return {
        email: this.loginEmail,
        password: this.loginPassword,
      }
    },
    paramsForRegistration() {
      return {
        firstname: this.registerFirstname,
        lastname: this.registerLastname,
        email: this.registerEmail,
        password: this.registerPassword,
      }
    }
  },
  methods: {  
    submitLogin() {  
      if (this.$refs.loginForm.validate()) {  
        this.$axios.post('auth/login', this.paramsForLogin)
          .then((response) => {
            if(response.status === 200) {
              this.isLogged = true;
              localStorage.setItem('token', response.data.value);
            }
          })
          .catch((e) => { console.log(e) }) 
      }  
    },  
    submitRegistration() {  
      if (this.$refs.registerForm.validate()) {  
        // Логика для регистрации  
        axiosInstance.post('auth/reg/', this.paramsForRegistration, { headers: { 'Content-Type': 'application/json', "Access-Control-Allow-Origin": "*" } })
          .then((response) => {
            if (response.status === 200) {
              localStorage.setItem('token', response.data.value);
            }
          })
          .catch((e) => { console.log(e) })
      }  
    },
    submitToken() {
      this.$axios.post(`auth/confirm?token=${this.token}`, this.paramsForLogin)
        .then(response =>{
          if (response.status === 200){
            this.correctToken = true
          } else {
            this.correctToken = false
          }
        })
        .catch((e) => { console.log(e) })

    },
    logout() {
      this.$axios.post('auth/logout', this.paramsForLogin, { headers: { 'Content-Type': 'application/json', "Access-Control-Allow-Origin": "*" } })
        .then((response) => {
          if(response.status === 200) {
            this.isLogged = false;
            localStorage.clear();
          }
        }) 
    }
  },  
};  
</script>  

<style scoped>  
.v-card {  
  padding: 20px;  
}  
</style>