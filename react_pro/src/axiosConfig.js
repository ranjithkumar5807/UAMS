// src/axiosConfig.js
import axios from 'axios';

axios.interceptors.request.use(config => {
  const token = localStorage.getItem('jwtToken');
  if (token) {
    config.headers['Authorization'] = `Bearer ${token}`;
  }
  return config;
}, error => {
  return Promise.reject(error);
});



// import axios from 'axios';

// // Request interceptor to attach token
// axios.interceptors.request.use(config => {
//   const token = localStorage.getItem('jwtToken');
//   if (token) {
//     config.headers['Authorization'] = `Bearer ${token}`;
//   }
//   return config;
// }, error => {
//   return Promise.reject(error);
// });

// Response interceptor to handle 403 errors
axios.interceptors.response.use(
  response => response,
  error => {
    if (error.response && error.response.status === 403) {
      alert('Unauthorized access. Please log in again.');
      localStorage.removeItem('jwtToken'); // Optional: clear token
      window.location.href = '/login'; // Redirect to login
    }
    return Promise.reject(error);
  }
);
