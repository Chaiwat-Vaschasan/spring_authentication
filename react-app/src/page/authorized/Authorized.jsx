import React, { useState, useEffect } from 'react';
import { useNavigate, useSearchParams, } from "react-router-dom";
import { GetToken , SetToken} from '../../service/auth.service';

const Authorized = () => {

  let [searchParams, setSearchParams] = useSearchParams();
  let navigate = useNavigate();

  useEffect(() => {
    let code = searchParams.get("code");
    authorizedCode(code);
  }, []);

  const authorizedCode = (code) => {
    if (code != null && code != undefined) {
      GetToken(code).then(res => {
        console.log(res.data);
        SetToken(res.data);
        navigate('/');
      }).catch(e => console.log(e));
    } else {
      window.location.replace(import.meta.env.VITE_AUTH_LOGIN_PATH);
    }
  }

  return (
    <div>Authorized</div>
  )
}



export default Authorized