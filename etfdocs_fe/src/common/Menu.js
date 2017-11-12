import React, { Component } from 'react';

class Menu extends Component {
    render () {
        return (
            <nav id="mainNav" className="navbar">
                <div className="container-fluid">
                    <div className="navbar-header">
                        <a className="navbar-brand mainNav-heading" href="/">ETF<blue>Docs</blue></a>
                    </div>
                    <ul className="nav navbar-nav navbar-right mainNav-links">
                        <li><a href="/login">Sign in</a></li>
                        <li><a href="/register">Register</a></li>
                    </ul>
                </div>
            </nav>
        );
    }
}

export default Menu;