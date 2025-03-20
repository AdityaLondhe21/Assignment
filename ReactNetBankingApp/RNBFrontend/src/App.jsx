import { useState } from 'react';
import './App.css';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import { Provider } from 'react-redux';
import store from './reduxContainer/store';

import Layout from './pages/Layout'; // Corrected import
import HomePage from './pages/HomePage';
import AboutPage from './pages/AboutPage';
import ServicesPage from './pages/ServicesPage';
import NetBankingPage from './pages/NetBankingPage';
import ContactPage from './pages/ContactPage';
import ProfilePage from './pages/ProfilePage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import WelcomePage from './pages/WelcomePage';
import BalancePage from './pages/BalancePage';
import StatementPage from './pages/StatementPage';
import TransferPage from './pages/TransferPage';

function App() {
  return (
    <>
      <Provider store={store}>
        <Router>
          <Routes>
            <Route path="/" element={<Layout />}>
              <Route index element={<HomePage />} />
              <Route path="about" element={<AboutPage />} />
              <Route path="services" element={<ServicesPage />} />
              <Route path="netbanking" element={<NetBankingPage />} />
              <Route path="contact" element={<ContactPage />} />
              <Route path="profile" element={<ProfilePage />} />
              <Route path="login" element={<LoginPage />} />
              <Route path="register" element={<RegisterPage />} />
              <Route path="welcome" element={<WelcomePage />} />
              <Route path="balance" element={<BalancePage />} />
              <Route path="statement" element={<StatementPage />} />
              <Route path="transfer" element={<TransferPage />} />
            </Route>
          </Routes>
        </Router>
      </Provider>
    </>
  );
}

export default App;