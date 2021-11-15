import AddImage from "components/AddImage";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

function Registration() {
  return (
    <>
      <NavBar />
      <div className="container jumbotron">
        <h1 className="display-4">Adicionar aluno</h1>
      </div>
      <div className="container w-50 p-3">
        <input
          type="text"
          className="form-control"
          placeholder="Insira aqui o nome do aluno"
          aria-describedby="basic-addon1"
        ></input>
        <br />
        <input
          type="text"
          className="form-control"
          placeholder="Insira aqui o endereço do anluno"
          aria-describedby="basic-addon1">
          </input>
      </div>
      <div className="text-center">
        <p>Selecione uma Foto:</p>
        <AddImage />
        <br />
        <button type="button" className="btn btn-secondary btn-lg mx-auto">Enviar</button></div>
        <br />
      <Footer />
    </>
  );
}

export default Registration;
