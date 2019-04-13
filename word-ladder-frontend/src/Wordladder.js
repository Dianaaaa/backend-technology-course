import React, { Component } from 'react';
import './assets/css/grayscale.min.css';




class Wordladder extends Component {
  state = {
    wordladder: "Xingyue Qian"
  }

  handleSubmit = (e) => {
    e.preventDefault()
    let word1 = this.input1.value
    let word2 = this.input2.value
    console.log(word1)
    console.log(word2)
    let path = 'http://localhost:8080/word-ladder?word1=' + word1 + '&word2=' + word2;
    console.log(path)
    fetch(
      path, {
        method:'GET',
        // body: {'name': "机器学习"},
        mode:'no-cors'
      }).then((response) => {
        response.json().then((data) => {
          console.log(data);
          this.setState(() => ({
            wordladder: data['wordladder'],
          }))
        });
      })
      .catch(e => console.log('错误:', e)
      )
    }

  render() {
      const { wordladder } = this.state
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
                    <h1 className="mx-auto my-0 text-uppercase">Wordladder</h1>
                    <h2 className="text-white-50 mx-auto mt-2 mb-5">A word ladder generator. Have fun.</h2>
                    <form className="form-inline d-flex">
                        <input type="text" className="form-control flex-fill mr-0 mr-sm-2 mb-3 mb-sm-0" id="word1" ref={input1 => this.input1 = input1} placeholder="Enter word1"/>
                        <input type="text" className="form-control flex-fill mr-0 mr-sm-2 mb-3 mb-sm-0" id="word2" ref={input2 => this.input2 = input2} placeholder="Enter word2"/>
                        <button  className="btn btn-primary mx-auto" onClick={this.handleSubmit.bind(this)}>Subscribe</button>
                    </form>
                    <div className="mx-auto text_center">
                        <div className="card py-4 h-100">
                            <div className="card-body text-center">
                                <p className="text-uppercase m-0">Result</p>
                                <hr className="my-4"/>
                                <p className="text-black-50" id="result"><span>{wordladder}</span></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        
      </div>
      
    );
  }
}

export default Wordladder;