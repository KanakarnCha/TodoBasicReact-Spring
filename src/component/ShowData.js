import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Card } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Stack from 'react-bootstrap/Stack';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
function ShowData() {

    const [dataShow, setData] = useState([])
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const [newTitle, setNewTitle] = useState("")
    const [newContent, setNewContent] = useState("")
    const [id, setId] = useState(0)
    useEffect(() => {
        fetch("http://localhost:8080/todo/data")
            .then(res => res.json())
            .then((result) => {
                setData(result);
            }
            )
    }, [])
    const deleteHandle = (e) => {
        axios.delete("http://localhost:8080/todo/delete", { params: { id: e.target.value } })
        window.location.reload()
    }

    const updateHandle = (e) => {
        setShow(true)
        setId(e.target.value)


    }
    const updateNow = () => {
        const newData = {
            title: newTitle,
            content: newContent
        }
        axios.put(`http://localhost:8080/todo/update/${id}`,newData);
        setShow(false);
        window.location.reload()


    }
    return (
        <>
            {dataShow.map(data => (
                <Card key={data.id}>
                    <Card.Header as="h5">{data.title}</Card.Header>
                    <Card.Body>
                        <Card.Text>
                            {data.content}
                        </Card.Text>
                        <Stack direction="horizontal" gap={3} >
                            <Button variant="danger" onClick={deleteHandle} value={data.id}>Delete</Button>
                            <Button variant="warning" onClick={updateHandle} value={data.id}>Update</Button>
                        </Stack>
                    </Card.Body>
                    <Card.Footer className="text-muted ">{data.updatedAt}</Card.Footer>
                </Card>
            ))}

            <>
                <Modal show={show} onHide={handleClose}>
                    <Modal.Header closeButton>
                        <Modal.Title>{ }</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <Form>
                            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                                <Form.Label>Email address</Form.Label>
                                <Form.Control
                                    type="Title"
                                    autoFocus
                                    onChange={e => { setNewTitle(e.target.value) }}
                                />
                            </Form.Group>
                            <Form.Group
                                className="mb-3"
                                controlId="exampleForm.ControlTextarea1"
                            >
                                <Form.Label>Example textarea</Form.Label>
                                <Form.Control as="textarea" rows={3} onChange={e => { setNewContent(e.target.value) }} />
                            </Form.Group>
                        </Form>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button variant="secondary" onClick={handleClose}>
                            Close
                        </Button>
                        <Button variant="primary" onClick={updateNow}>
                            Save Changes
                        </Button>
                    </Modal.Footer>
                </Modal>
            </>
        </>
    )
}

export default ShowData