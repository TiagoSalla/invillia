import React from 'react';

export default function Field(props) {
  const { name, label, value, onChange, errors } = props;
  return (
    <div>
      <label htmlFor={name}>{label}</label>
      <input type="text" name={name} value={value} onChange={onChange} />
      <span>{errors}</span>
    </div>
  );
}
