import "./App.css";
import { Navbar } from "./Components/navbar";
import "./css/navbar.css";
import "./css/formulaire.css"
import Accueil from "./Components/accueil";
import "./css/accueil.css";
import Produits from "./Components/produits";
import "./css/produits.css";
import Form from "./Components/formulaire";
import Client from "./Components/formulaireClients";


import { BrowserRouter, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route element= {<Produits/>} path= '/supplies'/>
          <Route element= {<Accueil/>} path= '/'/> 
          <Route element= {<Client/>} path= '/'/>
         
        </Routes>
      </BrowserRouter>
      
    </>
  );
}

export default App;
