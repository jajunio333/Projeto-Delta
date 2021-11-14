import Home from 'pages/Home';
import Registration from 'pages/Registration';
import Search from 'pages/Search';
import { BrowserRouter, Route, Switch} from 'react-router-dom';

function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact>
                    <Home/>
                </Route>
                <Route path="/registration">
                    <Registration />
                </Route>
                <Route path="/search">
                    <Search />
                </Route>
            </Switch>
        </BrowserRouter>
    );
  }
  
  export default Routes;
  