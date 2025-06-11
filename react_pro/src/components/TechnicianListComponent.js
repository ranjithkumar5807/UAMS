import { useEffect, useState } from 'react';
import {getAllTechnicians  } from '../services/technicianService';
import { useNavigate } from 'react-router-dom';

function TechnicianListComponent() {
  const [technicians, setTechnicians] = useState([]);
const navigator=useNavigate
  useEffect(() => {
    getAllTechnicians ().then(response => {
      setTechnicians(response.data);
    });
  }, []);
  function addNewTechnician(){
    navigator('/add-technician')
  }

  return (
    <div className='container'>
      <h2>Technician List</h2>
      <button className='btn btn-primary' onClick={addNewTechnician}>add asset</button>
      <table border="1" cellPadding="10" cellSpacing="0" className='table table-striped table-bordered'>
        <thead>
          <tr>
            <th>Technician ID</th>
            <th>Name</th>
            <th>Skill Set</th>
            <th>Region</th>
          </tr>
        </thead>
        <tbody>
          {technicians.map(tech => (
            <tr key={tech.technicianId}>
              <td>{tech.technicianId}</td>
              <td>{tech.name}</td>
              <td>{tech.skillSet}</td>
              <td>{tech.region}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default TechnicianListComponent;
