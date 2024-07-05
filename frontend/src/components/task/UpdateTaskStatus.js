import { Link, useNavigate, useParams } from 'react-router-dom';
import '../../App.css';
import axios from 'axios';
import { useEffect, useState } from 'react';

const UpdateTaskStatus = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [updateStatus, setUpdateStatus] = useState('');

    const updateTask = async () => {
        try {
            await axios.put(`http://localhost:8080/api/v1/tasks/update/${id}`, {
                status: updateStatus,
            });
            navigate("/dashboard");
        } catch (e) {
            console.log(e);
        }
    };

    const loadTask = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/api/v1/tasks/get-by-id/${id}`);
            const taskData = response.data.data;
            console.log(response.data.data);
            setUpdateStatus(taskData.status);
        } catch (error) {
            console.error('Error fetching Task:', error);
        }
    };

    useEffect(() => {
        loadTask();
    }, []);

    return (
        <>
            <br />
            <div>
                <div className='container'>
                    <div className="row ">
                        <div className="card col-md-5 offset-md-3"><br />
                            <h2 className="text-center colour">Update Task Status</h2>
                            <div className="card-body back">
                                <form>
                                    <div className='form-group'>
                                        <label htmlFor="taskDescription">Status </label>
                                        <input
                                            className="form-control"
                                            id="taskDescription"
                                            onChange={(e) => setUpdateStatus(e.target.value)}
                                            type="text"
                                            value={updateStatus}
                                        />
                                    </div><br />
                                    <button
                                        className="btn btn-success  button-space"
                                        type="button"
                                        onClick={updateTask}
                                    >
                                        Update Status
                                    </button>
                                    <Link className="btn btn-danger" type="button" to={'/dashboard'}>Cancel</Link>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default UpdateTaskStatus;
