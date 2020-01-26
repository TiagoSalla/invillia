import React from 'react';

export default function Select() {
  return (
    <select name="select">
      <option value="valor1">Valor 1</option>
      <option value="valor2" selected>
        Valor 2
      </option>
      <option value="valor3">Valor 3</option>
    </select>
  );
}
