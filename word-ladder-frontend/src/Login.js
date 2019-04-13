import React, { Component } from 'react';
import './Login.css'

class Login extends Component {

    handleSubmit = (e) => {
        e.preventDefault()
        let username = this.input1.value
        let password = this.input2.value
        console.log(username)
        console.log(password)
        let path = 'http://localhost:8080/login';
        console.log(path)
        fetch(
          path, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'withCredentials': 'ture'
            },
            method:'POST',
            body: {'username': username, "password": password},
            mode:'no-cors'
          }).then((response) => {
              console.log(response);
            // response.json().then((data) => {
            //   console.log(data);
            //   this.setState(() => ({
            //     wordladder: data['wordladder'],
            //   }))
            // });
          })
          .catch(e => console.log('错误:', e)
          )
        }

    render() {
        return (
            <div>
                <nav className="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
                    <div className="container">
                        <a className="navbar-brand js-scroll-trigger" href="#page-top">Start Activities</a>
                        <button className="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                            Menu
                            <i className="fas fa-bars"></i>
                        </button>
                        <div className="collapse navbar-collapse" id="navbarResponsive">
                            <ul className="navbar-nav ml-auto">
                                <li className="nav-item">
                                    <a className="nav-link js-scroll-trigger" href="#about">About</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link js-scroll-trigger" href="#projects">Projects</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link js-scroll-trigger" href="#signup">Contact</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <header className="masthead">
                    <div className="container d-flex h-100 align-items-center">
                        <div className="mx-auto text-center">
                            <h1 className="mx-auto my-0 text-uppercase">Login</h1>
                            <h2 className="text-white-50 mx-auto mt-2 mb-5">Please Login in!</h2>
                            <form className="form d-flex">
                                <input type="text" className="form-control flex-fill mr-0 mr-sm-2 mb-3 mb-sm-0 login" id="username" ref={input1 => this.input1 = input1} placeholder="username"/>
                                <input type="text" className="form-control flex-fill mr-0 mr-sm-2 mb-3 mb-sm-0 login" id="password" ref={input2 => this.input2 = input2} placeholder="password"/>
                                <button  className="btn btn-primary mx-auto login" onClick={this.handleSubmit.bind(this)}>Login</button>
                            </form>
                        </div>
                    </div>
                </header>
            </div>
        )
    }


}

export default Login