import React from "react";
import "./CardList.css"; // Import CSS file

export default function CardList() {
  const cards = [
    {
      id: 1,
      img: "https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcTeOMdL0S31xibzIP8Uj8WUKlAAF_1HARCVnRTimBr33Wpy-xcAUyulcpXQAYNPoc42ZCRMkrld9N4VJFdc-sTEqk-TRhMna3rMIhcd86l8yhbblCmtlZDaBDzBukDj-MBIOg&usqp=CAc",
      text: "Apple iPhone 17 Pro Max",
    },
    {
      id: 2,
      img: "https://via.placeholder.com/150",
      text: "Samsung Galaxy Ultra",
    },
    {
      id: 3,
      img: "https://via.placeholder.com/150",
      text: "Google Pixel 9",
    },
    {
      id: 4,
      img: "https://via.placeholder.com/150",
      text: "OnePlus 13",
    },
    {
      id: 5,
      img: "https://via.placeholder.com/150",
      text: "Xiaomi 14 Pro",
    },
  ];

  return (
    <div className="mycontainer">
      {cards.map((card) => (
        <div className="card" key={card.id}>
          <img src={card.img} className="card-img-top" alt={card.text} />
          <div className="card-body">
            <p className="card-text">{card.text}</p>
          </div>
        </div>
      ))}
    </div>
  );
}
