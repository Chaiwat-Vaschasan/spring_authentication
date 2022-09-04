import {Navigate} from 'react-router-dom';
import {IsAuth} from '../service/auth.service';

const ProtectedRoute = ({children }) => {
    if (!IsAuth()) {
      return <Navigate to="/authorized" replace />;
    }

    return children;
  };

  export default ProtectedRoute;