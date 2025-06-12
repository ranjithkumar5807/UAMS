import './App.css';
import ListAssetsComponent from './components/ListAssetsComponent';
//import HeaderComponent from './components/HeaderComponent';
import {BrowserRouter,Routes,Route} from 'react-router-dom'
import AssetComponent from './components/AssetComponent';
import MaintenancePlans from './components/MaintenancePlans';
import CreatePlan from './components/CreatePlan';
import HomePage from './components/HomePage'
import Tasklist from './components/Tasklist';
import UpdateMaintenancePlan from './components/UpdateMaintenancePlan';
import Login from './components/Login';
import Register from './components/Register';
import WorkOrderMainPage from './components/WorkOrderMainPage';
import WorkLogForm from './components/WorkLogForm';
import WorkLogList from './components/WorkLogList';
import WorkOrderForm from './components/WorkOrderForm';
import WorkOrderList from './components/WorkOrderList';

import TechnicianList from './components/TechnicianList';
import AssignTechnicianForm from './components/AssignTechnicianForm';
import AssignmentList from './components/AssignmentList';
import Reporting from "./components/Reporting";
function App() {
  return (
    <>
    <BrowserRouter>
   
{/* <nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow sticky-top">
  <div class="container-fluid d-flex justify-content-between align-items-center">
    <a class="navbar-brand fw-bold text-uppercase" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
      aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0 d-flex flex-row gap-3">
        <li class="nav-item">
          <a class="nav-link" href="/assets">Assets</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/maintenance">Maintenance</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/workorder">Work Order</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/technicians">Technicians</a>
        <a class="nav-link" href="/assign">Assign</a>
        <a class="nav-link" href="/assignments">Assignments</a>
        </li>
        <li class="nav-item" style={{marginRight:'580px'}}>
          <a class="nav-link" href="/report">Report</a>
        </li>
        <li>
        <a class="nav-link" href="/login">
        <button className='btn btn-warning'>Login</button>
        </a>
        </li>
      </ul>
      
      </div>
    </div>
 
</nav> */}

<nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow sticky-top">
  <div class="container-fluid">
   
    <a class="navbar-brand fw-bold text-uppercase" href="/">Home</a>

    
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
      aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

  
    <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
      <ul class="navbar-nav d-flex flex-row gap-4">
        <li class="nav-item"><a class="nav-link text-white" href="/assets">Assets</a></li>
        <li class="nav-item"><a class="nav-link text-white" href="/maintenance">Maintenance</a></li>
        <li class="nav-item"><a class="nav-link text-white" href="/workorder">Work Order</a></li>
        <li class="nav-item"><a class="nav-link text-white" href="/technicians">Technicians</a></li>
        <li class="nav-item"><a class="nav-link text-white" href="/assign">Assign</a></li>
        <li class="nav-item"><a class="nav-link text-white" href="/assignments">Assignments</a></li>
        <li class="nav-item"><a class="nav-link text-white" href="/report">Report</a></li>
      </ul>
    </div>

    
    <div class="d-flex">
      <a href="/login">
        <button class="btn btn-warning">Login</button>
      </a>
    </div>
  </div>
</nav>



     <Routes>
         <Route path='/' element={<HomePage/>}></Route>
         <Route path='/assets' element={<ListAssetsComponent/>}></Route>
        <Route path='/add-asset' element={<AssetComponent/>}></Route>
        <Route path='/update-asset/:assetId' element={<AssetComponent/>}></Route>
        
        <Route path="/maintenance" element={<MaintenancePlans />} />
        <Route path="/add-maintenance" element={<CreatePlan />} />
        <Route path="/tasks/:planId" element={<Tasklist />} />
        <Route path="/update-maintenance/:planId" element={<UpdateMaintenancePlan />} />
        {/* <Route path='/update-maintainencePlan/:planId' element={<CreatePlan/>}></Route> */}


         {/* <Route path='/workorder' element={<ListAssetsComponent/>}></Route> */}
         
         <Route path='/report' element={<Reporting/>}></Route> 
          
         <Route path='/login' element={<Login/>}></Route>
         <Route path='/register' element={<Register/>}></Route>
        
         

          <Route path='/workorder' element={<WorkOrderMainPage/>}></Route>
          <Route path='/workOrders' element={<WorkOrderList/>}></Route>
          <Route path='/addWorkOrder' element={<WorkOrderForm/>}></Route>
          <Route path='/workLogs' element={<WorkLogList/>}></Route>
          <Route path='/addWorkLog' element={<WorkLogForm/>}></Route>

          <Route path="/technicians" element={<TechnicianList />} />
         <Route path="/assign" element={<AssignTechnicianForm />} />
         <Route path="/assignments" element={<AssignmentList />} />

    </Routes>
    </BrowserRouter>
    </>
  )
}

export default App;
