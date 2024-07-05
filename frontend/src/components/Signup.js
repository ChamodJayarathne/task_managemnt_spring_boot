import axios from "axios";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const Signup = () => {
  const navigate = useNavigate();

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState("");

  const signup = async () => {
    try {
      const response = await axios.post(
        "http://localhost:8080/api/v1/users/register",
        {
          username,
          password,
          role,
        }
      );
      alert("Registation Successfully");

      console.log(response);
      navigate("/login");

      setUsername("");
      setPassword("");
      setRole("");
    } catch (e) {
      console.log(e);
    }
  };

  return (
    <>
      <br />
      <div>
        <form>
          <div className="container">
            <div className="row">
              <div className="card col-md-5 offset-md-3">
                <br />
                <h2 className="text-center">Sign Up</h2>
                <div className="card-body content">
                  {/* <div className="form-group">
                            <label htmlFor="fullName" className="form-label">Full Name</label>
                            <input type="text" id='fullName' name='fullName'
                                className='form-control input-item' autoComplete="given-name" required/>
                        </div> */}

                  <div className="form-group">
                    <label htmlFor="username" className="form-label">
                      Username
                    </label>
                    <input
                      type="text"
                      id="username"
                      name="username"
                      onChange={(e) => {
                        setUsername(e.target.value);
                      }}
                      className="form-control input-item"
                      autoComplete="given-name"
                      required
                    />
                  </div>
                  <br />

                  <div className="form-group">
                    <label htmlFor="password" className="form-label">
                      Password
                    </label>
                    <input
                      type="password"
                      name="password"
                      id="password"
                      onChange={(e) => {
                        setPassword(e.target.value);
                      }}
                      className="form-control input-item"
                      autoComplete="current-password"
                      required
                    />
                  </div>
                  <br />

                  <div className="form-group">
                    <label htmlFor="role" className="form-label">
                      Role
                    </label>
                    <input
                      type="text"
                      name="role"
                      id="role"
                      onChange={(e) => {
                        setRole(e.target.value);
                      }}
                      className="form-control input-item"
                      autoComplete="usernamme"
                      required
                    />
                  </div>
                </div>
                <br />

                <div className="d-grid gap-2 col-8 mx-auto">
                  <button
                    className="btn btn-primary"
                    type="submit"
                    onClick={() => {
                      signup();
                    }}
                  >
                    Sign Up
                  </button>
                  <span className="text-center">OR</span>
                  <Link
                    className="btn btn-outline-dark"
                    type="button"
                    to={"/login"}
                    style={{ marginBottom: 30 }}
                  >
                    Already have an Account
                  </Link>
                </div>
              </div>
            </div>
          </div>
        </form>
      </div>
    </>
  );
};

export default Signup;
