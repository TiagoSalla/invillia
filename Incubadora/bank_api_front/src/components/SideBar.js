import React from 'react';
import { RouterLink, NavRouterLink } from './styles';

import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';

export default function SideBar() {
  return (
    <Navbar bg="dark" variant="dark">
      <Navbar.Brand>
        <RouterLink to="/">
          <img
            alt=""
            src="/logo.png"
            width="30"
            height="30"
            className="d-inline-block align-top"
          />{' '}
          Salla Bank
        </RouterLink>
      </Navbar.Brand>
      <Nav className="mr-auto">
        <Nav.Link>
          <NavRouterLink to="/people">Pessoas</NavRouterLink>
        </Nav.Link>
        <Nav.Link>
          <NavRouterLink to="/accounts">Contas</NavRouterLink>
        </Nav.Link>
        <Nav.Link>
          <NavRouterLink to="/accounts/operations">Operações</NavRouterLink>
        </Nav.Link>
      </Nav>
    </Navbar>
  );
}
