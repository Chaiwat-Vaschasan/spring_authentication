import axios from 'axios';

export const  IsAuth = () => {
    let token = localStorage.getItem("access_token")
    return token != null && token != undefined;
}

export const GetToken =  (code) => {

    let baseUrl = import.meta.env.VITE_AUTH_URL;
    const params = new URLSearchParams();
    params.append('code', code);
    params.append('grant_type', 'authorization_code');
    params.append('redirect_uri', import.meta.env.VITE_AUTH_REDIRECT_URI);

    return axios.post(baseUrl + '/oauth2/token',params, { 
        auth: {
            username: import.meta.env.VITE_AUTH_CLIENT_ID,
            password: import.meta.env.VITE_AUTH_CLIENT_SECRET
        },
        headers:{'Content-Type': 'application/x-www-form-urlencoded'}
    });
}

export const RefaceToken = () => {

    let baseUrl = import.meta.env.VITE_AUTH_URL;
    const params = new URLSearchParams();
    params.append('refresh_token', localStorage.getItem('refresh_token'));
    params.append('grant_type', 'refresh_token');

    return axios.post(baseUrl + '/oauth2/token',params, { 
        auth: {
            username: import.meta.env.VITE_AUTH_CLIENT_ID,
            password: import.meta.env.VITE_AUTH_CLIENT_SECRET
        },
        headers:{'Content-Type': 'application/x-www-form-urlencoded'}
    });
}

export const SetToken = (token) => {
    localStorage.setItem('access_token',token.access_token);
    localStorage.setItem('refresh_token',token.refresh_token);
}

export const ClearToken = () => {
    localStorage.removeItem('access_token');
    localStorage.removeItem('refresh_token');
}

