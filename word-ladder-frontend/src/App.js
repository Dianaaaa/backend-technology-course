import React, { Component } from 'react';
import { Route } from 'react-router-dom'
// import logo from './logo.svg';
// import './App.css';
import Wordladder from './Wordladder'



class App extends Component {
  state = {
    contacts: []
  }

  render() {
    return (
      
      <div>
        <Route exact path='/word-ladder' render={() => (
          <Wordladder/>
        )}/>
      </div>
      
    );
  }
}

export default App;