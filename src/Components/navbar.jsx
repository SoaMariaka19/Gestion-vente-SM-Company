import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router";



export function Navbar(){
    const navigate = useNavigate()

    const [show,setShow] = useState(false)
    const handleSubmit = (e) => {
        e.preventDefault();
     };

    return(
        <>
            <nav className="stroke" >
                <ul>
                    <li><a href="#">Accueil</a></li>
                    <li><a href="#" onClick={()=>navigate('/supplies')}>Nos produits</a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a href="#" onClick={()=>setShow(true)}>S'inscrire</a></li>
                    <button>Se connecter</button>
                </ul>
            </nav>
      <div className="modal-wrapper"
      style={{
        transform : show ? 'translateY(0vh)' : 'translateY(-100vh)',
        opacity : show ? '1' : '0'
      }}
      > 
         <div className="modal-header" onClick={()=>setShow(false)}>
            <b className="add" >CONNEXION</b>
            <span className="close-modal-btn"onClick={()=>setShow(false)} >X</span>
        </div> 
        <div className="modal-content">
            <div className="modal-body">
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="Nom "/>
                <input type="text" placeholder="Prénom"/>
                <input type="text" placeholder="Mail"/>
                <button className="btn-cancel" >Se connecter</button>
            </form>

         </div>
            <div className="modal-footer">
               
            </div>
            </div>
        
      </div>
      </>      
       
    );
}