import React, { Component } from 'react';

import { Link } from 'react-router-dom';

import axios from '../../utils/HttpClient';

import Field from '../../components/Field';

class EditPerson extends Component {
  state = {
    person: {
      name: '',
      cpf: '',
      rg: '',
    },
    errors: {},
  };

  componentDidMount() {
    axios
      .get(`/people/${this.searchPersonId()}`)
      .then(({ data }) => {
        this.setState({
          person: data,
        });
      })
      .catch(({ response }) => {
        if (response.status === 404) {
          this.props.history.push('/not-found');
        }
      });
  }

  searchPersonId = () => this.props.match.params.id;

  change = event => {
    let field = event.target.name;
    let value = event.target.value;

    this.setState(({ person }) => ({
      person: {
        ...person,
        [field]: value,
      },
    }));
  };

  submit = event => {
    axios
      .put(`/people/${this.searchPersonId()}`, this.state.person)
      .then(() => this.props.history.push('/people'))
      .catch(({ response }) => {
        if (response.status === 400) {
          this.setState({
            errors: response.data,
          });
        }
      });

    event.preventDefault();
  };

  render() {
    const { person, errors } = this.state;
    return (
      <div>
        <h1>New Person</h1>

        <form onSubmit={this.submit}>
          <Field
            name="name"
            label="Name"
            value={person.name}
            errors={errors['name']}
            onChange={this.change}
          />

          <Field
            name="cpf"
            label="CPF"
            value={person.cpf}
            errors={errors['cpf']}
            onChange={this.change}
          />

          <Field
            name="rg"
            label="RG"
            value={person.rg}
            errors={errors['rg']}
            onChange={this.change}
          />

          <div>
            <Link to="/people">Voltar</Link>
            <button type="submit">Salvar</button>
          </div>
        </form>
      </div>
    );
  }
}

export default EditPerson;
