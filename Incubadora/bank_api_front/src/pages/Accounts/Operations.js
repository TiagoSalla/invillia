import React, { Component } from 'react';
import axios from '../../utils/HttpClient';
import { Link } from 'react-router-dom';
import Field from '../../Components/Field';

class Operations extends Component {
    state = {
        operation: {
            option: "",
            value: ""
        },
        accountId: "",
        accounts: [],
        people: [],
        errors: {},
        globalError: ""
    }

    componentDidMount() {
        axios.get(`/people`)
            .then(({ data }) => {
                this.setState({
                    people: data
                })
            }).catch(({ response }) => {
                if (response.status === 404) {
                    this.props.history.push("/not-found")
                }
            })
    }

    handleOperationChange = (event) => {
        document.getElementById("selectPerson").disabled = false;

        let field = event.target.name;
        let value = event.target.value;

        this.setState(({ operation }) => ({
            operation: {
                ...operation,
                [field]: value
            }
        }))

        console.log(this.state.operation);
    };

    handleAccountChange = (event) => {
        let field = event.target.name;
        let value = event.target.value;

        this.setState(({ accountId }) => ({
            accountId: {
                ...accountId,
                [field]: value
            }
        }))

        console.log(this.state.accountId);
    }

    handleFilterAccounts = (event) => {
        let value = event.target.value;

        if (value === "null") {
            document.getElementById("selectAccount").disabled = true;
        } else {
            document.getElementById("selectAccount").disabled = false;

            axios.get(`/accounts/person/${value}`)
                .then(({ data }) => {
                    this.setState({
                        accounts: data
                    })
                    console.log(this.state)
                }).catch(({ response }) => {
                    if (response.status === 404) {
                        this.props.history.push("/not-found")
                    }
                })
        }

    };

    retrieveParamId = () => this.props.match.params.id;
    
    retrieveParamOption = () => this.props.match.params.option;

    handleSubmit = (event) => {
        const enviar = {value: this.state.operation.value}; //arrumar aqui depois

        axios.put(`/accounts/${this.state.accountId.id}/${this.state.operation.option}`, enviar)
            .then(() => this.props.history.push("/accounts"))
            .catch(({ response }) => {
                if (response.status === 400) {
                    this.setState({
                        errors: response.data
                    })
                }
            });

        event.preventDefault();
    };

    render() {
        const { operation, errors, accounts, people } = this.state;
        const { handleOperationChange, handleFilterAccounts, handleAccountChange } = this;
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <input type="radio" id="withdraw" name="option" value="withdraws" onClick={handleOperationChange} /><label htmlFor="withdraw">Withdraw</label>
                    <input type="radio" id="deposit" name="option" value="deposits" onClick={handleOperationChange} /><label htmlFor="deposit">Deposit</label>

                    <select id="selectPerson" name="id" onChange={handleFilterAccounts} disabled>
                        <option defaultChecked value="null">Select a person</option>
                        {people.map(person => <option key={person.id} value={person.id}>{person.name} - {person.cpf}</option>)}
                    </select>

                    <select id="selectAccount" name="id" onChange={handleAccountChange} disabled>
                        <option defaultChecked value="null">Select an account</option>
                        {accounts.map(account => <option key={account.id} value={account.id}>
                            Agency: {account.agency} / Account number: {account.number} / Account Type: {account.accountType === "SAVING" ? "Saving Account" : "Checking Account"}</option>)}
                    </select>

                    <Field name="value" label="Value" onChange={handleOperationChange} value={operation.value} errors={errors["value"]} />

                    <div>
                        <Link to="/accounts">Go Back</Link>
                        <button type="submit">Effect Transaction</button>
                    </div>
                </form>
            </div>
        );
    }
}

export default Operations;