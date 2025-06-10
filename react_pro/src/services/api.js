import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api/assets";

export const createMaintenancePlan = (plan, assetId) =>
    axios.post(`${API_BASE_URL}`, plan, { params: { assetId } });

export const getMaintenancePlans = (assetId) =>
    axios.get(`${API_BASE_URL}`, { params: { assetId } });

export const getAllMaintenancePlans = () =>
    axios.get(`${API_BASE_URL}/getAll`);

export const getMaintenancePlanById = (id) =>
    axios.get(`${API_BASE_URL}/${id}`);

export const updateMaintenancePlan = (id, plan) =>
    axios.put(`${API_BASE_URL}/${id}`, plan);

export const deleteMaintenancePlan = (id) =>
    axios.delete(`${API_BASE_URL}/delete`, { params: { id } });

export const deleteAllMaintenancePlans = () =>
    axios.delete(`${API_BASE_URL}/deleteAll`);
