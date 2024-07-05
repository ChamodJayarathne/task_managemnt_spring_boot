import { useState } from 'react';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import { Link, useNavigate } from 'react-router-dom';
import '../../App.css';
import axios from 'axios';

const AssignTask = () => {
    const navigate = useNavigate();

    const [startDate, setStartDate] = useState(new Date());
    const [endDate, setEndDate] = useState(new Date());
    const [name, setName] = useState("");
    const [employee, setEmployee] = useState("");
    const [status, setStatus] = useState("");

    const saveTask = async () => {
        const response = await axios.post("http://localhost:8080/api/v1/tasks/save", {
            name, employee, startDate, endDate, status
        });
        console.log(response);

        setName('');
        setEmployee('');
        setStartDate(new Date());
        setEndDate(new Date());
        setStatus("");

        navigate("/dashboard");
    }

    return (
        <>
            <br />
            <div>
                <div className='container'>
                    <div className="row ">
                        <div className="card col-md-5 offset-md-3"><br />
                            <h3 className="text-center colour">Assign Task To Team member</h3>
                            <div className="card-body">
                                <form>
                                    <div className='form-group'>
                                        <label htmlFor="taskName">Task Name </label>
                                        <input className="form-control" id='taskName' onChange={(e) => { setName(e.target.value) }} value={name} type='text' required />
                                    </div><br />

                                    <div className='form-group'>
                                        <label htmlFor="employee">Assign Task To Team member </label>
                                        <input className="form-control" id='employee' onChange={(e) => { setEmployee(e.target.value) }} value={employee} type='text' required />
                                    </div><br />

                                    <div className='form-group'>
                                        <label htmlFor="employeeEmail">Task Created Date </label><br />
                                        <DatePicker selected={startDate} onChange={(date) => setStartDate(date)} />
                                    </div><br />

                                    <div className='form-group'>
                                        <label htmlFor="employeeContactNumber">Task Deadline Date </label><br />
                                        <DatePicker selected={endDate} onChange={(date) => setEndDate(date)} />
                                    </div><br />

                                    <div className='form-group'>
                                        <label htmlFor="status">Status </label>
                                        <input className="form-control" id='status' type='text' onChange={(e) => { setStatus(e.target.value) }} value={status} required />
                                    </div><br />

                                    <button className="btn btn-warning button-space" onClick={() => saveTask()} type="button">Complete </button>
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

export default AssignTask;
