import React, { useState } from 'react'


import {createmaintainence, updateemaintainence} from '../services/maintainence'
import { useNavigate,useParams} from 'react-router-dom'
function CreatePlan() {
  
    const [assetId,setAssetId]=useState('')
    const [frequency,setFrequency]=useState('')
   
    
    
    const navigator = useNavigate();
   const{planId} = useParams();

    function handleAssetId(e){
        setAssetId(e.target.value)
        
    }
    function handleFrequency(e){
        setFrequency(e.target.value)
    }
    
  
    function saveandupdateAsset(e){
        e.preventDefault();
        const maintainence = {assetId,frequency}
        if(planId){
        try{
            updateemaintainence(planId,maintainence).then((response) =>{
            console.log(response.data);
            navigator('/maintenace');
          });
        }catch(error){

          };
        }else{
          try {
           console.log(maintainence)
           createmaintainence(maintainence).then((response)=>{
              console.log(response.data);
              navigator('/maintenace');
          } );
        }catch (error) {
            
          };
              
             // alert(response.data);
        
        }
        
      }
    function pageTitle(){
      if(planId){
        return  <h2 className='text-center'>update maintainencePlan</h2>
      }else{
        <h2 className='text-center'>Add maintainencePlan</h2>
      }
    }
      
      
  
  return (
    <div className='container'>
        <div className='row'>
          <div className='card'>
             {
              pageTitle()
             }
              <div className='card-body'>
                         <form >
                           <div className='form-group mb-2'>
                            <label className='form-label'>Asset name</label>
                            <input
                              type='text'
                              placeholder='enter the asset name'
                              name='AssetName'
                              value={assetId}
                              className='form-control'
                              onChange={handleAssetId}
                             >

                             </input>
                           </div>
                           <div className='form-group mb-2'>
                            <label className='form-label'>Asset type</label>
                            <input
                              type='text'
                              placeholder='enter the asset type'
                              name='AssetType'
                              value={frequency}
                              className='form-control'
                              onChange={handleFrequency}
                             >

                             </input>
                           </div>

                          
                        <button className='btn btn-success' onClick={saveandupdateAsset}>Submit</button>
                       
                       
                         </form>
              </div>


          </div>

        </div>



    </div>
  )
}

export default CreatePlan;