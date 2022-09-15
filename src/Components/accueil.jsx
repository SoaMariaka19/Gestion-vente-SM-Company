import React from "react";
import image from "../image/Luminaire/luminaire1.jpeg";
import image1 from "../image/Mobilier/mobilier1.jpeg";
import image2 from "../image/Tapis/tapis1.jpeg";
import { Navbar } from "./navbar";

export default function Accueil({closeModalHandler}){
    return(
        <>
        <Navbar/>
            <div className="premier" onClick={closeModalHandler}>
                <h2> Confiez-nous votre monde , afin de réaliser vos rêves </h2>
            </div>
            
            <div className="title">
                <h2>LES TOPS 3 DU MOMENT</h2>
            </div>
            <div className="bestall">
                <div className="one">
                    <span >Meilleure vente </span>
                    <img src={image} alt="" />
                    <button className="achat">Acheter</button>
                </div>
                <div className="two">
                    <span>Meilleure vente </span>
                    <img src={image1} alt="" />
                    <button className="achat">Acheter</button>
                </div>
                <div className="three">
                    <span>Meilleure vente </span>
                    <img src={image2} alt="" />
                    <button className="achat">Acheter</button>
                </div>
            </div>
        </>
    )
}