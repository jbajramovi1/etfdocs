import React, { Component } from 'react';
import './App.css';

import Menu from './common/Menu';
import Footer from './common/Footer';

import Form from './login/Form';

class Login extends Component {
    render () {
        return (
        <div>
            <Form />
            <Footer />
        </div>
        );
    }
};

export default Login;