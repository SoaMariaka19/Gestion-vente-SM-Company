import React from "react";
import "../css/accueil.css";
import image from "../image/Mobilier/mobilier1.jpeg";
import image1 from "../image/Mobilier/mobilier2.jpeg";
import image2 from "../image/Mobilier/mobilier3.jpeg";
import image3 from "../image/Mobilier/mobilier4.jpeg";
import image4 from "../image/Mobilier/mobilier5.jpeg";
import image5 from "../image/Mobilier/mobilier6.jpeg";

import Image from "../image/Luminaire/luminaire1.jpeg";
import Image1 from "../image/Luminaire/luminaire2.jpeg";
import Image2 from "../image/Luminaire/luminaire3.jpeg";
import Image3 from "../image/Luminaire/luminaire4.jpeg";
import Image4 from "../image/Luminaire/luminaire5.jpeg";
import Image5 from "../image/Luminaire/luminaire6.jpeg";

import imagE from "../image/Tapis/tapis1.jpeg";
import imagE1 from "../image/Tapis/tapis2.jpeg";
import imagE2 from "../image/Tapis/tapis3.jpeg";
import imagE3 from "../image/Tapis/tapis4.jpeg";
import imagE4 from "../image/Tapis/tapis5.jpeg";
import imagE5 from "../image/Tapis/tapis6.jpeg";

import { useNavigate } from "react-router";
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Accueil from "./accueil";

export default function Produits(){
    const navigate = useNavigate
    return(
        <>
            
            <button >Accueil</button>
            <div className="supplies">
                    <h2>Mobiliers</h2>
                    <div className="lampes">
                        <div className="one">
                            
                            <img src={image} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        <div className="one">
                            
                            <img src={image1} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        <div className="one">
                            <img src={image2} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        
                        <div className="one">
                            <img src={image3} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        <div className="one">
                            <img src={image4} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        <div className="one">
                            <img src={image5} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        
                    </div>

                    <h2>Luminaires</h2>
                    <div className="lampes">
                        <div className="one">
                            <img src={Image} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        <div className="one">
                            <img src={Image1} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        <div className="one">
                            <img src={Image2} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        
                        <div className="one">
                            <img src={Image3} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        <div className="one">
                            <img src={Image4} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        <div className="one">
                            <img src={Image5} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                    </div>

                    <h2>Tapis</h2>
                    <div className="lampes">
                        <div className="one">
                            <img src={imagE} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        <div className="one">
                            <img src={imagE1} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        <div className="one">
                            <img src={imagE2} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        
                        <div className="one">
                            <img src={imagE3} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        <div className="one">
                            <img src={imagE4} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                        <div className="one">
                            <img src={imagE5} alt="" />
                            <button className="achat">Acheter</button>
                        </div>
                    </div>

            </div>
        </>
    )
}