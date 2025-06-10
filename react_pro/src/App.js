import './App.css';
import ListAssetsComponent from './components/ListAssetsComponent';
import HeaderComponent from './components/HeaderComponent';
import {BrowserRouter,Routes,Route} from 'react-router-dom'
import AssetComponent from './components/AssetComponent';
import MaintenancePlans from './components/MaintenancePlans';
import CreatePlan from './components/CreatePlan';
function App() {
  return (
    <>
    <BrowserRouter>
    <HeaderComponent/>
     <Routes>
         <Route path='/' element={<ListAssetsComponent/>}></Route>
         <Route path='/assets' element={<ListAssetsComponent/>}></Route>
        <Route path='/add-asset' element={<AssetComponent/>}></Route>
        <Route path='/update-asset/:assetId' element={<AssetComponent/>}></Route>
        <Route path='/maintainence' element={<MaintenancePlans/>}></Route>
        <Route path='/create' element={<CreatePlan/>}></Route>
        

    </Routes>
    </BrowserRouter>
    </>
  )
}

export default App;
