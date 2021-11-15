function Buscador() {
    return (
      <nav className="navbar navbar-light bg-light">
      <form className="form-inline">
        <div className="input-group">
          <div className="input-group-prepend">
            <span className="input-group-text" id="basic-addon1">ID</span>
          </div>
          <input type="text" className="form-control" placeholder="Insira o Id do Aluno" aria-label="Usuário" aria-describedby="basic-addon1"/>
        </div>
      </form>
    </nav>
    );
  }
  
  export default Buscador;