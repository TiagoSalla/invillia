import React, { useState, useEffect } from 'react';
import axios from '../../utils/HttpClient';

import { Button, Table } from 'react-bootstrap/';
import BootstrapContainer from 'react-bootstrap/Container';
import { RouterLink, Container } from '../../components/styles';

export default function ListPeople() {
  const [people, setPeople] = useState([]);

  async function retrievePeople() {
    axios.get('/people').then(({ data }) => setPeople(data));
  }

  const handleDelete = id => {
    axios.delete(`/people/${id}`).then(() => retrievePeople());
  };

  useEffect(() => {
    retrievePeople();
  }, []);

  return (
    <BootstrapContainer>
      <Container>
        <h1>Lista de Pessoas</h1>
        <Button style={{ marginLeft: 30 }} variant="success">
          <RouterLink to="/people/new">Adicionar Pessoa</RouterLink>
        </Button>
      </Container>
      <Table responsive variant="dark">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>RG</th>
            <th>Atualizado em</th>
            <th>Criado em</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {people.map(person => (
            <tr key={person.id}>
              <td>{person.id}</td>
              <td>{person.name}</td>
              <td>{person.cpf}</td>
              <td>{person.rg}</td>
              <td>{person.updatedAt}</td>
              <td>{person.createdAt}</td>
              <td>
                <Button variant="warning">
                  <RouterLink to={`people/edit/${person.id}`}>
                    Editar
                  </RouterLink>
                </Button>{' '}
                <Button
                  variant="danger"
                  onClick={() => handleDelete(person.id)}
                >
                  Excluir
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </BootstrapContainer>
  );
}
