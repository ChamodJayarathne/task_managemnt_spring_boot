/* eslint-disable jsx-a11y/anchor-is-valid */

const Navbar = () => {
    return (
      <>
          <div>
      <nav className="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
        <nav className="navbar navbar-expand-lg bg-body-tertiary">
          <div className="container-fluid">
            <a className="navbar-brand spacing" href="#">Task Management System</a>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
             <span className="navbar-toggler-icon"></span>
            </button>
          <div className="collapse navbar-collapse" id="navbarNav">
         <ul className="navbar-nav">
            <li className="nav-item">
              <a className="nav-link active spacing" aria-current="page" href="/">Home</a>
            </li>
           <li className="nav-item">
              <a className="nav-link spacing" href="/dashboard">Dashboard</a>
           </li>
          <li className="nav-item">
            <a className="nav-link spacing" href="/assignTask">Task Assign</a>
          </li>
          <li className="nav-item">
            <a className="nav-link spacing" href="/login">Login</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
      </nav>
      </div>
      </>
    )
  }
  
  export default Navbar