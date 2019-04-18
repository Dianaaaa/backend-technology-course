import React, { Component } from 'react';
import { Route } from 'react-router-dom'
// import logo from './logo.svg';
// import './App.css';
import Wordladder from './Wordladder'
import Login from './Login'



class App extends Component {
  state = {
    contacts: []
  }

  render() {
    return (
      <div className='app'>
          <div>
            <Route exact path='/word-ladder' render={() => (
              <Wordladder/>
            )}/>
          </div>
            
          <div>
            <Route exact path='/' render={() => (
              <Login/>
            )}/>
          </div>
      </div>
    );
  }
}

export default App;