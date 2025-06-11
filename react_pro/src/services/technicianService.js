// services/technicianService.js

import axios from 'axios';

const TECHNICIAN_API_BASE_URL = 'http://localhost:8088/api/technicians';

// // Get all technicians
// export const listAllTechnicians = () => {
//   return axios.get(TECHNICIAN_API_BASE_URL);
// };

// Get technicians by region (using path variable)

export const getAllTechnicians = () => {
      return axios.get(TECHNICIAN_API_BASE_URL);
}    