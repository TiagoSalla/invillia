import React, { useEffect, useState } from 'react';
import axios from '../../utils/HttpClient';

import { Button, Table } from 'react-bootstrap/';
import BootstrapContainer from 'react-bootstrap/Container';
import { RouterLink, Container } from '../../components/styles';

export default function FindPerson(props) {
  const [person, setPerson] = useState({});
  const paramId = props.match.params.id;

  useEffect(() => {
    axios.get(`/people/${paramId}`).then(({ data }) => setPerson(data));
  }, [paramId]);

  return (
    <BootstrapContainer>
      <Container>
        <h1>Pessoa Encontrada!</h1>
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
          </tr>
        </thead>
        <tbody>
          <tr key={person.id}>
            <td>{person.id}</td>
            <td>{person.name}</td>
            <td>{person.cpf}</td>
            <td>{person.rg}</td>
            <td>{person.updatedAt}</td>
            <td>{person.createdAt}</td>
          </tr>
        </tbody>
      </Table>
      <Button variant="success">
        <RouterLink to="/accounts">Voltar</RouterLink>
      </Button>
    </BootstrapContainer>
  );
}
