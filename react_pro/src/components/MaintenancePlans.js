import React, { useEffect, useState } from 'react';
import { getAllMaintenancePlans, deleteMaintenancePlan } from '../services/api';
import { useNavigate } from 'react-router-dom';

const MaintenancePlans = () => {
  const [plans, setPlans] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    loadPlans();
  }, []);

  const loadPlans = async () => {
    try {
      const res = await getAllMaintenancePlans();
      setPlans(res.data);
    } catch (error) {
      console.error('Error loading plans:', error);
    }
  };

  const handleDelete = async (id) => {
    await deleteMaintenancePlan(id);
    loadPlans();
  };

  return (
    <div className="container">
      <h2>Maintenance Plans</h2>
      <button className="btn btn-primary" onClick={() => navigate('/add-maintenance')}>Create Plan</button>
      <table className="table table-bordered">
        <thead>
          <tr>
            <th>Plan ID</th>
            <th>Asset ID</th>
            <th>Frequency</th>
            <th>Task List</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {plans.map(plan => (
            <tr key={plan.planId}>
              <td>{plan.planId}</td>
              <td>{plan.assetId}</td>
              <td>{plan.frequency}</td>
              <td>
                <button className="btn btn-info" onClick={() => navigate(`/tasks/${plan.planId}`)}>View Tasks</button>
              </td>
              <td>
                <button className="btn btn-warning" onClick={() => navigate(`/update-maintenance/${plan.planId}`)}>Update</button>
                <button className="btn btn-danger" onClick={() => handleDelete(plan.planId)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default MaintenancePlans;
