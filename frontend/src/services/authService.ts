import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://localhost:8081/api/",
  headers: {
    "Content-Type": "application/json",
  },
});

export default {
  login(credentials: credentials) {
    return apiClient.post("auth/authenticate", credentials);
  },
  register(registerData: RegisterData) {
    return apiClient.post("auth/register", registerData);
  },
};
