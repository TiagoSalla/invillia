import React from 'react';
import { Route, Switch } from 'react-router-dom';

import ListPeople from './pages/People/ListPeople';
import NewPerson from './pages/People/NewPerson';
import EditPerson from './pages/People/EditPerson';
import FindPerson from './pages/People/FindPerson';

import ListAccounts from './pages/Accounts/ListAccounts';
import NewAccount from './pages/Accounts/NewAccount';
import Operations from './pages/Accounts/Operations';

import NotFound from './pages/NotFound';
import Menu from './pages/Home/index.js';

export default function Routes() {
  return (
    <Switch>
      <Route path="/" exact component={Menu} />

      <Route path="/people" exact component={ListPeople} />
      <Route path="/people/new" exact component={NewPerson} />
      <Route path="/people/edit/:id" exact component={EditPerson} />
      <Route path="/people/:id" exact component={FindPerson} />

      <Route path="/accounts" exact component={ListAccounts} />
      <Route path="/accounts/new" exact component={NewAccount} />
      <Route path="/accounts/operations" exact component={Operations} />

      <Route path="*" component={NotFound} />
    </Switch>
  );
}
