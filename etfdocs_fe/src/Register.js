import React, { Component } from 'react';
import './App.css';

import Menu from './common/Menu';
import Footer from './common/Footer';

import Form from './register/Form';

class Register extends Component {
  render () {
    return (
      <div>
        <Form />
        <Footer />
      </div>
    );
  }
};

export default Register;