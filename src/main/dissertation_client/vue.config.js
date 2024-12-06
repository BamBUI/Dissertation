const { defineConfig } = require('@vue/cli-service');  

module.exports = defineConfig({  
  transpileDependencies: true,  
  devServer: {  
    port: 3001,  // Set the desired port here  
    proxy: {  
      '/api': { // Change this to match your API endpoint path  
        target: 'http://localhost:8080', // Your backend server URL  
        changeOrigin: true,
      },  
    },
  },  
  chainWebpack: (config) => {  
    config.module  
      .rule('bpmn')  
      .test(/\.bpmn$/)  
      .use('raw-loader')  
      .loader('raw-loader')  
      .end();  
  },  
});  