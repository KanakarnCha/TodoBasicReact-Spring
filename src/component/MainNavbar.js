import React from 'react'
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';

function MainNavbar() {
  return (
    <>
        <Navbar bg="dark" variant="dark">
            <Container>
            <Navbar.Brand href="#home">
                Todo List App
            </Navbar.Brand>
            </Container>
        </Navbar>
      </>
  )
}

export default MainNavbar