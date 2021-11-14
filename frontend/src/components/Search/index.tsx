function Buscador() {
    return (
        <nav className="navbar navbar-light bg-light">
        <form className="form-inline">
          <input className="form-control mr-sm-2" type="search" placeholder="Insira o Id Do aluno" aria-label="Pesquisar"/>
          <button className="btn btn-outline-success my-2 my-sm-2" type="submit">Pesquisar</button>
        </form>
      </nav>
    );
  }
  
  export default Buscador;