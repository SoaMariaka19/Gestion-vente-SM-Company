import React from "react";

export default function Client(){
    return(
        <>
            <section className="page">
            <h2>Voulez-vous faire partie de nos clients , inscrivez-vous </h2>
            <form action="">
                <ul>
                        <label htmlFor="nom">Nom</label><br />
                        <input type="text" className="nom" placeholder="votre nom"/>
                </ul>

            </form>
            </section>
        </>
    )
}