import React from 'react'
import './Pro.css'

export default function Pro(props) {
  return (
    <div>

        <h3>{props.name}</h3>
        <h4>${props.Price}</h4>
        <h6>{props.Discription}</h6>
      
    </div>
  )
}
