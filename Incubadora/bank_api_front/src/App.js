import React from 'react';
import { BrowserRouter } from 'react-router-dom';

import 'bootstrap/dist/css/bootstrap.min.css';

import Routes from './routes';
import SideBar from './components/SideBar';

function App() {
  return (
    <BrowserRouter>
      <SideBar />
      <Routes />
    </BrowserRouter>
  );
}

export default App;
