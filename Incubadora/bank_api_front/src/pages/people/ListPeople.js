import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from '../../utils/HttpClient';

class ListPeople extends Component {
    state = {
        people: []
    }

    componentDidMount(){
        this.searchPeople();
    }

    searchPeople() {
        axios.get("/people")
            .then(({ data }) => {
                console.log(data);
                this.setState({
                    people: data
                })
            })
    }

    handleDelete = (id) => {
        axios.delete(`/people/${id}`)
            .then(() => this.searchPeople());
    }

    render() {
        return (
            <div>
                <h1>People List</h1>

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
                        {this.state.people.map(person =>
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
                            </tr>)}
                    </tbody>
                </table>

                <div>
                    <Link to="/people/new">New Person</Link>
                </div>
            </div>
        );
    }
}

export default ListPeople;