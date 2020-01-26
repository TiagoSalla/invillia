import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from '../../utils/HttpClient';

class ListAccounts extends Component {
  state = {
    accounts: [],
  };

  componentDidMount() {
    this.searchAccounts();
  }

  searchAccounts() {
    axios.get('/accounts').then(({ data }) => {
      this.setState({
        accounts: data,
      });
    });
  }

  handleDelete = id => {
    axios.delete(`/accounts/${id}`).then(() => this.searchAccounts());
  };

  render() {
    return (
      <div>
        <h1>Accounts List</h1>

        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Account number</th>
              <th>Agency</th>
              <th>Account Type</th>
              <th>Customer</th>
              <th>Balance</th>
              <th>Special Limit</th>
              <th>Updated At</th>
              <th>Created At</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {this.state.accounts.map(account => (
              <tr key={account.id}>
                <td>{account.id}</td>
                <td>{account.number}</td>
                <td>{account.agency}</td>
                <td>
                  {account.accountType === 'SAVING'
                    ? 'Saving Account'
                    : 'Checking Account'}
                </td>
                <td>
                  <Link to={`/people/${account.personId}`}>
                    {account.personName}
                  </Link>
                </td>
                <td>{account.balance}</td>
                <td>{account.specialLimit}</td>
                <td>{account.updatedAt}</td>
                <td>{account.createdAt}</td>
                <td>
                  <button onClick={() => this.handleDelete(account.id)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>

        <div>
          <Link to="/accounts/new">New Account</Link>
        </div>
      </div>
    );
  }
}

export default ListAccounts;
