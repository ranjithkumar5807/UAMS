import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const Tasklist = () => {
  const { planId } = useParams();
  const [taskList, setTaskList] = useState([]);
  const [description, setDescription] = useState('');
  const [estimatedHours, setEstimatedHours] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');

  useEffect(() => {
    fetchTasks();
  }, [planId]);

  const fetchTasks = async () => {
    try {
      const response = await axios.get(`http://localhost:8082/api/maintenance-plans/tasks`);
      setTaskList(response.data);
    } catch (err) {
      console.error('Error fetching tasks:', err);
      setError('Could not load tasks.');
    }
  };

  const handleAddTask = async (e) => {
    e.preventDefault();
    const task = { description, estimatedHours };

    try {
      await axios.post(`http://localhost:8082/api/maintenance-plans/tasks/${planId}`, task);
    } catch (err) {
      console.error('Error adding task:', err);
      setError('Failed to add task.');
      setSuccess('');
    }
  };

  return (
    <div className="container">
      <h2>Tasks for Maintenance Plan ID: {planId}</h2>

      {error && <div className="alert alert-danger">{error}</div>}
      {success && <div className="alert alert-success">{success}</div>}

      <form onSubmit={handleAddTask}>
        <div className="form-group">
          <label>Description:</label>
          <input
            type="text"
            className="form-control"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label>Estimated Hours:</label>
          <input
            type="number"
            className="form-control"
            value={estimatedHours}
            onChange={(e) => setEstimatedHours(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary mt-2">Add Task</button>
      </form>

      <table className="table table-bordered mt-4">
        <thead>
          <tr>
            <th>Description</th>
            <th>Estimated Hours</th>
          </tr>
        </thead>
        <tbody>
          {taskList.map(task => (
            <tr key={task.taskId}>
              <td>{task.description}</td>
              <td>{task.estimatedHours}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Tasklist;
