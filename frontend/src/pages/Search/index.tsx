import axios from "axios";
import Footer from "components/Footer";
import NavBar from "components/NavBar";
import { useState } from "react";
import { useHistory } from 'react-router-dom';
import { Aluno } from "types/alunos";
import { BASE_URL } from "utils/requests";

function Search() {
  let [aluno, setAluno] = useState<Aluno>({
    id: 0,
    nome: "",
    endereco: "",
    foto: "",
  });

  const router = useHistory();
  const defaultImage = "data:image/jpeg;base64,";
  const resultImage = aluno.foto;
  const image = `${defaultImage}${resultImage}`;

  const [nomeAlunoInput, setNome] = useState("");
  const [enderecoAlunoInput, setEnd] = useState("");
  const [inputId, setId] = useState("");
  const handleChangId = (e: any) => {
    setId(e.target.value);
  };
  const hanleChangeNome = (e: any) => {
    setNome(e.target.value);
  };
  const hanleChangeEnd = (e: any) => {
    setEnd(e.target.value);
  };

  function buscar() {
    axios
      .get(`${BASE_URL}/alunos/${inputId}`)
      .then((response) => {
        if (response.status === 200) setAluno(response.data);
        else alert("falhou!");
      })
      .catch((e) => {
        console.error(e);
        alert("ocorreu um erro, ou o aluno não foi criado  " + e);
      });
  }

  function keyUpId(e: any) {
    if (e.key === "Enter") {
      buscar();
    }
  }

  function atualizar(aluno: Aluno) {
    aluno.nome = nomeAlunoInput;
    aluno.endereco = enderecoAlunoInput;
    axios
      .put(`${BASE_URL}/alunos/atualizar/${aluno.id}`, aluno)
      .then((response) => {
        if (response.status === 200){ 
          alert("sucesso");
          router.push('/');
        }
        else alert("falhou!");
      })
      .catch((e) => {
        alert("ocorreu um erro: " + e);
      });
  }
  function deletar(aluno: Aluno) {
    axios
      .delete(`${BASE_URL}/aluno/delete/${aluno.id}`)
      .then((response) => {
        if (response.status === 200) { 
          alert("sucesso");
          router.push('/');
        }
        else alert("falhou!");
      })
      .catch((e) => {
        alert("ocorreu um erro: " + e);
      });
  }

  return (
    <>
      <NavBar />
      <div className="container jumbotron">
        <h1 className="display-4">Pesquisar Aluno</h1>
        <nav className="navbar navbar-light bg-light">
          <form className="form-inline"
          onKeyPress={(e) => {
            if (e.key === 'Enter') e.preventDefault();
          }}>
            <div className="input-group">
              <div className="input-group-prepend">
                <span className="input-group-text" id="basic-addon1">
                  ID
                </span>
              </div>
              <input
                type="text"
                className="form-control"
                placeholder="Insira o Id do Aluno"
                aria-label="Usuário"
                aria-describedby="basic-addon1"
                value={inputId}
                onChange={(e) => handleChangId(e)}
                onKeyUp={(e: React.KeyboardEvent<HTMLDivElement>) => keyUpId(e) }
              />
              &nbsp;
              <div>
                <button
                  type="button"
                  onClick={() => buscar()}
                  className="btn btn-primary "
                >
                  buscar
                </button>
              </div>
            </div>
          </form>
        </nav>

        <br />
        <div className="container card w-25">
          <br />
          <img src={image} alt="" height="300" />
          <div className="card-body">
            Nome: {aluno.nome}
            <input
              type="text"
              placeholder="Alterar Nome"
              value={nomeAlunoInput}
              onChange={(e) => hanleChangeNome(e)}
            />
            Endereço: {aluno.endereco}
            <input
              type="text"
              placeholder="Alterar Endereço"
              value={enderecoAlunoInput}
              onChange={(e) => hanleChangeEnd(e)}
            />
          </div>
          <div className="container card-body">
            <button
              type="button"
              onClick={() => atualizar(aluno)}
              className="btn btn-warning btn-lg"
            >
              Atualizar
            </button>
            &nbsp;
            <button
              type="button"
              onClick={() => deletar(aluno)}
              className="btn btn-danger btn-lg"
            >
              Deletar
            </button>
          </div>
        </div>
      </div>
      <br />
      <Footer />
    </>
  );
}

export default Search;
