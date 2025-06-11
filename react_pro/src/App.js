import './App.css';
import ListAssetsComponent from './components/ListAssetsComponent';
//import HeaderComponent from './components/HeaderComponent';
import {BrowserRouter,Routes,Route} from 'react-router-dom'
import AssetComponent from './components/AssetComponent';
import MaintenancePlans from './components/MaintenancePlans';
import CreatePlan from './components/CreatePlan';
import HomePage from './components/HomePage'
import Tasklist from './components/Tasklist';
function App() {
  return (
    <>
    <BrowserRouter>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link" href="/assets">Assets</a>
        <a class="nav-link" href="/maintenance">Maintenance</a>
        <a class="nav-link" href="/workorder">Work Order</a>
        <a class="nav-link" href="/assignment">Assignment</a>
        <a class="nav-link" href="/report">Report</a>
      </div>
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

         <Route path='/update-maintainencePlan/:planId' element={<CreatePlan/>}></Route>
         <Route path='/workorder' element={<ListAssetsComponent/>}></Route>
         <Route path='/assignment' element={<ListAssetsComponent/>}></Route>
         <Route path='/report' element={<ListAssetsComponent/>}></Route>
          
       
        

    </Routes>
    </BrowserRouter>
    </>
  )
}

export default App;
