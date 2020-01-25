import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from '../../utils/HttpClient';

import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import Table from 'react-bootstrap/Table';

class ListPeople extends Component {
  state = {
    people: [],
  };

  componentDidMount() {
    this.searchPeople();
  }

  searchPeople() {
    axios.get('/people').then(({ data }) => {
      console.log(data);
      this.setState({
        people: data,
      });
    });
  }

  handleDelete = id => {
    axios.delete(`/people/${id}`).then(() => this.searchPeople());
  };

  render() {
    return (
      <Container>
        <h1>Lista de Pessoas</h1>

        <Table responsive>
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
            {this.state.people.map(person => (
              <tr key={person.id}>
                <td>{person.id}</td>
                <td>{person.name}</td>
                <td>{person.cpf}</td>
                <td>{person.rg}</td>
                <td>{person.updatedAt}</td>
                <td>{person.createdAt}</td>
                <td>
                  <button onClick={() => this.handleDelete(person.id)}>
                    Excluir
                  </button>
                  <Link to={`people/edit/${person.id}`}>Editar</Link>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>

        <Button>
          <Link to="/people/new">Adicionar Pessoa</Link>
        </Button>
      </Container>
    );
  }
}

export default ListPeople;
