import axios from "axios";

const apiClient = axios.create({
  baseURL: `http://${window.location.hostname}:8081/api/specializations`,
  headers: {
    "Content-Type": "application/json",
    withCredentials: true,
  },
});

export default {
  getSpecializations() {
    return apiClient.get("");
  },
};
