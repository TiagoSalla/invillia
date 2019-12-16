import React from 'react';

import { Link } from 'react-router-dom';

function Menu() {
    return (
        <div className="card text-center">
            <div className="card-header">
                Home
            </div>
            <div className="card-body">
                <h1 className="card-title">Choose an option</h1>
                <Link className="btn btn-primary" to={"/people"}>People</Link>&nbsp;
                <Link className="btn btn-primary" to={"/accounts"}>Accounts</Link>
            </div>
        </div>
    );
}

export default Menu;