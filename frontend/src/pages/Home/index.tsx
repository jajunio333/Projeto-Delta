import Footer from "components/Footer";
import NavBar from "components/NavBar";
import { Link } from "react-router-dom";

function Home() {
  return (
    <>
      <NavBar />
      <div className="container">
        <div className="jumbotron">
          <h1 className="display-4">DS Alunos</h1>
          <p className="lead">
            Gerencie seus alunos de forma fácil!
          </p>
          <hr />
          <p>
            Esta aplicação consiste em exibir um painel com informações de
            alunos a partir de dados fornecidos por um back end construído com
            Spring Boot.
          </p>
          <div className="container text-center py-5">
            <Link className="btn btn-primary btn-lg bg-primary" to="/search">
              Buscar aluno
            </Link>
            <br /> <br />
            <Link className="btn btn-primary btn-lg bg-primary" to="/registration">
              Adicionar aluno
            </Link>
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
}

export default Home;
