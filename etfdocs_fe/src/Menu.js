import React from 'react';

const Menu = () => {
    return (
        <nav id="mainNav" className="navbar">
            <div className="container-fluid">
                <div className="navbar-header">
                    <a className="navbar-brand mainNav-heading" href="#">ETF<blue>Docs</blue></a>
                </div>
                <ul className="nav navbar-nav navbar-right mainNav-links">
                    <li><a href="#">About</a></li>
                    <li><a href="#">Sign in</a></li>
                    <li><a href="#">Register</a></li>
                </ul>
            </div>
        </nav>
    );
}

export default Menu;