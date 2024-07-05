/* eslint-disable jsx-a11y/img-redundant-alt */

import "../../App.css";
import Navbar from "../navbar/Navbar";
import cover from "../../assets/cover.png";

const Home = () => {
  return (
    <>
      <Navbar />
      <br />
      <h1 className="text-center">Welcome to Task Management System</h1>
      <br />
      <img src={cover} alt="cover image" className="image" />
    </>
  );
};

export default Home;
