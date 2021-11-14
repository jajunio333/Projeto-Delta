import logo from "assets/img/logo.jpeg";

function Footer() {
  return (
    <footer className="footer mt-auto py-3 bg-dark">
      <div className="container">
        <p className="text-light">
          App desenvolvido por{" "}
          <a
            href="https://github.com/jajunio333/Projeto-Delta"
            target="_blank"
            rel="noreferrer"
          >
            Jurandir Alves Jr
          </a>{" "}&nbsp;&nbsp;
          <img src={logo} alt="falhou" width="80" height="60" />
        </p>
      </div>
    </footer>
  );
}

export default Footer;
