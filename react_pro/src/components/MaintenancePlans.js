import React, { useState, useEffect } from "react";
import { getAllMaintenancePlans, deleteMaintenancePlan } from "../services/api";

const MaintenancePlans = () => {
    const [plans, setPlans] = useState([]);
       
    useEffect(() => {
        const fetchPlans = async () => {
            try {
                const response = await getAllMaintenancePlans();
                setPlans(response.data);
            } catch (error) {
                console.error("Error fetching plans:", error);
            }
        };
        fetchPlans();
    }, []);

    const handleDelete = async (id) => {
        try {
            await deleteMaintenancePlan(id);
            setPlans(plans.filter(plan => plan.id !== id));
            alert("Plan deleted successfully!");
        } catch (error) {
            console.error("Error deleting plan:", error);
            alert("Failed to delete plan");
        }
    };

    return (
        <div>
            <h2>Maintenance Plans</h2>
            <ul>
                {plans.map(plan => (
                    <li key={plan.id}>
                        {plan.name} - {plan.description}
                        <button onClick={() => handleDelete(plan.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default MaintenancePlans;
