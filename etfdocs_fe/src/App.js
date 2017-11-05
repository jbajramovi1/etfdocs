import React from 'react';
import './App.css';

import Cover from './Cover';
import Menu from './Menu';
import About from './About';
import Footer from './Footer';

const App = () => {
  return (
    <div className="etfdocs">
      <Menu />
      <Cover />
      <About />
      <Footer />
    </div>
  );
};

export default App;