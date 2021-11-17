import axios from "axios";
import AddImage from "components/AddImage";
import Footer from "components/Footer";
import NavBar from "components/NavBar";
import { useState, Fragment } from "react";
import { BASE_URL } from "utils/requests";
import { Aluno } from "types/alunos";
import { useHistory } from "react-router-dom";

function Registration() {
  const router = useHistory();
  const [inputNome, setNome] = useState("");
  const [inputEnd, setEnd] = useState("");
  const [inputImage, setImage] = useState("");
  const handleChangeNome = (e: any) => {
    setNome(e.target.value);
  };
  const handleChangeEnd = (e: any) => {
    setEnd(e.target.value);
  };

  function cadastrar() {
    if (!(inputNome && inputEnd && inputImage)) {
      alert("Todos os dados devem ser preenchidos");
    } else {
      const aluno: Aluno = {
        id: 0,
        nome: inputNome,
        endereco: inputEnd,
        foto: inputImage,
      };
      axios
        .post(`${BASE_URL}/novo-aluno`, aluno)
        .then((response) => {
          if (response.status === 200) {
            alert("sucesso");
            router.push("/");
          } else alert("falhou!");
        })
        .catch((e) => {
          alert("ocorreu um erro: " + e);
        });
    }
  }

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
          name="nome"
          value={inputNome}
          onChange={(e) => handleChangeNome(e)}
        />
        <br />
        <input
          type="text"
          className="form-control"
          placeholder="Insira aqui o endereço do anluno"
          aria-describedby="basic-addon1"
          name="endereço"
          value={inputEnd}
          onChange={handleChangeEnd}
        />
      </div>
      <div className="text-center">
        <p>Selecione uma Foto:</p>
        <AddImage onChangeImage={(base64: string) => setImage(base64)} />
        <br />
        <button
          type="button"
          onClick={() => cadastrar()}
          className="btn btn-secondary btn-lg mx-auto"
        >
          Enviar
        </button>
      </div>
      <br />
      <Footer />
    </>
  );
}

export default Registration;
