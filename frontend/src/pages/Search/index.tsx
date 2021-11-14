/* eslint-disable jsx-a11y/img-redundant-alt */
import Footer from "components/Footer";
import NavBar from "components/NavBar";
import Buscador from "components/Search";
import logo from "assets/img/fulano.jpg";

function Search() {
  return (
    <>
      <NavBar />
      <div className="container jumbotron">
        <h1 className="display-4">Pesquisar Aluno</h1>
        <Buscador/><br />
        <div className="container card w-25"><br />
            <img className="card-img-top" src={logo} alt="Card image cap" height="300"/>
          <div className="card-body">
            <h5 className="card-title">Fulano de Tal</h5>
            <p className="card-text">
              Rua Maria Das Graças, numero 25.
            </p>
          </div>
          <div className="card-body">
            <a href="/" className="card-link">
              Atualizar
            </a>
            <a href="/" className="card-link">
              Deletar
            </a>
          </div>
        </div>
      </div><br />
      <Footer />
    </>
  );
}

export default Search;
