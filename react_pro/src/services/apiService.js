// src/services/apiService.js

const BASE_URL = 'http://localhost:8090/api/reports'; // Adjust if your backend is on a different port/host

const apiService = {
    /**
     * Fetches asset maintenance history for a given asset ID.
     * GET /api/reports/asset-history?assetId={assetId}
     * @param {number} assetId - The ID of the asset.
     * @returns {Promise<Object>} - A promise that resolves with the asset history report.
     */
    getAssetHistoryReport: async (assetId) => {
        if (assetId === null || assetId === undefined) {
            throw new Error('Asset ID is required for asset history report.');
        }
        console.log(`[API] Fetching asset history for ID: ${assetId}`);
        const response = await fetch(`${BASE_URL}/asset-history?assetId=${assetId}`);

        if (!response.ok) {
            const errorData = await response.json().catch(() => ({ message: 'Failed to parse error response.' }));
            throw new Error(errorData.message || `HTTP error! Status: ${response.status}`);
        }
        return response.json();
    },

    /**
     * Fetches technician performance summary for a given technician ID.
     * GET /api/reports/technician-summary?technicianId={technicianId}
     * @param {number} technicianId - The ID of the technician.
     * @returns {Promise<Object>} - A promise that resolves with the technician summary report.
     */
    getTechnicianSummaryReport: async (technicianId) => {
        if (technicianId === null || technicianId === undefined) {
            throw new Error('Technician ID is required for technician summary report.');
        }
        console.log(`[API] Fetching technician summary for ID: ${technicianId}`);
        const response = await fetch(`${BASE_URL}/technician-summary?technicianId=${technicianId}`);

        if (!response.ok) {
            const errorData = await response.json().catch(() => ({ message: 'Failed to parse error response.' }));
            throw new Error(errorData.message || `HTTP error! Status: ${response.status}`);
        }
        return response.json();
    },

    /**
     * Fetches upcoming maintenance schedule for a given month and year.
     * GET /api/reports/schedule-overview?month={month}&year={year}
     * @param {number} month - The month (1-12).
     * @param {number} year - The year.
     * @returns {Promise<Object>} - A promise that resolves with the upcoming schedule report.
     */
    getScheduleOverviewReport: async (month, year) => {
        if (month === null || month === undefined || year === null || year === undefined) {
            throw new Error('Month and Year are required for upcoming schedule report.');
        }
        console.log(`[API] Fetching schedule for Month: ${month}, Year: ${year}`);
        const response = await fetch(`${BASE_URL}/schedule-overview?month=${month}&year=${year}`);

        if (!response.ok) {
            const errorData = await response.json().catch(() => ({ message: 'Failed to parse error response.' }));
            throw new Error(errorData.message || `HTTP error! Status: ${response.status}`);
        }
        return response.json();
    },
};

export default apiService;