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
            <img src={logo} alt="Card image cap" height="300"/>
          <div className="card-body">
            Nome: <input type="text" value="Fulano de Tal" /> 
            Endereço: <input type="text" value="Rua Pirapora, número 21" /> 
          </div>
          <div className="container card-body">
            <button type="button" className="btn btn-warning btn-lg">Atualizar</button>
            &nbsp;
            <button type="button" className="btn btn-danger btn-lg">Deletar</button>
          </div>
        </div>
      </div><br />
      <Footer />
    </>
  );
}

export default Search;
