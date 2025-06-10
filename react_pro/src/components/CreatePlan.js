import React, { useState } from "react";
import { createMaintenancePlan } from "../services/api";

const CreatePlan = () => {
    const [plan, setPlan] = useState({ name: "", description: "" });
    const [assetId, setAssetId] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await createMaintenancePlan(plan, assetId);
            alert("Maintenance plan created successfully!");
        } catch (error) {
            console.error("Error creating plan:", error);
            alert("Failed to create plan");
        }
    };

    return (
        <div>
            <h2>Create Maintenance Plan</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="Plan Name" required onChange={(e) => setPlan({ ...plan, name: e.target.value })} />
                <input type="text" placeholder="Description" required onChange={(e) => setPlan({ ...plan, description: e.target.value })} />
                <input type="number" placeholder="Asset ID" required onChange={(e) => setAssetId(e.target.value)} />
                <button type="submit">Create Plan</button>
            </form>
        </div>
    );
};

export default CreatePlan;
