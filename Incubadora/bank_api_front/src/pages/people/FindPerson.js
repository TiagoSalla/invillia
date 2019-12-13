import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from '../../utils/HttpClient';

class FindPerson extends Component {
    state = {
        person: {
            id: "",
            name: "",
            cpf: "",
            rg: ""
        }
    };

    componentDidMount() {
        axios.get(`/people/${this.searchPersonId()}`)
            .then(({ data }) => {
                this.setState({
                    person: data
                })
            }).catch(({ response }) => {
                if (response.status === 404) {
                    this.props.history.push("/not-found")
                }
            })
    }

    searchPersonId = () => this.props.match.params.id;

    handleDelete = (id) => {
        axios.delete(`/people/${id}`)
            .then(() => this.searchPersonId());
    }

    render() {
        const { person } = this.state;
        console.log(person);
        return <div>
            <h1>Find Person</h1>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>CPF</th>
                        <th>RG</th>
                        <th>Updated At</th>
                        <th>Created At</th>
                        <th>Actions</th>
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
                        <td>
                            <button onClick={() => this.handleDelete(person.id)}>Delete</button>
                            <Link to={`people/edit/${person.id}`}>Edit</Link>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    }
}

export default FindPerson;