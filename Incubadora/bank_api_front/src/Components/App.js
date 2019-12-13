import React from 'react';

import ListPeople from "../pages/people/ListPeople"
import NewPerson from "../pages/people/NewPerson"
import EditPerson from "../pages/people/EditPerson"
import FindPerson from "../pages/people/FindPerson"

import ListAccounts from "../pages/accounts/ListAccounts"
import NewAccount from "../pages/accounts/NewAccount"
import Operations from "../pages/accounts/Operations"

import NotFound from "../pages/NotFound"
import Menu from "../pages/Menu"

import { BrowserRouter, Route, Switch } from 'react-router-dom'

function App() {
  return (
    <div>
      <BrowserRouter>
        <Switch>
          <Route path={"/"} exact component={Menu}/>

          <Route path={"/people"} exact component={ListPeople}/>
          <Route path={"/people/new"} exact component={NewPerson}/>
          <Route path={"/people/edit/:id"} exact component={EditPerson}/>
          <Route path={"/people/:id"} exact component={FindPerson}/>

          <Route path={"/accounts"} exact component={ListAccounts}/>
          <Route path={"/accounts/new"} exact component={NewAccount}/>
          <Route path={"/accounts/operations"} exact component={Operations}/>
          
          <Route path="*" component={NotFound}/>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
