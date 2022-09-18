import axios from 'axios';
import {SetToken , ClearToken ,RefaceToken} from './auth.service';

const httpClient = axios.create();
httpClient.interceptors.request.use(
    (config) => {
        let accessToken = localStorage.getItem('access_token')
        config.headers ={
            ...config.headers,
            authorization: `Bearer ${accessToken}`
        }
        return config;
    },
    (error) => Promise.reject(error)
);

httpClient.interceptors.response.use(
    (response) => response,
    async (error) => {
        const config = error?.config;
        if(error?.response?.status === 401 && !config?.sent){
            config.sent = true;
            try {
                let refaceToken = await RefaceToken();
                SetToken(refaceToken.data);
                let accessToken = localStorage.getItem('access_token');
                config.headers ={...config.headers, authorization: `Bearer ${accessToken}`}
                return axios(config);
            } catch (error) {
                ClearToken();
                window.location.replace('/authorized');
                return Promise.reject(error);
            }
        }else if(error?.response?.status === 401 && config?.sent){
            ClearToken();
            window.location.replace('/authorized');
            return Promise.reject(error);
        }
        return Promise.reject(error);
    }
)

export default httpClient;