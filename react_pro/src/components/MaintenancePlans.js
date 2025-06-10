import React,{useEffect, useState} from 'react'
import {Listmaintainence} from '../services/maintainence'
import { useNavigate,useParams } from 'react-router-dom'

function MaintenancePlans() {
     
const [maintainence,setMaintainence]= useState([])
const navigator= useNavigate();
const{planId} = useParams();

useEffect(()=>{
    Listmaintainence().then((response) =>{
        setMaintainence(response.data);
    }).catch(error=>{
        console.error(error);
    })
},[])
function addNewmaintainenecePlan(){
  navigator('/add-maintainence')
}
 function UpdatemaintainenecePlan(planId){
  navigator(`/update-maintainencePlan/${planId}`)
 }
  return (
    <div className="container">
  <h2>list of assets</h2>
  <button className='btn btn-primary' onClick={addNewmaintainenecePlan}>add asset</button>
  <table className='table table-striped table-bordered'>
    <thead>
        <tr>
            <th>plan id</th>
            <th>asset Id</th>
            <th>frequency</th>
           
           

           
        </tr>
    </thead>
    <tbody>
       {
      maintainence.map(maintain =>
            <tr key={maintain.planId}>
            <td>{maintain.planId}</td>
            <td>{maintain.assetId}</td>
            <td>{maintain.frequency}</td>
           
            <td>
              <btn className='btn btn-success' onClick={()=>UpdatemaintainenecePlan(maintainence.planId)}>update</btn>
              </td>
            </tr>
        )
       }
    </tbody>
  </table>
    </div>
  )
}

export default MaintenancePlans