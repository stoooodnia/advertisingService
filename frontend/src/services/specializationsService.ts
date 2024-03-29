import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://localhost:8081/api/specializations",
  headers: {
    "Content-Type": "application/json",
  },
});

export default {
  getSpecializations() {
    return apiClient.get("");
  },
};
