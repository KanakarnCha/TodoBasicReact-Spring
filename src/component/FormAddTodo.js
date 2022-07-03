import React, { useState } from 'react'
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import "../style/Form.css"
import axios from 'axios';
function FormAddTodo() {
    const [title, setTitle] = useState("")
    const [content, setContent] = useState("")
    const [AddData, setAddData] = useState({})
    function inputTitle(event) {
        setTitle(event.target.value)
    }
    function inputContent(event) {
        setContent(event.target.value)
    }

    const handleClick = () => {
        const data = {
            title: title,
            content: content
        }
        axios.post("http://localhost:8080/todo/add",data).then(function(response){
            console.log(response);
        })
        window.location.reload()
    }

  
    return (
        <Card className="text-center">
            <Card.Header>ToDo ADD</Card.Header>
            <Card.Body>
                <Card.Title></Card.Title>
                <Card.Text>
                    <Form>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Title</Form.Label>
                            <Form.Control type="text" onChange={inputTitle} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                            <Form.Label>Content</Form.Label>
                            <Form.Control as="textarea" rows={3} onChange={inputContent} />
                        </Form.Group>
                    </Form>
                </Card.Text>
                <Button variant="primary" onClick={handleClick}>Submit</Button>
            </Card.Body>
            <Card.Footer className="text-muted">Happy</Card.Footer>
        </Card>

    )
}

export default FormAddTodo