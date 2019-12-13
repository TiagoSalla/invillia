import React from 'react';

import { Link } from 'react-router-dom';

function Menu() {
    return (
        <div>
            <Link to={"/people"}>People</Link>
            <br />
            <Link to={"/accounts"}>Accounts</Link>
        </div>
    );
}

export default Menu;