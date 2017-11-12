import React, { Component } from 'react';
import { mustAuthenticate } from './_services/Sessions';

import './App.css';

import Footer from './common/Footer';

class Dashboard extends Component {
  constructor() {
    super();
  }

  componentWillMount() {
      mustAuthenticate();
  }

  render () {
    return (
      <div>
        <h1>Dashboard</h1>
        <Footer />
      </div>
    );
  }
};

export default Dashboard;