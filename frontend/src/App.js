import {BrowserRouter as Router,Routes,Route} from 'react-router-dom';
import './App.css'
import Home from "./components/home/Home";
import Dashboard from './components/task/Dashboard';
import UpdateTaskStatus from './components/task/UpdateTaskStatus';
import Login from './components/Login';
import Signup from './components/Signup';
import AssignTask from './components/task/AssignTask';

const App = () => {
  return (
    <>
    <Router>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/login' element={<Login/>}></Route>
        <Route path='/signup' element={<Signup/>}></Route>
        <Route path='/dashboard' element={<Dashboard/>}></Route>
        <Route path='/assignTask' element={<AssignTask/>}></Route>
        <Route path='/updateStatus/:id' element={<UpdateTaskStatus/>}></Route>

      </Routes>
    </Router>
    </>
  )
}

export default App