
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import Authorized from '../page/authorized/Authorized';
import NotMatch from '../page/notmatch/NotMatch';
import Home from '../page/home/Home'
import ProtectedRoute from '../companent/ProtectedRoute';


const App = () => {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/authorized" element={<Authorized />} />
        <Route path="/" element={<ProtectedRoute><Home /></ProtectedRoute> } />
        <Route path="*" element={<NotMatch />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
