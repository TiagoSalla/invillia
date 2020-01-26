import React, { Component } from 'react';
import axios from '../../utils/HttpClient';
import { Link } from 'react-router-dom';
import Field from '../../components/Field';

class NewAccount extends Component {
  state = {
    account: {
      personId: '',
      number: '',
      agency: '',
      accountType: '',
      specialLimit: '',
    },
    people: [],
    errors: {},
    globalError: '',
  };

  componentDidMount() {
    this.searchPeople();
  }

  searchPeople() {
    axios.get('/people').then(({ data }) => {
      this.setState({
        people: data,
      });
    });
  }

  change = event => {
    let field = event.target.name;
    let value = event.target.value;

    this.setState(({ account }) => ({
      account: {
        ...account,
        [field]: value,
      },
    }));
  };

  submit = event => {
    axios
      .post('/accounts', this.state.account)
      .then(() => this.props.history.push('/accounts'))
      .catch(({ response }) => {
        if (response.status === 400) {
          this.setState({
            errors: response.data,
          });
        }

        this.setState({
          globalError: response.data.message,
        });
      });

    event.preventDefault();
  };

  render() {
    const { account, errors, globalError } = this.state;
    return (
      <div>
        <h1>New Account</h1>

        {globalError ? (
          <div className="alert alert-danger">{globalError}</div>
        ) : (
          <></>
        )}

        <form onSubmit={this.submit}>
          <select name="personId" onChange={this.change}>
            <option defaultChecked value="null">
              Select a person
            </option>
            {this.state.people.map(person => (
              <option key={person.id} value={person.id}>
                {person.name}
              </option>
            ))}
          </select>

          <Field
            name="number"
            label="Account Number"
            value={account.number}
            errors={errors['number']}
            onChange={this.change}
          />

          <Field
            name="agency"
            label="Agency"
            value={account.agency}
            errors={errors['agency']}
            onChange={this.change}
          />

          <select name="accountType" onChange={this.change}>
            <option defaultChecked>Select an account type</option>
            <option value="CHECKING">Checking Account</option>
            <option value="SAVING">Saving Account</option>
          </select>

          <Field
            name="specialLimit"
            label="Special Limit"
            value={account.specialLimit}
            errors={errors['specialLimit']}
            onChange={this.change}
          />

          <div>
            <Link to="/accounts">Go Back</Link>
            <button type="submit">Save</button>
          </div>
        </form>
      </div>
    );
  }
}

export default NewAccount;
