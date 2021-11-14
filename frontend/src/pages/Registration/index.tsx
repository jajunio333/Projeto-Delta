import Footer from "components/Footer";
import NavBar from "components/NavBar";

function Registration() {
  return (
    <>
      <NavBar />
      <div className="container jumbotron">
        <h1 className="display-4">Adicionar aluno</h1>
        <input
          type="text"
          className="form-control"
          placeholder="Insira aqui o nome do aluno"
          aria-describedby="basic-addon1"
        ></input><br />
        <input
          type="text"
          className="form-control"
          placeholder="Insira aqui o endereço do anluno"
          aria-describedby="basic-addon1"
        ></input><br />
        <button type="button" className="btn btn-primary btn-lg bg-primary ">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="25"
            height="25"
            fill="currentColor"
            className="bi bi-image-fill "
            viewBox="0 0 16 16"
            >
            <path d="M.002 3a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2h-12a2 2 0 0 1-2-2V3zm1 9v1a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V9.5l-3.777-1.947a.5.5 0 0 0-.577.093l-3.71 3.71-2.66-1.772a.5.5 0 0 0-.63.062L1.002 12zm5-6.5a1.5 1.5 0 1 0-3 0 1.5 1.5 0 0 0 3 0z"></path>
          </svg>
          &nbsp;&nbsp;Adicionar foto
        </button><p></p>
        <button type="button" className="btn btn-secondary btn-lg  col-sm-1 py-2">Enviar</button>
      </div>
      <Footer />
    </>
  );
}

export default Registration;
