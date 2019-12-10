import React from 'react';

function Field(props) {
    return (
        <div>
            <label htmlFor={props.name}>{props.label}</label>
            <input type="text" name={props.name} value={props.value} onChange={props.onChange} />
            <span>{props.errors}</span>
        </div>
    );
}

export default Field;