import axios from "axios";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const Login = () => {
  const navigate = useNavigate();

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const login = async () => {
    try {
      const response = await axios.post(
        "http://localhost:8080/api/v1/users/login",
        {
          username,
          password,
        }
      );
      alert("Login Successfully");

      console.log(response);
      navigate("/dashboard");

      setUsername("");
      setPassword("");
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
              <div className="card col-md-6 offset-md-3">
                <br />
                <h3 className="text-center">Login</h3>
                <div className="card-body">
                  <div className="form-group">
                    <label htmlFor="usernamr" className="form-label">
                      Username
                    </label>
                    <input
                      type="text"
                      className="form-control input-item"
                      onChange={(e) => {
                        setUsername(e.target.value);
                      }}
                      id="username"
                      name="username"
                      autoComplete="username"
                      required
                    />
                  </div>
                  <br />

                  <div className="form-group">
                    <label htmlFor="inputPassword" className="form-label">
                      Password
                    </label>
                    <input
                      type="password"
                      id="password"
                      onChange={(e) => {
                        setPassword(e.target.value);
                      }}
                      className="form-control input-item"
                      name="password"
                      autoComplete="current-password"
                      required
                    />
                  </div>
                </div>
                <br />

                <div className="d-grid gap-2 col-8 mx-auto">
                  <button
                    className="btn btn-primary"
                    type="button"
                    onClick={() => {
                      login();
                    }}
                  >
                    Login
                  </button>
                  <span className="text-center">OR</span>
                  <Link
                    className="btn btn-outline-dark"
                    type="button"
                    to={"/signup"}
                    style={{ marginBottom: 30 }}
                  >
                    Create New Account
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

export default Login;
