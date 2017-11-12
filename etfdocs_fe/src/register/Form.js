import React, { Component } from 'react';
import { PostData } from '../_services/PostData.js';

class Form extends Component {

    constructor () {
        super();
        this.state = {
            email: '',
            password: '',
            repPassword: ''
        }

        this.register = this.register.bind(this);
        this.onChange = this.onChange.bind(this);
    }

    register () {
        // E-mail regex 
        let emre = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if(emre.test(this.state.email)) {
             if(this.state.password == this.state.repPassword) {
                PostData('register', this.state).then((result) => {
                    let responseJson = result;
                    alert(result);
                });
             } else alert('Not the same password');
        } else alert('Invalid e-mail format.');
    }

    onChange(e) {
        this.setState({[e.target.name]:e.target.value});
    }

    render () {
        return (
            <section id="cover">
                <div className="container">
                    <div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
                        <div class="login-screen">
                            <img className="cover-logo" src={require('../img/cover-logo.png')} />
                        </div>
                        <form action="" method="post">
                            <div className="login-form">
                                <div className="form-group">
                                    <lable for="email">E-mail:</lable>
                                    <input type="email" className="form-control login-form__input" name="email" placeholder="E-mail" />
                                </div>
                                <div className="form-group">
                                    <lable for="password">Password:</lable>
                                    <input type="password" className="form-control login-form__input" name="password" placeholder="Password" />
                                </div>
                                <div className="form-group">
                                    <lable for="password">Repeat password:</lable>
                                    <input type="password" className="form-control login-form__input" name="repeat_password" placeholder="Password" />
                                </div>

                                <input className="cover-button login-button" name="register" value="Create account" />
                            </div>
                        </form>
                    </div>
                </div>
            </section>
        );
    }
};

export default Form;