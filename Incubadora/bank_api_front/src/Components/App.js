import React from 'react';

import ListPeople from "../pages/people/ListPeople"
import NewPerson from "../pages/people/NewPerson"
import EditPerson from "../pages/people/EditPerson"
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
          <Route path="*" component={NotFound}/>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
