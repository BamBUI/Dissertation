import axios from "axios";  

export const API_URL = "http://localhost:8080";  

const authApi = axios.create({  
  withCredentials: false,  
  baseURL: API_URL,  
});  

authApi.interceptors.request.use((config) => {  
  config.headers.Authorization = `Bearer ${localStorage.getItem('token')}`;  
  config.headers["Content-Type"] = "application/json";  
  return config;  
});  


const axiosInstance = axios.create({  
  baseURL: API_URL,  
  withCredentials: false,  
  headers: {  
    "Content-Type": "application/json",  
  },  
});  

export { axiosInstance }; 

// Default export for Vue plugin  
export default {  
  install: (app) => {  
    app.config.globalProperties.$axios = authApi;  
  },  
};  