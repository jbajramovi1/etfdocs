import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route, Link } from 'react-router-dom';

import './index.css';

/* Main components */
import Menu from './common/Menu';
import App from './App';
import Login from './Login';
import Register from './Register';

/* Render + router */
ReactDOM.render (
    <BrowserRouter>
        <div className="etfdocs">
            <Menu />
            <Route exact path="/" component={App}/>
            <Route path="/login" component={Login}/>
            <Route path="/register" component={Register}/>
        </div>
    </BrowserRouter>, 
    document.getElementById('root')
);
